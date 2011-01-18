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
package biblio.accounts.google;

import biblio.JDialogLogin;
import com.google.gdata.client.books.VolumeQuery;
import com.google.gdata.data.books.VolumeEntry;
import com.google.gdata.data.books.VolumeFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 */
public class GoogleBooksAction {

    /**
     * The book to add
     */
    private Book book;

   
    /**
     * The name of the server hosting the YouTube GDATA feeds.
     */
    public static final String BOOKS_GDATA_SERVER = "http://books.google.com";
    /**
     * The URL of the volumes feed
     */
    public static final String VOLUMES_FEED = BOOKS_GDATA_SERVER
            + "/books/feeds/volumes";
    /**
     * The URL of the user library feeds
     */
    public static final String USER_LIBRARY_FEED = BOOKS_GDATA_SERVER
            + "/books/feeds/users/me/collections/4/volumes";
    /**
     * The URL of the user annotation feed
     */
    public static final String USER_ANNOTATION_FEED = BOOKS_GDATA_SERVER
            + "/books/feeds/users/me/volumes";
    

    private static void addBook(Book book) {
        try {
            VolumeEntry entry = searchVolumes(book, false);
            String volumeId = entry.getId();
            if (!volumeId.equals("")) {
                VolumeEntry newEntry = new VolumeEntry();
                newEntry.setId(volumeId);
                try {
                     ServiceSingleton service = ServiceSingleton.getServiceSingleton();
                    service.insert(new URL(USER_LIBRARY_FEED), newEntry);
                } catch (ServiceException se) {
                    se.printStackTrace();
                    System.out.println("There was an error adding your volume.\n");
                    return;
                }
                System.out.println("Added " + volumeId);
            }
        } catch (ServiceException ex) {
            Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void addBook(final List<Book> books) {
            String[] credential = Util.getAccount();
            if (credential[0] == null || credential[0].equalsIgnoreCase("")) {
            try {
                JDialogLogin dialog = new JDialogLogin(new javax.swing.JFrame(), true);
                credential = dialog.getCredentials();
                Util.saveAccount();
                ServiceSingleton service = ServiceSingleton.getServiceSingleton();
                service.setUserCredentials(credential[0], credential[1]);
            } catch (AuthenticationException ex) {
                Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
            }
               }
            if (credential[0] != null) {
                for (Book book : books) {
                    addBook(book);
                }
            }
    } 
                

    public static void removeBook(final List<Book> books) {
           String[] credential = Util.getAccount();
            if (credential[0] == null || credential[0].equalsIgnoreCase("")) {
            try {
                JDialogLogin dialog = new JDialogLogin(new javax.swing.JFrame(), true);
                credential = dialog.getCredentials();
                Util.saveAccount();
                ServiceSingleton service = ServiceSingleton.getServiceSingleton();
                service.setUserCredentials(credential[0], credential[1]);
            } catch (AuthenticationException ex) {
                Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if (credential[0] != null) {
                for (Book book : books) {
                   removeBook(book);
                }
            }
    }

    private static void removeBook(Book book) {

        try {
            VolumeEntry entry = searchVolumes(book, true);
            String volumeId = entry.getId();
            if (!volumeId.equals("")) {
                VolumeEntry newEntry = new VolumeEntry();
                newEntry.setId(volumeId);
                try {
                    entry.delete();
                } catch (ServiceException se) {
                    System.out.println("There was an error adding your volume.\n");
                    return;
                }
                System.out.println("Removed " + volumeId);
            }
        } catch (IOException ex) {
            Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(GoogleBooksAction.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Searches the VOLUMES_FEED for search terms and print each resulting
     * VolumeEntry.
     *
     * @param service a BooksService object.
     * @param authenticated whether the user is authenticated.
     * @throws ServiceException
     *                     If the service is unable to handle the request.
     * @throws IOException error sending request or reading the feed.
     */
    private static VolumeEntry searchVolumes(Book book, boolean userFeed)
            throws IOException, ServiceException {
        VolumeQuery query;
        if (userFeed) {
            query = new VolumeQuery(new URL(USER_LIBRARY_FEED));
        } else {
            query = new VolumeQuery(new URL(VOLUMES_FEED));
        }
        String isbn = book.getIsbn();
        query.setFullTextQuery("isbn:" + isbn);
        ServiceSingleton service = ServiceSingleton.getServiceSingleton();
        VolumeFeed volumeFeed = service.query(query, VolumeFeed.class);
        VolumeEntry entry = volumeFeed.getEntries().get(0);
        return entry;

    }
}
