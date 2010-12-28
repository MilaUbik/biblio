/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblio;

import org.loftjob.model.Picture;
import be.pwnt.jflow.Shape;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 */
public class Configuration extends be.pwnt.jflow.Configuration {

    private List<Book> bookList = new Vector<Book>();

    public Configuration(List<Book> bookList) {
        super();
         for (int x = 0; x < bookList.size(); x++) {
            if (bookList.get(x).getCover() != null && !bookList.get(x).getCover().trim().equals("")) {
                this.bookList.add(bookList.get(x));
            }
        }
       // this.bookList = bookList;
        shapes = new Shape[this.bookList.size()];
        for (int x = 0; x < this.bookList.size(); x++) {
                try {
                    Book book = this.bookList.get(x);
                    shapes[x] = new Picture(book);
                } catch (IOException ex) {
                    Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }



    }

