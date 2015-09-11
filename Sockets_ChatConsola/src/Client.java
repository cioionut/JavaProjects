
import java.util.*;
import java.net.*;
import java.io.*;

public class Client {
  Socket cs; 
  String nume; 
  DataOutputStream dos;
  DataInputStream dis;
  Client(Socket clientSocket) {
    cs = clientSocket; 
    nume = null;
    try{
        dos = new DataOutputStream(cs.getOutputStream());
        dis = new DataInputStream(cs.getInputStream());
    }
    catch(IOException error){
        System.out.println("Eroare la flux");
    }
  }

//   
//  public boolean equals ( Object o) {
//        if (!( o instanceof Client ))
//                return false ;
//    Client p = ( Client ) o;
//    return (nume == null ? p.nume == null : nume.equals(p.nume));
//    }
//  public int compareTo ( Object o) {
//        if (o== null )
//            throw new NullPointerException ();
//        if (!( o instanceof Client ))
//            throw new ClassCastException ("Nu pot compara !");
//    Client p = ( Client ) o;
//    return nume.compareTo(p.nume);
//  }
}