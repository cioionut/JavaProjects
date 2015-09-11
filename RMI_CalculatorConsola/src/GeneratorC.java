import java.rmi.*;
import java.rmi.server.*;

public class GeneratorC extends UnicastRemoteObject implements IGeneratorC {
    int id=1;
    public GeneratorC() throws RemoteException {};
    public ICalculator genCalculator()throws RemoteException{
        return new Calculator(id++);
    }
}
