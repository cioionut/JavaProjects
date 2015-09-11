import static java.lang.Double.NaN;
import static java.lang.Double.isNaN;
import java.net.MalformedURLException;
import java.rmi.*;
import java.util.*;
public class ClientCalculator {
    private static final String host = "localhost";
    
    public static void main(String args[]) throws RemoteException{
        
        IGeneratorC genC = null;
        ICalculator Calc = null;
        try{
            genC = (IGeneratorC) Naming.lookup("rmi://" + host + "/Calculator");
            Calc = genC.genCalculator();
            
            
            System.out.println("Introduceti operatia apoi operandul :");
            System.out.println("Operatii: + - * / ^ ^-1 ! sqrt C \n"
                          + "Operatii cu memoria: adunare, scadere, stocare, citire, stergere \n"
                          + "Pentru a parasi aplicatia: exit");
            String op="start";
            double x=0;
            while(!op.equals("exit")){
                  System.out.println("Rezultat: "+Calc.getRez());
                  if(isNaN(Calc.getRez()) || Double.POSITIVE_INFINITY==Calc.getRez()) {
                      System.out.println("Impartire la 0 rezultatul curent se va reseta la valoarea 0");
                      Calc.sterge();
                  }
                  Scanner sc = new Scanner(System.in);
                  String preop=op;
                  System.out.print("Operatie:  ");
                  op=sc.next();
                  ArrayList<String> ops = new ArrayList<>();
                  ops.add("+");ops.add("-");ops.add("*");ops.add("/");
                  ops.add("^");
                  if(ops.contains(op) && !preop.equals("citire")) {
                      System.out.print("Operand: ");
                      x=sc.nextDouble();
                  }
                  else if(preop.equals("citire")) {
                      System.out.println("Operand: "+x);
                  }  
                  switch(op){
                      case "+":{
                          Calc.aduna(x);
                          break;
                      }
                      case "-":{
                          Calc.scade(x);
                          break;
                      }
                      case "*":{
                          Calc.inmulteste(x);
                          break;
                      }
                      case "/":{
                          Calc.imparte(x);
                          break;
                      }
                      case "^-1":{
                          Calc.inverseaza();
                          break;
                      }
                      case "^":{
                          Calc.putere(x);
                          break;
                      }
                      case "!":{
                          Calc.factorizeaza();
                          break;
                      }
                      case "sqrt":{
                          Calc.radacina();
                          break;
                      }
                      case "C":{
                          Calc.sterge();
                          break;
                      }
                      case "adunare":{
                          Calc.adunare();
                          break;
                      }
                      case "scadere":{
                          Calc.scadere();
                          break;
                      }
                      case "stocare":{
                          Calc.stocare();
                          break;
                      }
                      case "citire":{
                          x=Calc.citire();
                          break;
                      }
                      case "stergere":{
                          Calc.stergere();
                          break;
                      }
                      case "exit":{
                          System.out.println("Aplicatia s-a inchis");
                          break;
                      }
                  }
            }              
        }//try
        catch (ConnectException conEx) 
        {
            System.out.println("Unable to connect to server!\n"+conEx.getMessage());
            System.exit(1);
        }
        catch (NotBoundException | MalformedURLException | RemoteException ex) 
        {
            System.exit(1);
        }
        
    }
}
