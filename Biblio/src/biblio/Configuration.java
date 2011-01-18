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

import java.io.FileNotFoundException;
import org.loftjob.model.Picture;
import be.pwnt.jflow.Shape;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.loftjob.engine.Engine;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 */
public class Configuration extends be.pwnt.jflow.Configuration {

    private List<Book> bookList = new Vector<Book>();
    private String data = Engine.getFolderLibrary();

    public Configuration(List<Book> bookList) {
        super();
        if(bookList.size() == 0){
            FileInputStream reader = null;
            Properties prop = new Properties();
            try {
                reader = new FileInputStream(new File("BiblioOp.properties"));
                prop.load(reader);
                data = (String) prop.get(data);
                String tmpImage =(String) prop.get("tmpImage");
                Book book = new Book();
                book.setCover(data+File.separator+tmpImage);
                System.out.println(data+File.separator+tmpImage);
                this.bookList.add(book);
            } catch (IOException ex) {
                Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    reader.close();
                } catch (IOException ex) {
                    Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else{
         for (int x = 0; x < bookList.size(); x++) {
            if (bookList.get(x).getCover() != null && !bookList.get(x).getCover().trim().equals("")) {
                this.bookList.add(bookList.get(x));
            }
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

