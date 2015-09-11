import java.util.*;
import java.net.*;
import java.io.*;

public class Chat_Server {
    private static final int PORT = 2080;
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        ServerSocket serverSocket=null;
        Socket clientSocket = null; 
        try{
           serverSocket = new ServerSocket(PORT);
           System.out.println("Serverul a pornit");
        }
        catch(IOException error){
           System.out.println("Nu s-a putut conecta la port");
           System.exit(1);
        }
        while(true){
            clientSocket = serverSocket.accept();
            System.out.println("Utilizator nou conectat");
            Comun comun = new Comun();
            Conexiune conn = new Conexiune(clientSocket,comun);
            conn.start();
        }  
    }  
}

