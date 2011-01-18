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
