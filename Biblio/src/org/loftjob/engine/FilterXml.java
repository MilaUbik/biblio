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

/**
 * @author mila
 *
 */
public class FilterXml implements FileFilter {

	/**
	 * 
	 */
	public FilterXml() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see java.io.FileFilter#accept(java.io.File)
	 */
	@Override
	public boolean accept(File pathname) {
            String path = pathname.getPath();
            String[] file = path.split("/");
            String ext[] = file[file.length-1].split("\\.");
		if(ext.length == 2 && ext[1].equals("xml")){
                    System.out.println(ext[0]+" true");
                    return true;
                }
		else {
                System.out.println(ext[0]+" false");
                return false;
	}
        }

}
