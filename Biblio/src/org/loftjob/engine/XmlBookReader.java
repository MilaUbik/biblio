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


import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import org.loftjob.model.Book;



public class XmlBookReader {

	private QName oldQname = new QName("");
	private QName qname = new QName("");
	private String result = " ";
	private Book book = new Book();
	private List<Book> bookList = new Vector<Book>();

	public List<Book> importData(String url) {

		XMLInputFactory factory = XMLInputFactory.newInstance();
		try {
			File repository = new File(url);
			File[] dirs = repository.listFiles();
			for (int x = 0; x < dirs.length; x++) {
				if (dirs[x].isDirectory() && !dirs[x].getName().equalsIgnoreCase("AllBook")) {
					FileFilter filter = new FilterXml();
					File[] listFile = dirs[x].listFiles(filter);
					for (int z = 0; z < listFile.length; z++) {
						book = new Book();
						File file = listFile[z];
						FileReader reader = new FileReader(file);
						XMLEventReader r = factory.createXMLEventReader(reader);
						while (r.hasNext()) {
							XMLEvent e = (XMLEvent) r.next();
							if (e.isStartElement()) {
								result = new String();
								qname = ((StartElement) e).getName();
							}
							if (e.isCharacters()) {
								processEvent(e);
							}
						}
						bookList.add(book);
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookList;
	}

	public Book readFile(File file) {
        FileReader reader = null;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            reader = new FileReader(file);
            XMLEventReader r = factory.createXMLEventReader(reader);
            while (r.hasNext()) {
                XMLEvent e = (XMLEvent) r.next();
                if (e.isStartElement()) {
                    result = new String();
                    qname = ((StartElement) e).getName();
                }
                if (e.isCharacters()) {
                    processEvent(e);
                }
            }
        } catch (XMLStreamException ex) {
            Logger.getLogger(XmlBookReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(XmlBookReader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(XmlBookReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return book;
	}

	private void processEvent(XMLEvent e) {

		result = result + ((Characters) e).getData();
		String patternStr = "[\\n\\t]";
		String replaceStr = "";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(result);
		result = matcher.replaceAll(replaceStr).trim();
		if (qname.toString().equalsIgnoreCase("Author")) {
			book.setAuthor(result);
		} else if (qname.toString().equalsIgnoreCase("Publisher")) {
			book.setPublisher(result);
		} else if (qname.toString().equalsIgnoreCase("Title")) {
			book.setTitle(result);
		} else if (qname.toString().equalsIgnoreCase("YearEd")) {
			book.setYearEd(result);
		} else if (qname.toString().equalsIgnoreCase("Description")) {
			book.setDescription(result);
		} else if (qname.toString().equalsIgnoreCase("Cover")) {
			book.setCover(result);
		} else if (qname.toString().equalsIgnoreCase("ISBN")) {
			book.setIsbn(result);
                }
	}
}
