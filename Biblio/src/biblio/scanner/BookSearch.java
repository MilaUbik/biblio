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
                    this.book = createBook(entryBook);
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
        if (entry.getDescriptions().size() != 0) {
            book.setDescription(entry.getDescriptions().get(0).getValue());
        }
        if (root != null) {
            InputStream inStream = null;
            try {
                Link link = new Link();
                link.setHref(root.toString());
                ServiceSingleton service = ServiceSingleton.getServiceSingleton();
                inStream = service.getStreamFromLink(link);
                Image input = ImageIO.read(inStream);
                if (input != null) {
                    BufferedImage buff = new BufferedImage(input.getWidth(null), input.getHeight(null), BufferedImage.TYPE_INT_RGB);
                    buff.getGraphics().drawImage(input, 0, 0, null);
                    imageFile = File.createTempFile("coverTmp", ".jpg");
                    ImageIO.write(buff, "jpg", imageFile);
                    book.setCover(imageFile.getAbsolutePath());
                }
            } catch (IOException ex) {
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ServiceException ex) {
                Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    inStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(BookSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
