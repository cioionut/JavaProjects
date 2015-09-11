import java.rmi.*;
public interface IGeneratorC extends Remote {
   public ICalculator genCalculator() throws RemoteException;
}
