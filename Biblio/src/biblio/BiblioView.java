/*
 * This file is part of Biblio.
 *
 *     Biblio is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Biblio is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Biblio.  If not, see <http://www.gnu.org/licenses/>.
 */
package biblio;

import java.net.MalformedURLException;
import org.loftjob.model.BookTableModel;
import org.loftjob.model.Picture;
import be.pwnt.jflow.event.ShapeEvent;
import be.pwnt.jflow.event.ShapeListener;
import biblio.accounts.google.GoogleBooks;
import biblio.accounts.google.ServiceSingleton;
import biblio.listener.DirWatcher;
import biblio.scanner.CoverSearch;
import biblio.scanner.Gui;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;
import java.util.TimerTask;
import java.util.TreeSet;
import javax.swing.DefaultListSelectionModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import org.loftjob.model.Book;
import org.loftjob.engine.Engine;
import org.loftjob.model.BookPanel;
import org.mozilla.browser.IMozillaWindow.VisibilityMode;
import org.mozilla.browser.MozillaPanel;

/**
 * The application's main frame.
 */
public class BiblioView extends FrameView  {

    private String data = Engine.getFolderLibrary();

    public BiblioView(SingleFrameApplication app) {        
        super(app);
        Properties prop = new Properties();
        try {
            FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
            prop.load(reader);
            data = (String) prop.get("data");
        } catch (IOException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        initData();
        initComponents();
        

        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String) (evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer) (evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
        authors.setSelectionRow(0);
        booksTable.getSelectionModel().setLeadSelectionIndex(0);
        Book book = ((BookTableModel)booksTable.getModel()).getColumnBook(0);
        bookDetail.setData(book);
        String s = book.getAuthor().replaceAll(" ", "_");
         String url = "http://it.wikipedia.org/wiki/".replace("it", Locale.getDefault().getLanguage()) + s;
        URL helpURL;
        try {
            helpURL = new URL(url);
            if (helpURL == null) {
                        System.err.println("Couldn't open help file: " + url);
                    } else {
                        //   System.out.println("Help URL is " + helpURL);
                        p.load(url);

                    }
        } catch (MalformedURLException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = BiblioApp.getApplication().getMainFrame();
            aboutBox = new BiblioAboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        BiblioApp.getApplication().show(aboutBox);
    }

    @SuppressWarnings({"unchecked", "empty-statement"})
    private void initData() {
        that = this;
        try {
            bookList = Engine.readFromFile(data);
            int i = 0;
            Set<Book> surname = new TreeSet<Book>();
            for (int x = 0; x < bookList.size(); x++) {
                surname.add(bookList.get(x));
            }
            authorList = new Book[surname.size()];
            authorList = surname.toArray(authorList);
            Arrays.sort(authorList);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }

        final TimerTask task = new DirWatcher(data, "") {

            @Override
            protected void onChange(File file2, String action2) {

                final String action = action2;
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        if (!action.equalsIgnoreCase("delete")) { //$NON-NLS-1$
                            try {
                                //$NON-NLS-1$
                                System.out.println("file add"); //$NON-NLS-1$
                                //read from folder all book
                                bookList = Engine.readFromFile(data);
                                DefaultTreeModel modelTree = (DefaultTreeModel) authors.getModel();
                                DefaultMutableTreeNode root = (DefaultMutableTreeNode) modelTree.getRoot();
                                DefaultMutableTreeNode[] newBook = new DefaultMutableTreeNode[authorList.length];
                                //remove author nodes
                                for (int x = authorList.length - 1; x >= 0; x--) {
                                    root.remove(x);
                                    // modelTree.removeNodeFromParent((MutableTreeNode) ));
                                }
                                //get new authors set
                                Set<Book> surname = new TreeSet<Book>();
                                for (int x = 0; x < bookList.size(); x++) {
                                    surname.add(bookList.get(x));
                                }
                                authorList = new Book[surname.size()];
                                authorList = (Book[]) surname.toArray(authorList);
                                newBook = new DefaultMutableTreeNode[authorList.length];
                                //add new authors set
                                for (int x = 0; x < authorList.length; x++) {
                                    newBook[x] = new DefaultMutableTreeNode(authorList[x]);
                                    root.add(newBook[x]);
                                    modelTree.setRoot(root);
                                }
                                 BookTableModel tableModel = (BookTableModel) booksTable.getModel();
                                if(tableModel.getRowCount() != bookList.size()){
                                    tableModel.fireTableDataChanged(bookList);
                                }
                                jPanel1 = new org.loftjob.model.JFlowPanel(new Configuration(bookList));
                                jTabbedPane2.remove(0);
                                jPanel1.setName("CoverView"); // NOI18N
                                ((org.loftjob.model.JFlowPanel) jPanel1).addListener(new ShapeListener() {

                                    @Override
                                    public void shapeClicked(ShapeEvent e) {
                                        MouseEvent me = e.getMouseEvent();
                                        if (!me.isConsumed() && me.getButton() == MouseEvent.BUTTON1
                                                && me.getClickCount() == 1) {
                                            final Book book = ((Picture) e.getShape()).getBook();
                                            for (int x = 0; x < bookList.size(); x++) {
                                                Book tmp = ((BookTableModel) booksTable.getModel()).getColumnBook(x);
                                                if (tmp.equals(book)) {

                                                    booksTable.getSelectionModel().setSelectionInterval(0, x);
                                                    booksTable.scrollRectToVisible(booksTable.getCellRect(booksTable.getSelectedRow(), 0, true));

                                                    jTabbedPane1.setSelectedIndex(1);
                                                    break;
                                                }

                                            }
                                        }
                                    }

                                    @Override
                                    public void shapeActivated(ShapeEvent e) {
                                    }

                                    @Override
                                    public void shapeDeactivated(ShapeEvent e) {
                                    }
                                });
                                authors.setSelectionRow(0);
                                jTabbedPane2.add("CoverFlow", jPanel1);
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);

                            }

                        }
                    }
                });


            }

            ;
        };


        final ActionListener action = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                task.run();

            }
        };
        new Timer(1000, action).start();
    }

    private void authorsValueChanged(javax.swing.event.TreeSelectionEvent evt) {
        // TODO add your handling code here:

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) authors.getLastSelectedPathComponent();
        if (node != null) {
            Book book = (Book) node.getUserObject();
            int x = 0;
            for (; x < bookList.size(); x++) {
                String tmp = (String) booksTable.getValueAt(x, 0);
                if (tmp.contains(book.getAuthor())) {
                    booksTable.getSelectionModel().setSelectionInterval(0, x);
                    booksTable.scrollRectToVisible(booksTable.getCellRect(booksTable.getSelectedRow(), 0, true));
                    break;
                }
            }
        }

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        authors = new javax.swing.JTree(authorList);
        jSplitPane2 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        conf = new Configuration(bookList);
        jPanel1 = new org.loftjob.model.JFlowPanel(conf);
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        mainPanel.setName("mainPanel"); // NOI18N

        jSplitPane1.setName("jSplitPane1"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        authors.setName("authors");
        authors.setAlignmentX(0.0F);

        authors.setAlignmentY(0.0F);

        authors.setAutoscrolls(true);

        authors.setCellRenderer(new AuthorCellRender());

        authors.setRootVisible(false);

        authors.setVisibleRowCount(200);

        authors.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {

                authorsValueChanged(null);

            }
        });
        jScrollPane1.setViewportView(authors);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane2.setName("jSplitPane2"); // NOI18N
        jSplitPane2.setOpaque(true);

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        booksTable.setModel(new BookTableModel(bookList));
        booksTable.setFillsViewportHeight(true);
        booksTable.setName("Books");
        booksTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if(bookList.size() > 0){
            booksTable.getSelectionModel().setSelectionInterval(0, 0);
        }
        rowListener = new RowListener();
        booksTable.getSelectionModel().addListSelectionListener(rowListener);
        booksTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(booksTable);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(biblio.BiblioApp.class).getContext().getResourceMap(BiblioView.class);
        jTabbedPane1.addTab(resourceMap.getString("jScrollPane2.TabConstraints.tabTitle"), jScrollPane2); // NOI18N

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setAlignmentX(0.0F);
        jScrollPane4.setAlignmentY(0.0F);
        jScrollPane4.setHorizontalScrollBar(null);
        jScrollPane4.setMaximumSize(new java.awt.Dimension(0, 0));
        jScrollPane4.setName("jScrollPane4"); // NOI18N
        bookDetail = new BookDetail();
        jScrollPane4.setViewportView(bookDetail);

        JLabel label = new JLabel();
        label.setText(resourceMap.getString("jScrollPane4.TabConstraints.tabTitle"));
        label.setIcon(resourceMap.getIcon("jScrollPane4.TabConstraints.tabIcon"));

        jTabbedPane1.addTab(null, null, jScrollPane4);
        jTabbedPane1.setTabComponentAt(1, label);

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        p = new MozillaPanel(VisibilityMode.FORCED_HIDDEN,VisibilityMode.FORCED_HIDDEN);
        jScrollPane3.getViewport().setView(p);

        jTabbedPane1.addTab(resourceMap.getString("jScrollPane3.TabConstraints.tabTitle"), resourceMap.getIcon("jScrollPane3.TabConstraints.tabIcon"), jScrollPane3); // NOI18N

        jSplitPane2.setRightComponent(jTabbedPane1);

        jTabbedPane2.setName("jTabbedPane2"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N
        ((org.loftjob.model.JFlowPanel)jPanel1).addListener(new ShapeListener() {
            @Override
            public void shapeClicked(ShapeEvent e) {
                MouseEvent me = e.getMouseEvent();
                if (!me.isConsumed() && me.getButton() == MouseEvent.BUTTON1
                ) {
                    Book book =((Picture) e.getShape()).getBook();

                    for(int x = 0; x < bookList.size(); x++ ){
                        Book tmp = ((BookTableModel)booksTable.getModel()).getColumnBook(x);
                        if(tmp.equals(book)){

                            booksTable.getSelectionModel().setSelectionInterval(0, x);
                            booksTable.scrollRectToVisible(booksTable.getCellRect(booksTable.getSelectedRow(), 0, true));

                            break;
                        }

                    }

                }
            }

            @Override
            public void shapeActivated(ShapeEvent e) {
            }

            @Override
            public void shapeDeactivated(ShapeEvent e) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jSplitPane2.setLeftComponent(jTabbedPane2);

        jSplitPane1.setRightComponent(jSplitPane2);
        jSplitPane2.setDividerLocation(0.5);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N
        fileMenu.setName("fileMenu"); // NOI18N

        jMenuItem5.setIcon(resourceMap.getIcon("jMenuItem5.icon")); // NOI18N
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text")); // NOI18N
        jMenuItem5.setName("jMenuItem5"); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem5);

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(biblio.BiblioApp.class).getContext().getActionMap(BiblioView.class, this);
        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setIcon(resourceMap.getIcon("exitMenuItem.icon")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        jMenu1.setText(resourceMap.getString("jMenu1.text")); // NOI18N
        jMenu1.setName("jMenu1"); // NOI18N

        jMenuItem1.setIcon(resourceMap.getIcon("jMenuItem1.icon")); // NOI18N
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text")); // NOI18N
        jMenuItem1.setName("jMenuItem1"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setIcon(resourceMap.getIcon("jMenuItem2.icon")); // NOI18N
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem2.setName("jMenuItem2"); // NOI18N
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setIcon(resourceMap.getIcon("jMenuItem3.icon")); // NOI18N
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem3.setName("jMenuItem3"); // NOI18N
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setIcon(resourceMap.getIcon("jMenuItem4.icon")); // NOI18N
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem4.setName("jMenuItem4"); // NOI18N
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jSeparator1.setName("jSeparator1"); // NOI18N
        jMenu1.add(jSeparator1);

        jMenuItem12.setText(resourceMap.getString("jMenuItem12.text")); // NOI18N
        jMenuItem12.setName("jMenuItem12"); // NOI18N
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem12);

        menuBar.add(jMenu1);

        jMenu2.setText(resourceMap.getString("jMenu2.text")); // NOI18N
        jMenu2.setName("jMenu2"); // NOI18N

        jMenu3.setText(resourceMap.getString("jMenu3.text")); // NOI18N
        jMenu3.setName("jMenu3"); // NOI18N

        jMenuItem9.setIcon(resourceMap.getIcon("jMenuItem9.icon")); // NOI18N
        jMenuItem9.setText(resourceMap.getString("jMenuItem9.text")); // NOI18N
        jMenuItem9.setName("jMenuItem9"); // NOI18N
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuItem10.setIcon(resourceMap.getIcon("jMenuItem10.icon")); // NOI18N
        jMenuItem10.setText(resourceMap.getString("jMenuItem10.text")); // NOI18N
        jMenuItem10.setName("jMenuItem10"); // NOI18N
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem11.setIcon(resourceMap.getIcon("jMenuItem11.icon")); // NOI18N
        jMenuItem11.setText(resourceMap.getString("jMenuItem11.text")); // NOI18N
        jMenuItem11.setName("jMenuItem11"); // NOI18N
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem11);

        jMenu2.add(jMenu3);

        menuBar.add(jMenu2);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setIcon(resourceMap.getIcon("aboutMenuItem.icon")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(statusMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusMessageLabel)
                    .addComponent(statusAnimationLabel)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        jMenuItem6.setText(resourceMap.getString("jMenuItem2.text")); // NOI18N
        jMenuItem6.setName("Search Cover");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem6);

        jMenuItem7.setText(resourceMap.getString("jMenuItem3.text")); // NOI18N
        jMenuItem7.setName("jMenuItem7"); // NOI18N
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem7);

        jMenuItem8.setText(resourceMap.getString("jMenuItem4.text")); // NOI18N
        jMenuItem8.setName("jMenuItem8"); // NOI18N
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem8);

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Thread gui = new Gui();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        int selected = booksTable.getSelectionModel().getLeadSelectionIndex();
        Book book = ((BookTableModel) booksTable.getModel()).getColumnBook(selected);
        JFrame modifyBook = new JFrame("Modify Book");
        modifyBook.add(new BookPanel(book, bookList));
        modifyBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        modifyBook.pack();
        BiblioApp.getApplication().show(modifyBook);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void booksTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksTableMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            booksTable.setComponentPopupMenu(jPopupMenu1);
        }
    }//GEN-LAST:event_booksTableMouseClicked

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
//        /* Construct the print request specification.
//         * The print data is a Printable object.
//         * the request additonally specifies a job name, 2 copies, and
//         * landscape orientation of the media.
//         */
//        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
//        aset.add(OrientationRequested.LANDSCAPE);
//        aset.add(new Copies(2));
//        aset.add(new JobName("My job", null));
//
//        /* Create a print job */
//        PrinterJob pj = PrinterJob.getPrinterJob();
//        pj.setPrintable(bookDetail);
//        /* locate a print service that can handle the request */
//        PrintService[] services =
//                PrinterJob.lookupPrintServices();
//
//        if (services.length > 0) {
//            System.out.println("selected printer " + services[0].getName());
//            try {
//                pj.setPrintService(services[0]);
//                pj.pageDialog(aset);
//                if (pj.printDialog(aset)) {
//                    pj.print(aset);
//                }
//            } catch (PrinterException pe) {
//                System.err.println(pe);
//            }
//        }



    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        jMenuItem2ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        jMenuItem3ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        jMenuItem4ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        JFrame newBook = new JFrame("New Book");
        newBook.add(new BookPanel(null, bookList));
        newBook.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        BiblioApp.getApplication().show(newBook);


    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        GoogleBooks googleBooks = new GoogleBooks(GoogleBooks.ADD_BOOK, bookList);
        BiblioApp.getApplication().show(googleBooks);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
         GoogleBooks googleBooks = new GoogleBooks(GoogleBooks.REMOVE_BOOK, bookList);
        BiblioApp.getApplication().show(googleBooks);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 BookProgressMonitor progressMonitor = new BookProgressMonitor(bookList);
            }
        });
       
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
       Options dialog = new Options(new javax.swing.JFrame("Options"), true);
        BiblioApp.getApplication().show(dialog);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

     

    private class RowListener implements ListSelectionListener {

        @Override
        public void valueChanged(final ListSelectionEvent event) {
            final int selRow = ((DefaultListSelectionModel) event.getSource()).getAnchorSelectionIndex();
            if(selRow >= 0){
            final Book book = ((BookTableModel) booksTable.getModel()).getColumnBook(selRow);
            final String s = book.getAuthor().split(" ")[0].replace(" ", "_") + "_" + book.getAuthor().split(" ")[1].replace(" ", "_");

            SwingUtilities.invokeLater(new Runnable() {

                @Override
                public void run() {
                    bookDetail.setData(book);
                }
            });
            SwingWorker worker = new SwingWorker() {

                @Override
                protected Object doInBackground() throws Exception {
                    Book book = ((BookTableModel) booksTable.getModel()).getColumnBook(selRow);
                    String s = book.getAuthor().replaceAll(" ", "_");
                    String url = "http://it.wikipedia.org/wiki/".replace("it", Locale.getDefault().getLanguage()) + s;
                    URL helpURL = new URL(url);
                    if (helpURL == null) {
                        System.err.println("Couldn't open help file: " + url);
                    } else {
                        //   System.out.println("Help URL is " + helpURL);
                        p.load(url);

                    }
                    return null;
                }
            };
            worker.execute();
            }

        }
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        int selRow = booksTable.getSelectionModel().getLeadSelectionIndex();
        if (selRow >= 0) {
            Book book = ((BookTableModel) booksTable.getModel()).getColumnBook(selRow);
            //coverView = new CoverView(book);
            JFrame frame = new JFrame(" Search Cover");
            frame.setResizable(false);
            frame.add(new CoverSearch(book));
            BiblioApp.getApplication().show(frame);
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Select a book before", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree authors;
    private javax.swing.JTable booksTable;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables
    private List<Book> bookList;
    private Book[] authorList;
    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;
    private BookDetail bookDetail;
    private JDialog aboutBox;
    private Configuration conf;
    private CoverSearch coverSearch;
    private BiblioView that;
    private RowListener rowListener;
    private MozillaPanel p;
}
