/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package biblio.accounts.google;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author mila
 */
public class TextAreaCellRender extends JTextArea implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((String) value);
        return this;
    }

}
