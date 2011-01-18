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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;

public abstract class DirWatcher extends TimerTask {
	private String path;
	private File filesArray[];
	private HashMap dir = new HashMap();
	private DirFilterWatcher dfw;
	private int i = 0;

	public DirWatcher(String path) {
		this(path, ""); //$NON-NLS-1$
	}

	public DirWatcher(String path, String filter) {
		this.path = path;
		dfw = new DirFilterWatcher(filter);
		File repository = new File(path);
		File[] dirs = repository.listFiles();

		// scan the files and check for modification/addition
		for (int x = 0; x < dirs.length; x++) {
			if (dirs[x].isDirectory()) {
				filesArray = dirs[x].listFiles(dfw);
				for (int i = 0; i < filesArray.length; i++) {
					dir.put(filesArray[i], new Long(filesArray[i].lastModified()));
				}
			}
		}
	}

	public final void run() {
		HashSet checkedFiles = new HashSet();
		File repository = new File(path);
		File[] dirs = repository.listFiles();
		for (int x = 0; x < dirs.length; x++) {
			if (dirs[x].isDirectory()) {
				filesArray = dirs[x].listFiles(dfw);

				// scan the files and check for modification/addition
				for (i = 0; i < filesArray.length; i++) {
                                    Long current = (Long) dir.get(filesArray[i]);
                                    String path = filesArray[i].getPath();
                                    String[] file = path.split("/");
                                    String ext[] = file[file.length - 1].split("\\.");
                                    if (ext.length == 2 && (ext[1].equals("xml") || ext[1].equals("jpeg"))) {
                                         checkedFiles.add(filesArray[i]);
                                        if (current == null) {
                                            // new file
                                            dir.put(filesArray[i], new Long(filesArray[i].lastModified()));
                                            onChange(filesArray[i], "add"); //$NON-NLS-1$

                                        } else if (current != filesArray[i].lastModified()) {
                                            // modified file
                                            dir.put(filesArray[i], new Long(filesArray[i].lastModified()));
                                            onChange(filesArray[i], "add");
                                        }
                                    }
                                    } 
                                }
		}
		// now check for deleted files
		Set ref = ((HashMap) dir.clone()).keySet();
		ref.removeAll((Set) checkedFiles);
		Iterator it = ref.iterator();
		while (it.hasNext()) {
			File deletedFile = (File) it.next();
			dir.remove(deletedFile);
			onChange(deletedFile, "delete"); //$NON-NLS-1$
		}
	}

	protected abstract void onChange(File file, String action);
}
