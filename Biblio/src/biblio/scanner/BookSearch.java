package biblio.scanner;

import biblio.BiblioView;
import biblio.accounts.google.ServiceSingleton;
import biblio.accounts.google.Util;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



import com.google.gdata.client.books.VolumeQuery;
import com.google.gdata.data.Link;
import com.google.gdata.data.books.VolumeEntry;
import com.google.gdata.data.books.VolumeFeed;
import com.google.gdata.data.dublincore.Description;
import com.google.gdata.data.dublincore.Title;
import com.google.gdata.util.ServiceException;
import java.awt.Component;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.loftjob.engine.Engine;
import org.loftjob.model.Book;

public class BookSearch {

    private File imageFile = null;
    private String path = Engine.getFolderLibrary();
    private Book book = new Book();
    private URL root;
    private CoverSearch coverSearch;
    private String isbn = "";

    public BookSearch(Component parent, String isbn, String path, JFrame frame) {
        try {
            Properties prop = new Properties();
            try {
                FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
                prop.load(reader);
                path = (String) prop.get("data");
            } catch (IOException ex) {
                Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.path = path;
            this.isbn = isbn;
            ServiceSingleton service = ServiceSingleton.getServiceSingleton();
            VolumeQuery query = new VolumeQuery(new URL("http://www.google.com/books/feeds/volumes"));
            query.setFullTextQuery("isbn:" + this.isbn);
            System.out.println(query.getUrl());
            VolumeFeed volumeFeed;
            try {
                volumeFeed = service.query(query, VolumeFeed.class);
                if (!volumeFeed.getEntries().isEmpty()) {
                    VolumeEntry entry = volumeFeed.getEntries().get(0);
                    Link selfLink = entry.getSelfLink();
                    System.out.println(selfLink.getHref());
                    VolumeEntry entryBook = service.getEntry(new URL(selfLink.getHref()), VolumeEntry.class);
                    // entry = volumeFeed.getEntries().get(0);
                    Title t = entryBook.getTitles().get(0);
                    String description = "";
                    List<Description> desc = entryBook.getDescriptions();
                    for (Description d : desc) {
                        description = d.getValue();
                    }
                    String title = "";
                    title = title + " " + t.getValue();
                    System.out.println(title + "\t");
                    Link link = entryBook.getLinks().get(0);
                    if (link != null) {
                        System.out.println(link + "\t");
                        root = new URL(link.getHref());
                    }
                    //
                    //Fare un metodo in util che riceve IMAGE e la salva

                    this.book = createBook(entryBook);
                    Engine.createFromWS(this.book);
                    if (root != null) {
                        this.book.setCover(Util.saveImage(this.book, link));
                        Engine.createFromWS(this.book);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Nessuno libro trovato.", "Message", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (IOException ex) {
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Book createBook(VolumeEntry entry) {
        String author = "";

        if (entry.getCreators().size() != 0) {
            author = entry.getCreators().get(0).getValue();
            book.setAuthor(author);
        }
        if (entry.getPublishers().size() != 0) {
            book.setPublisher(entry.getPublishers().get(0).getValue().trim());
        }
        if (entry.getTitles().size() != 0) {
            book.setTitle(entry.getTitles().get(0).getValue().trim());
        }
        if (entry.getDates().size() != 0) {
            book.setYearEd(entry.getDates().get(0).getValue().trim());
        }
        if (imageFile != null) {
            book.setCover(imageFile.getAbsolutePath().trim());
        }
        if (entry.getDescriptions().size() != 0) {
            book.setDescription(entry.getDescriptions().get(0).getValue());
        }
        book.setIsbn(this.isbn);
        return book;
    }

    public Book getBook() {
        return book;
    }

    /**
     * @param args
     * @throws ServiceException
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, ServiceException {
        // TODO Auto-generated method stub
    }
}
