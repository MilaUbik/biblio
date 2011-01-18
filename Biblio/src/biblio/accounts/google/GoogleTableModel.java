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


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import org.loftjob.model.Book;


/**
 *
 * @author mila
 */
public class GoogleTableModel extends AbstractTableModel{

     private String[] columnNames = {"Select",
                        "Cover",
                        "Book"};
     private Book[] books;
     private Boolean[] select;
     private ImageIcon cover;
     private String bookDetail;

     public GoogleTableModel(List<Book> books){
        this.books = new Book[books.size()];
        select = new Boolean[books.size()];
        for(int x = 0;x<books.size();x++){
            select[x] = false;
        }
        this.books = (Book[])books.toArray(this.books);
        Arrays.sort(this.books);
     }

    @Override
   public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return books.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

     public Book getColumnBook(int col) {
        return books[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        switch(col){
            case 0: return select[row];
            case 1: {
                ImageIcon img = new ImageIcon(books[row].getCover());
                Image tmp = getScaledImage(img.getImage(), 100, 150);
                return cover= new ImageIcon(tmp);

            }
            case 2: {
                bookDetail = (books[row].toString());
                return bookDetail;
            }
            default : return books[row].toString();
        }
    }

    @Override
     public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setValueAt(Object value, int row, int col){
        select[row] = (Boolean)value;
        fireTableCellUpdated(row, col);
    }

    private Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedImg.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();
        return resizedImg;
    }

}
