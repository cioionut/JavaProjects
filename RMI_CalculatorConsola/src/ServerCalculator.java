import java.rmi.*;

public class ServerCalculator {
    private static final String host = "localhost";
    
    public static void main(String args[])throws Exception {
        
        GeneratorC genC = new GeneratorC();
        String rmiObjectName = "rmi://" + host + "/Calculator";
        Naming.rebind(rmiObjectName,genC);
        System.out.println("Binding complete");        
    }
}
