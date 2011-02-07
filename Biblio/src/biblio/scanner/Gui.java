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
package biblio.scanner;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import au.edu.jcu.v4l4j.FrameGrabber;
import au.edu.jcu.v4l4j.V4L4JConstants;
import au.edu.jcu.v4l4j.VideoDevice;
import au.edu.jcu.v4l4j.exceptions.V4L4JException;
import biblio.BiblioApp;
import biblio.BiblioView;
import biblio.BookDetail;
import biblio.accounts.google.Util;
import com.google.gdata.data.Link;

import com.google.zxing.MonochromeBitmapSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageMonochromeBitmapSource;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.ResultParser;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.loftjob.engine.Engine;
import org.loftjob.model.Book;

/**
 * @author mila
 * 
 */
public class Gui extends Thread implements ActionListener {

    private JFrame f;
    private JLabel l;
    private JLabel cover;
    private FrameGrabber fg;
    private VideoDevice vd;
    private boolean stop = false;
    private String path = Engine.getFolderLibrary();
    private JFrame shell = new JFrame();
    private Book book = new Book();
    private JTextArea bookDetails = new JTextArea(book.toString(), 200, 300);


    public Gui() {
        Properties prop = new Properties();
        try {
            FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
            prop.load(reader);
            path = (String) prop.get("data");
        } catch (IOException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tmpImage = (String) prop.getProperty("tmpImage");
        String dev = (String) prop.get("cam");
        int w = Integer.parseInt((String) prop.get("camW"));
        int h = Integer.parseInt((String) prop.get("camH"));
        int std = V4L4JConstants.STANDARD_WEBCAM, channel = 0, qty = 60;
        initFrameGrabber(dev, w, h, std, channel, qty);
        this.start();
        if (!stop) {
            try {
                f = new JFrame("Scanner");
                GridBagLayout layout = new GridBagLayout();
                f.setLayout(layout);
                ImageIcon icon = new ImageIcon(new File(path + File.separator + tmpImage).toURI().toURL());
                Image imageTmp = icon.getImage().getScaledInstance(100, 300, Image.SCALE_DEFAULT);
                icon = new ImageIcon(imageTmp);
                l = new JLabel();
                l.setMinimumSize(new Dimension(300, 400));
                GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 0;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridheight = 2;
                gridBagConstraints.gridwidth = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                 gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                f.add(l, gridBagConstraints);
                cover = new JLabel();
                cover.setMinimumSize(new Dimension(100, 300));
                cover.setIcon(icon);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 1;
                gridBagConstraints.gridheight = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
                f.add(cover, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 1;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 1;
                gridBagConstraints.gridheight = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
                Button save = new Button("Save");
                save.addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (book.getCover() != null) {
                            try {
                                Util.saveImage(book, new URL("file://" + book.getCover()));
                            } catch (MalformedURLException ex) {
                                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                });
                save.setMinimumSize(new Dimension(100, 30));
                f.add(save, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 0;
                gridBagConstraints.gridwidth = 2;
                gridBagConstraints.gridheight = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.CENTER;
                bookDetails.setMinimumSize(new Dimension(200, 300));
                JScrollPane scrollDetails = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                scrollDetails.setViewportView(bookDetails);
                f.add(scrollDetails, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 2;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 1;
                gridBagConstraints.gridheight = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
                Button exit = new Button("Exit");
                exit.setMinimumSize(new Dimension(100, 30));
                f.add(exit, gridBagConstraints);
                gridBagConstraints = new java.awt.GridBagConstraints();
                gridBagConstraints.gridx = 3;
                gridBagConstraints.gridy = 1;
                gridBagConstraints.gridwidth = 1;
                gridBagConstraints.gridheight = 1;
                gridBagConstraints.insets = new Insets(0, 0, 0, 0);
                gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
                gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
                Button cancel = new Button("Cancel");
                cancel.setMinimumSize(new Dimension(100, 30));
                f.add(cancel, gridBagConstraints);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setMinimumSize(new Dimension(600, 400));
                //f.setResizable(false);
                f.pack();
                BiblioApp.getApplication().show(f);
            } catch (MalformedURLException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    /**
     * Initialises the FrameGrabber object with the given parameters
     *
     * @param dev
     *            the video device file to capture from
     * @param w
     *            the desired capture width
     * @param h
     *            the desired capture height
     * @param std
     *            the capture standard
     * @param channel
     *            the capture channel
     * @param qty
     *            the JPEG compression quality
     * @throws V4L4JException
     *             if any parameter if invalid
     */
    private void initFrameGrabber(String dev, int w, int h, int std,
            int channel, int qty) {
        try {
            vd = new VideoDevice(dev);
            fg = vd.getJPEGFrameGrabber(w, h, channel, std, qty);
            fg.startCapture();
            System.out.println("Starting capture at " + fg.getWidth() + "x"
                    + fg.getHeight());
        } catch (V4L4JException e) {
            e.printStackTrace();
            stop = true;
            JOptionPane.showMessageDialog(shell, "No web cam found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Updates the image shown in the JLabel
     *
     * @param b
     */
    public void setImage(byte[] b) {
        try {
            l.setIcon(new ImageIcon(new ImageIcon(b).getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT)));
        } catch (NullPointerException e) {
            // TODO: handle exception
            fg.stopCapture();
            vd.releaseFrameGrabber();
            vd.release();
            stop = true;
            f.dispose();
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub

        ByteBuffer bb;
        byte[] b = null;
        try {
            while (!stop) {
                File file = new File("tmp.jpg");
                file.deleteOnExit();
                URI uri = file.toURI();
                bb = fg.getFrame();
                b = new byte[bb.limit()];
                bb.get(b);
                if (b != null) {
                    setImage(b);
                }
                FileImageOutputStream imageOutput = new FileImageOutputStream(
                        file);
                imageOutput.write(b, 0, b.length);
                imageOutput.close();
                try {
                    FileImageInputStream imageInput = new FileImageInputStream(file);
                    BufferedImage image = ImageIO.read(imageInput);
                    if (image == null) {
                        System.err.println(uri.toString()
                                + ": Could not load image");
                    } else {
                        MonochromeBitmapSource source = new BufferedImageMonochromeBitmapSource(
                                image);
                        Result result = new MultiFormatReader().decode(source);
                        final ParsedResult parsedResult = ResultParser.parseResult(result);
                        fg.stopCapture();
                        BookSearch bookSearch = new BookSearch(null, parsedResult.getDisplayResult(), path, f);
                        bookDetails.selectAll();
                        bookDetails.cut();
                        bookDetails.setText(bookSearch.getBook().toString());
                        Image imageCover = ImageIO.read(new URL("file://" + new File(bookSearch.getBook().getCover().trim()).getAbsolutePath()));
                        if (imageCover != null) {
                            Image tmp = imageCover.getScaledInstance(100, 300, Image.SCALE_DEFAULT);
                            ImageIcon imageIcon = new ImageIcon(tmp);
                            cover.setIcon(imageIcon);
                        }
                        file.delete();
                        fg.startCapture();
                    }
                } catch (ReaderException e1) {
                    System.out.println(uri.toString() + ": No barcode found");
                    if (!f.isVisible()) {
                        file.delete();
                        fg.stopCapture();
                        vd.releaseFrameGrabber();
                        vd.release();
                        stop = true;
                    }
                } catch (MalformedURLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
                } catch (IOException e3) {
                    // TODO Auto-generated catch block
                    e3.printStackTrace();
                    JOptionPane.showMessageDialog(shell, "No connection", "Error", JOptionPane.ERROR_MESSAGE);
                    stop = true;
                    f.dispose();
                }
            }
            // actionPerformed(new ActionEvent(f, 0, null));

            // windowClosing(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
        } catch (V4L4JException e) {
            e.printStackTrace();
            System.out.println("Failed to capture image");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        f.dispose();
    }
}
