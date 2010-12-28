/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package biblio.accounts.google;

import com.google.gdata.client.books.BooksService;

/**
 *
 * @author mila
 */
public class ServiceSingleton extends BooksService{

    private static ServiceSingleton service;
    

    public ServiceSingleton(){
        super("Biblio");
    }

    public static ServiceSingleton getServiceSingleton(){
        if(service == null){
            service = new ServiceSingleton();
        }
        return service;
        
    }
    


  

    

}
