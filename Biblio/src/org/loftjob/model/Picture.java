/*
 * JFlow v0.2
 * Created by Tim De Pauw <http://pwnt.be/>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.loftjob.model;

import java.io.IOException;
import java.net.URL;


import java.io.File;

public class Picture extends be.pwnt.jflow.shape.Picture {
	
        private Book book;



	

         public Picture(Book book) throws IOException{
            super(new URL("file://"+new File(book.getCover().trim()).getAbsolutePath()));
            this.book = book;

        }

        

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

        
}
