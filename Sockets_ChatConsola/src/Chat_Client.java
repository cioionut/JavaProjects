import java.util.*;
import java.net.*;
import java.io.*;

public class Chat_Client {
    private static InetAddress host;
    private static final int PORT = 2080;
    public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);
    try
		{
			host = InetAddress.getLocalHost(); 
		}
		catch(UnknownHostException uhEx)
		{
			System.out.println("\nHost ID not found!\n");
			System.exit(1);
		}
    Socket cs = new Socket(host, PORT);
    System.out.println("M-am legat");
    DataOutputStream dos=null;
    DataInputStream dis=null;
    try{
        dos = new DataOutputStream(cs.getOutputStream());
        dis = new DataInputStream(cs.getInputStream());
    }
    catch(IOException error){
        System.out.println("Eroare la flux");
    }
    
    Fir fir = new Fir(dis);
    fir.start();
    
    System.out.println("Introduceti numele, apoi folositi comanezile : list,msg,bcast,nick,quit ");
    String in = "nick ",rezultat1=" ",rezultat=" ";
    in+=sc.next();
    String[] comanda=in.split(" ");
    while(!comanda[0].equals("quit")){        
        dos.writeUTF(in); 
        Scanner scc = new Scanner(System.in);
        in=scc.nextLine();
        comanda=in.split(" ");
    }  
    fir.merge=false;
    cs.close();
    dis.close();
    dos.close();
    }
}

class Fir extends Thread {
    Boolean merge;
    DataInputStream dis;
    Fir(DataInputStream dis){
        this.dis=dis;
        merge=true;
    }
    public void run(){
        while(merge){
            try{
                System.out.println(dis.readUTF());
            }
            catch(IOException err){
                //System.err.println(err.getMessage());
            }
        }
    }
}
