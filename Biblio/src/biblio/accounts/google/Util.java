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

import biblio.BiblioView;
import com.google.gdata.data.Link;
import com.google.gdata.util.ServiceException;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.loftjob.engine.Engine;
import org.loftjob.model.Book;

/**
 *
 * @author mila
 */
public class Util {
    private static String path = Engine.getFolderLibrary();

    public static String[] getAccount(){
        BufferedReader reader = null;
        String[] credential = {null,null};
        try {            
            File file = new File("data"+File.separator+"google");
            if(file.exists()){
            reader = new BufferedReader(new FileReader(file));
            credential[0] = reader.readLine().split(":")[1];
            }
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(reader != null) reader.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
             return credential;
        }

    }

     public static boolean saveAccount(){
        BufferedWriter writer = null;
        boolean isSaved = false;
        try {
            File file = new File("data"+File.separator+"google");
            writer = new BufferedWriter(new FileWriter(file));
            writer.append("firstAcces: no");
            isSaved = true;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(writer != null) writer.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
             return isSaved;
        }

    }

     public static boolean deleteAccount(){
       File file = new File("data"+File.separator+"google");
       if(file.exists()){
           file.delete();
           return true;
       }
       return false;
    }

 public static String saveImage(Book book, Link link){
        InputStream inStream = null;
        File imageFile = null;
         Properties prop = new Properties();
        try {
              FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
                prop.load(reader);
               String path = (String) prop.get("data");
            ServiceSingleton service = ServiceSingleton.getServiceSingleton();
            inStream = service.getStreamFromLink(link);
            Image input = ImageIO.read(inStream);
          if (input != null) {
                BufferedImage buff = new BufferedImage(input.getWidth(null), input.getHeight(null), BufferedImage.TYPE_INT_RGB);
                buff.getGraphics().drawImage(input, 0, 0, null);
                imageFile = new File(path + File.separator + book.getAuthor().trim().replace(" ", "_") + File.separator + "cover"
                                + File.separator + book.getTitle().trim() + ".jpeg");
                ImageIO.write(buff, "jpeg", imageFile);
         }else{
                return null;
         }

        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inStream.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return imageFile.getAbsolutePath();
    }

 public static void saveImage(Book book, URL url){
        InputStream stream = null;
         Properties prop = new Properties();
        try {
            FileInputStream reader = new FileInputStream(new File("BiblioOp.properties"));
            prop.load(reader);
            path = (String) prop.get("data");
        } catch (IOException ex) {
            Logger.getLogger(BiblioView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            URLConnection uc = url.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/4.5");
            stream = uc.getInputStream();
            BufferedImage imageBuff = ImageIO.read(stream);
            Image image = ImageIO.read(url);
            image = Toolkit.getDefaultToolkit().createImage(imageBuff.getSource());
            BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
            Graphics2D g2 = bufferedImage.createGraphics();
            g2.drawImage(image, null, null);
            File dirImg = new File(path + File.separator + book.getAuthor().trim().replace(" ", "_") + File.separator + "cover");
            if (!dirImg.exists()) {
                dirImg.mkdir();
            }
            File imageFile = new File(dirImg + File.separator + book.getTitle().trim() + ".jpeg");
            ImageIO.write(bufferedImage, "jpeg", imageFile);
            book.setCover(path + File.separator + book.getAuthor().trim().replace(" ", "_") + File.separator + "cover" + File.separator + book.getTitle().trim() + ".jpeg");
            Engine.createFromWS(book);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
               
 }

}
