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
package biblio.scanner;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.loftjob.model.Book;


/**
 * @author mila
 *
 */
public class SearchJson {
	
	private String tbUrl[];

	/**
	 * 
	 */
	public SearchJson(Book book) {
		URL url;
		int start = 0;
		List<String> tmp = new Vector();
		for(int x = 0; x < 2; x++){
		try {
			url = new URL("http://ajax.googleapis.com/ajax/services/search/images?v=1.0&q=" //$NON-NLS-1$
					+URLEncoder.encode(book.getTitle(),"UTF-8")+"%20" //$NON-NLS-1$ //$NON-NLS-2$
					//+URLEncoder.encode(book.getNome(),"UTF-8")+"%20"
                                        +URLEncoder.encode(book.getPublisher(),"UTF-8")+"%20"
					+URLEncoder.encode(book.getAuthor(),"UTF-8")+"&start="+start); //$NON-NLS-1$ //$NON-NLS-2$
		URLConnection connection;
			connection = url.openConnection();
			connection.setRequestProperty("User-Agent", "Mozilla/4.5"); //$NON-NLS-1$ //$NON-NLS-2$
		
		//connection.addRequestProperty("Referer", "http://www.mysite.com/index.html");

		String line;
		StringBuilder builder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		while((line = reader.readLine()) != null) {
		 builder.append(line);
		}

		JSONObject json = new JSONObject(builder.toString());
		JSONArray object = (JSONArray)json.getJSONObject("responseData").get("results"); //$NON-NLS-1$ //$NON-NLS-2$
		for(int index = 0; index < object.length();index++){
			JSONObject obj = (JSONObject) object.get(index);
			tmp.add(obj.getString("url"));
		}
		start += 8;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"No internet connection", "error",JOptionPane.ERROR_MESSAGE);
                        return;
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
		tbUrl = new String[tmp.toArray().length];
		int x = 0;
		for(String imageurl:tmp){
			tbUrl[x] = imageurl;
			x++;
		}
	}
	
	public String[] getUrl(){
		return tbUrl;
	}
	
	public static void main(String[] args){
		//new SearchJson();
	}
	
}
