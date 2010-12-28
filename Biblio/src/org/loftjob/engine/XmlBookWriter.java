/**
 * 
 */
package org.loftjob.engine;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.loftjob.model.Book;


/**
 * @author mila
 *
 */
public class XmlBookWriter {
	
	/**
	 * 
	 */
	public XmlBookWriter() {
		// TODO Auto-generated constructor stub
	}
	
	public static void write(Book book, String path) {
        try {
            XMLOutputFactory xof = XMLOutputFactory.newInstance();
            File file = new File(path);
           if(file.exists()) file.delete();
		file.createNewFile();
            XMLStreamWriter xtw = xof.createXMLStreamWriter(new FileWriter(file));
            xtw.writeStartDocument();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Book");
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Title");
            xtw.writeCharacters(book.getTitle());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Author");
            xtw.writeCharacters(book.getAuthor());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("YearEd");
            xtw.writeCharacters(book.getYearEd());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Publisher");
            xtw.writeCharacters(book.getPublisher());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Cover");
            xtw.writeCharacters(book.getCover());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("Description");
            xtw.writeCharacters(book.getDescription());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeStartElement("ISBN");
            xtw.writeCharacters(book.getIsbn());
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeEndElement();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.writeEndDocument();
            xtw.writeCharacters(System.getProperty("line.separator"));
            xtw.flush();
            xtw.close();
        } catch (XMLStreamException ex) {
            Logger.getLogger(XmlBookWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XmlBookWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void modify(Book book,String path) throws IOException, XMLStreamException{
		String titolo = book.getAuthor().replace(" ", "_")+"-"+book.getTitle()+".xml";
		File file = new File(path+File.separator+titolo);
		if(file.exists()) file.delete();
		file.createNewFile();
		write(book,path);
	}

}
