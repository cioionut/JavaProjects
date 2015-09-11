import java.rmi.*;
public interface ICalculator extends Remote {
    public void aduna(double x)throws RemoteException;
    public void scade(double x)throws RemoteException;
    public void inmulteste(double x)throws RemoteException;
    public void imparte(double x)throws RemoteException;
    public void inverseaza()throws RemoteException;
    public void putere(double x)throws RemoteException;
    public void factorizeaza()throws RemoteException;
    public void radacina()throws RemoteException;
    
    public void sterge()throws RemoteException;
    public double getRez()throws RemoteException;
            
    public void adunare()throws RemoteException;
    public void scadere()throws RemoteException;
    public void stocare()throws RemoteException;
    public double citire()throws RemoteException;
    public void stergere()throws RemoteException;
}
