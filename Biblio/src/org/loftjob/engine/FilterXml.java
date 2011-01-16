/**
 * 
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
