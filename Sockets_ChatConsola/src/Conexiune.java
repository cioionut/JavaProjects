
import java.util.*;
import java.net.*;
import java.io.*;

public class Conexiune extends Thread{
    private Client client;
    private Comun comun;
    Conexiune(Socket clientSocket,Comun comun){
        client=new Client(clientSocket);
        this.comun = comun;     
        comun.clientSet.add(client);
    }
    public void run(){
        try{
            String[] comanda={""};
            while(!"quit".equals(comanda[0])){
                comanda=client.dis.readUTF(). split(" ");
                switch(comanda[0]){
                    case "list":{
                        String clienti=comun.List();
                            client.dos.writeUTF(clienti);
                        break;
                    }
                    case "nick":{
                        String clienti=comun.List();
                        String[] clientii=clienti.split("\n");
                        if(!valid(comanda[1],clientii)){
                            client.dos.writeUTF("Mai exista un utilizaor cu acest nume, mai incearca");
                        }
                        else{
                            client.nume=comanda[1];
                            client.dos.writeUTF("Nume schimbat cu succes");
                        }
                        break;
                    }
                    case "quit":{
                        comun.clientSet.remove(client);
                        client.dos.writeUTF("Utilizator deconectat");
                        break;                        
                    }
                    case "msg":{
                        String mesaj="";
                        for(int i=2;i<comanda.length;i++) mesaj+=comanda[i]+" ";
                        comun.Msg(client.nume,comanda[1], mesaj);
                        break;
                    }
                    case "bcast":{
                        String mesaj="";
                        for(int i=1;i<comanda.length;i++) mesaj+=comanda[i]+" ";
                        comun.Bcast(client.nume,mesaj);
                        break;
                    }
                    
                }
            }            
        }
        catch(IOException error){
            //System.err.println(error.getMessage());
            comun.clientSet.remove(client);
        }
        
    }
    Boolean valid (String x,String[] y){
        if(y==null) return true;
        for(int i=0;i<y.length;i++)
            if(x.equals(y[i])) return false;
        return true;
    }
}