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
package org.loftjob.model;

import java.io.IOException;
import java.text.Collator;
import java.util.Locale;

import javax.xml.stream.XMLStreamException;



/**
 * Book model
 *
 * @author mila
 */
public class Book implements Comparable<Object> {
	
	private String author;
	private String publisher;
	private String title;
	private String yearEd;
	private String cover;
	private String description;
        private String isbn;


    public Book() {
		this.author = "";
		this.publisher = "";
		this.title = "";
		this.yearEd = "";
		this.cover = "";
		this.description = "";
                this.isbn = "";
	}


	/**
	 * @param nome
	 * @param cognome
	 * @param editore
	 * @param titolo
	 * @param annoEdizione
	 * @param immagine
	 */
	public Book(String author, String publisher, String title,
			String yearEd, String cover, String description, String isbn) {
                author = author.replace(".", " ");
               // title = title.replace(".", " ");
                this.author = author;
		this.publisher = publisher;
		this.title = title;
		this.yearEd = yearEd;
		this.cover = cover;
		this.description = description;
                this.isbn = isbn;
	}

	public Book(Book book) {
		this.author = book.getAuthor();
                this.author = author.replace(".", " ");
		this.publisher = book.getPublisher();
		this.title = book.getTitle();
		this.yearEd = book.getYearEd();
		this.cover = book.getCover();
		this.description = book.getDescription();
                this.isbn = book.getIsbn();
                //this.title = title.replace(".", " ");
	}


        public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
        this.author = author.replace(".", " ");
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYearEd() {
        return yearEd;
    }

    public void setYearEd(String yearEd) {
        this.yearEd = yearEd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
	
    @Override
    public String toString(){
		return     " Author :" +getAuthor()+"\n"+
			   " Publisher  :" +getPublisher()+"\n"+
			   " Title :" +getTitle()+"\n"+
			   " YearEd :" +getYearEd()+"\n"+
			   " Cover :" +getCover()+"\n"+
			   " Description :" +getDescription()+"\n"+
                           " ISBN :" +getIsbn();
	}
	

    @Override
    public boolean equals(Object object){
        Book book = (Book) object;
        if(this.getAuthor().equals(book.getAuthor()) && this.getTitle().equals(book.getTitle())){
            return true;
        } else{
            return false;
        }
    }
    @Override
    public int compareTo(Object o) {
       
         Collator col = Collator.getInstance(Locale.getDefault());
	            Book t1 = this;
	            Book t2 = (Book) o;
                    String[] tmp = t1.getAuthor().split(" ");
	            String v1 = (tmp[tmp.length-1]);
                    tmp = t2.getAuthor().split(" ");
	            String v2 = (tmp[tmp.length-1]);

	            return (col.compare(v1,v2));
    }
}
