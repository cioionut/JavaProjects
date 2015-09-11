import static java.lang.Double.NaN;
import java.rmi.*;
import java.rmi.server.*;
public class Calculator extends UnicastRemoteObject implements ICalculator{
  private double mem;
  private double rez;
  private double id;
  public Calculator(double i)throws RemoteException{
      mem=0;
      id=i;
      rez=0;
  }
  public double factorial(double x){
      int y=1;
      for(int i=1;i<=x;i++){
          y*=i;
      }
    return y;  
  }
  public void aduna(double x) throws RemoteException{
      rez+=x;
  }
  public void scade(double x) throws RemoteException{
      rez-=x;
  }
  public void inmulteste(double x) throws RemoteException{
      if(x==0) rez=NaN;
      else rez+=x;
  }
  public void imparte(double x) throws RemoteException{
      rez/=x;
  }
  public void adunare() throws RemoteException{
      mem+=rez;
  }
  public void scadere() throws RemoteException{
      mem-=rez;
  }
  public void stocare() throws RemoteException{
      mem=rez;
  }
  public double citire() throws RemoteException{
      return mem;
  }
  public void stergere() throws RemoteException{
      mem=0;
  }
  public double getRez()throws RemoteException{
      return rez;
  }
  public void inverseaza()throws RemoteException{
      if(rez==0) rez=NaN;
      else rez = 1/rez;
  }
  public void putere(double x)throws RemoteException{
      rez = Math.pow(rez,x);
  }
  public void factorizeaza()throws RemoteException{
      rez=factorial(rez);
  }
  public void radacina()throws RemoteException{
      rez=Math.sqrt(rez);
  }
  public void sterge()throws RemoteException{
      rez=0;
  }
}
