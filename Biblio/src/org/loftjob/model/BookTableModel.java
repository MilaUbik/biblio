/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.loftjob.model;

import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author mila
 */
public class BookTableModel extends AbstractTableModel{

    private String[] columnNames = {"Author",
                        "Publisher",
                        "Title",
                        "Year Ed.",
                        "ISBN"};

    private Book[] books ;

    public BookTableModel(List<Book> books) {
        this.books = new Book[books.size()];
        this.books = (Book[])books.toArray(this.books);
        Arrays.sort(this.books);
    }



    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return books.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

     public Book getColumnBook(int col) {
        return books[col];
    }

    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return books[row].getAuthor();
            case 1: return books[row].getPublisher();
            case 2: return books[row].getTitle();
            case 3: return books[row].getYearEd();
            case 4: return books[row].getIsbn();
            default : return books[row].getAuthor();
        }
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    
    public void fireTableDataChanged(List<Book> book) {
        books = new Book[book.size()];
        books = (Book[])book.toArray(books);
        super.fireTableDataChanged();
    }


   
}
