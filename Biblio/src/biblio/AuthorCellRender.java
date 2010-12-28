/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package biblio;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.loftjob.model.Book;


/**
 *
 * @author mila
 */
public class AuthorCellRender extends DefaultTreeCellRenderer{

    @Override
     public Component getTreeCellRendererComponent(
                        JTree tree,
                        Object value,
                        boolean sel,
                        boolean expanded,
                        boolean leaf,
                        int row,
                        boolean hasFocus) {

        super.getTreeCellRendererComponent(
                        tree, value, sel,
                        expanded, leaf, row,
                        hasFocus);
        //setHorizontalAlignment(LEFT);
        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(biblio.BiblioApp.class).getContext().getResourceMap(AuthorCellRender.class);
        if(leaf){
         DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
         if(node.getUserObject() != null && node.getUserObject() instanceof Book){
        setText(((Book)node.getUserObject()).getAuthor());
        setIcon(resourceMap.getIcon("leaf.icon"));// NOI18N
         }
        setHorizontalAlignment(LEADING);
        if (selected) {
            setBackgroundSelectionColor(new Color(181,229,224));
        } else {
            setBackgroundNonSelectionColor(Color.WHITE);

        }
        }

        return this;
    }



}
