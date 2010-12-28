/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblio;

import biblio.accounts.google.GoogleBooksAction;
import biblio.accounts.google.ServiceSingleton;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.ProgressMonitor;
import javax.swing.SwingWorker;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 */
public class BookProgressMonitor extends JPanel
        implements PropertyChangeListener {

    private ProgressMonitor progressMonitor;
    private JEditorPane taskOutput;
    private Task task;
    private List<Book> bookList = new Vector<Book>();

    class Task extends SwingWorker<Void, Void> {

        @Override
        public Void doInBackground() {
            int progress = 0;
            setProgress(progress);
                while (progress < bookList.size() ) {
                    for (Book book : bookList) {
                        final List<Book> tmp = new Vector<Book>();
                        tmp.add(book);
                        GoogleBooksAction.addBook(tmp);
                        setProgress(Math.min(progress++, bookList.size()-1));
                    }
                }
             return null;
            } 
         

        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
        }

    }

    public BookProgressMonitor(List<Book> books) {
        super(new BorderLayout());
        this.bookList = books;
        taskOutput = new JEditorPane();
        taskOutput.setSize(5, 20);
        taskOutput.setMargin(new Insets(5,5,5,5));
        taskOutput.setEditable(false);
        progressMonitor = new ProgressMonitor(BookProgressMonitor.this,
                "Running a Long Task",
                "", 1, bookList.size());
        task = new Task();
        task.addPropertyChangeListener(this);
        task.execute();

    }

   
    /**
     * Invoked when task's progress property changes.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
            int progress = (Integer) evt.getNewValue();
            progressMonitor.setProgress(progress);
            String message ="Add "+bookList.get(progress).getTitle();
            progressMonitor.setNote(message);
            taskOutput.setText(message);
            if (progressMonitor.isCanceled() || task.isDone()) {
                Toolkit.getDefaultToolkit().beep();
                if (progressMonitor.isCanceled()) {
                    task.cancel(true);
                    taskOutput.setText("Task canceled.\n");
                } else {
                    taskOutput.setText("Task completed.\n");
                    progressMonitor.setNote("Completed");
                    progressMonitor.setProgress(0);
                    progressMonitor.close();
                }
            }
        }

    }
}



