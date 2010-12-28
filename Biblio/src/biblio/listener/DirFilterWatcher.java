/**
 * 
 */
package biblio.listener;

/**
 * @author mila
 *
 */
import java.io.File;
import java.io.FileFilter;

public class DirFilterWatcher implements FileFilter {
  private String filter;

  public DirFilterWatcher() {
    this.filter = ""; //$NON-NLS-1$
  }

  public DirFilterWatcher(String filter) {
    this.filter = filter;
  }
  
  public boolean accept(File file) {
    if ("".equals(filter)) { //$NON-NLS-1$
      return true;
    }
    return (file.getName().endsWith(filter));
  }
}
