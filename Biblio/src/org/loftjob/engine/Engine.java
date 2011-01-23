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
package org.loftjob.engine;

import biblio.BiblioView;
import biblio.accounts.google.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 *
 * Xml engine: reading / writing book method
 */
public class Engine {

    private static String defaultPath = "data";

    /**
     * Save new book created from WebService to a file
     */
    public static void createFromWS(Book book){
        writeToFile(book);
    }

    /**
     * Save new book created from data entry to a file
     *
     */
    public static void createFromDE(Book book){
        //TODO FIXME
        //modified book may have a different path so,
        //need to delete old folder e create a new one
        writeToFile(book);
    }

    /**
     * Read book from a file
     */
    public static List<Book> readFromFile(String path) throws FileNotFoundException{
        List<Book> bookList = new Vector();
        File file = new File(path);
        XmlBookReader reader = new XmlBookReader();
        if(file.isDirectory()){
            bookList = reader.importData(path);
        } else {
               bookList.add(reader.readFile(file));
        }
        return bookList;
    }


    /**
     *
     * Calculate the file relative path using book's data
     *
     * @param book
     * @return the file system path of the file
     */
    public static String getUri(Book book){
         Properties prop = new Properties();
        try {
            FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
            prop.load(reader);
            defaultPath = (String) prop.get("data");
        } catch (IOException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        File dirAuthor = new File(defaultPath + File.separator + book.getAuthor().replace(" ", "_"));
        if(!dirAuthor.exists()){
            dirAuthor.mkdir();
        }
        File dirImage = new File(dirAuthor.getAbsolutePath() + File.separator + "cover");
        if(!dirImage.exists()){
            dirImage.mkdir();
        }
            String titolo = defaultPath + File.separator + book.getAuthor().replace(" ", "_") + File.separator + book.getAuthor().replace(" ", "_")  + "-" + book.getTitle() + ".xml";
            return titolo;
    }


    /**
     * Write book to file
     *
     * @param book
     */
    private static void writeToFile(Book book){
        XmlBookWriter.write(book, getUri(book));

    }
    /**
     * Delete book's file
     *
     */
    public static void deleteBook(Book book){
        File file = new File(getUri(book));
        file.delete();
    }

     public static String getFolderLibrary(){
        return defaultPath;
    }


}
