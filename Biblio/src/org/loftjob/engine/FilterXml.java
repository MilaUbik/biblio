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
		if(pathname.getPath().contains(".xml"))
		return true;
		else return false;
	}

}
