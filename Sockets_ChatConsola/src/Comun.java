
import java.util.*;
import java.net.*;
import java.io.*;

public class Comun{
    static HashSet<Client> clientSet = new HashSet<Client>();
    synchronized String List() throws IOException {
        Client auxclient;
        String clienti="";
        for(Iterator iter = clientSet.iterator(); iter.hasNext(); ) {
          auxclient = (Client) iter.next();
          clienti+=auxclient.nume+"\n";
        }
        return clienti;
    }
    synchronized Boolean Msg(String emit,String unume,String mesaj){
        Client auxclient;
        for(Iterator iter = clientSet.iterator(); iter.hasNext(); ) {
          auxclient = (Client) iter.next();
          if(auxclient.nume.equals(unume)){
              try{
              auxclient.dos.writeUTF(emit+": "+mesaj);
              }
              catch(IOException err){
                  System.err.println(err.getMessage());
              }
              return true;
          } 
        }
        return false;
    }
    synchronized Boolean Bcast(String emit,String mesaj){
        Client auxclient;
        for(Iterator iter = clientSet.iterator(); iter.hasNext(); ) {
          auxclient = (Client) iter.next();
              try{
              auxclient.dos.writeUTF(emit+": "+mesaj);
              }
              catch(IOException err){
                  System.err.println(err.getMessage());
              }
        }
        return false;
    }
}
