import java.sql.*;
public class dbProcess {
   static Connection link;
   static Statement statement;
   static ResultSet results;
 
   public dbProcess() throws ClassNotFoundException,SQLException{
         //Step 1...
         Class.forName("com.mysql.jdbc.Driver");
         //Step 2...
         link = DriverManager.getConnection("jdbc:mysql://localhost:3306/proiect3", "root", "root");
         //Step 3...
         statement = link.createStatement();         
   }
   public void insert(String nume,String prenume,String telefon_mobil,String email,
                      String telefon_fix,String adresa,String oras,String judet,String cod_postal)
                    throws ClassNotFoundException,SQLException{
        if(nume == "" || prenume == "" || email == "" || telefon_mobil == "") 
            throw new SQLException("Nume,prenume,email,telefon_mobil sunt campuri obligatorii");
        if(cod_postal=="") cod_postal=null;
        if(telefon_fix=="") telefon_fix=null;
        if(adresa=="") adresa=null;
        if(judet=="") judet=null;
        if(oras=="") oras=null;
        String insert =                 
                 "INSERT INTO users(nume,prenume,telefon_mobil,email,telefon_fix,adresa,oras,judet,cod_postal)"
                     + "VALUES('"+nume+"','"+prenume+"','"+telefon_mobil
                     +"','"+email+"','"+telefon_fix+"','"+adresa+"','"+oras+"','"+judet
                     +"',"+cod_postal+");";
         int result = statement.executeUpdate(insert);
         if (result == 0){
            System.out.println("\nUnable to insert record!");
            throw new SQLException("Eroare la insearre");
         }
         System.out.println("\nSucces");
    }
   public void edit(String vnume,String vprenume,String nume,String prenume,String telefon_mobil,String email,
                      String telefon_fix,String adresa,String oras,String judet,String cod_postal)
                    throws ClassNotFoundException,SQLException{
       if(vnume=="" || vprenume=="" || nume == "" || prenume == "" || email == "" || telefon_mobil == "") 
            throw new SQLException("Nume,prenume,email,telefon_mobil sunt campuri obligatorii");
        if(cod_postal=="") cod_postal=null;
        if(telefon_fix=="") telefon_fix=null;
        if(adresa=="") adresa=null;
        if(judet=="") judet=null;
        if(oras=="") oras=null;
        String change = "UPDATE users"
                      + " SET nume = '"+nume+"',"
                      + "prenume = '"+prenume+"',"
                      + "telefon_mobil = '"+telefon_mobil+"',"
                      + "email = '"+email+"',"
                      + "telefon_fix = '"+telefon_fix+"',"
                      + "adresa= '"+adresa+"',"
                      + "oras = '"+oras+"',"
                      + "judet = '"+judet+"',"
                      + "cod_postal = "+cod_postal+" "
                      + "WHERE nume = '"+vnume+"'and prenume='"+vprenume+"';";
        //System.out.println(change);
         int result = statement.executeUpdate(change);
         if (result == 0){
            System.out.println("\nEroare la editare!");
            throw new SQLException("Eroare la editare");
         }
         System.out.println("\nSucces");
   }
   
   public void delete(String nume,String prenume)
                    throws ClassNotFoundException,SQLException{
       if(nume == "" || prenume == "") 
            throw new SQLException("Nume,prenume sunt campuri obligatorii");
       String remove = "DELETE FROM users"
                      + " WHERE nume='"+nume+"' and prenume = '"+prenume+"';";
       int result = statement.executeUpdate(remove);
         if (result == 0){
            System.out.println("\nEroare la stergere!");
            throw new SQLException("Eroare la stergere");
         }
         System.out.println("\nSucces");
        
   }
   public String search(String nume,String prenume,String telefon_mobil,String email,
                      String telefon_fix,String adresa,String oras,String judet,String cod_postal)
                    throws ClassNotFoundException,SQLException{
        if(nume == "" && prenume == "" && email == "" && telefon_mobil == ""
             && telefon_fix =="" && adresa =="" && oras =="" && judet=="" &&cod_postal=="") 
            throw new SQLException("Cel putin un camp trebuie completat");
        if(cod_postal=="") cod_postal=null;
        if(telefon_fix=="") telefon_fix=null;
        if(adresa=="") adresa=null;
        if(judet=="") judet=null;
        if(oras=="") oras=null;
        String select = "SELECT * FROM users where "
                      + "nume = '"+nume+"' and 'null' != '"+nume+"' or " 
                + "prenume = '"+prenume+"' and 'null' != '"+prenume+"' or " 
                + "telefon_mobil = '"+telefon_mobil+"' and 'null' != '"+telefon_mobil+"' or " 
                + "email = '"+email+"' and 'null' != '"+email+"' or " 
                + "telefon_fix = '"+telefon_fix+"' and 'null' != '"+telefon_fix+"' or " 
                + "adresa = '"+adresa+"' and 'null' != '"+adresa+"' or " 
                + "oras = '"+oras+"' and 'null' != '"+oras+"' or " 
                + "judet = '"+judet+"' and 'null' != '"+judet+"' or " 
                + "cod_postal = "+cod_postal+" and 'null' != "+cod_postal+" ;";
        System.out.println(select);
        results = statement.executeQuery(select);
        String result="";
        while (results.next()){
            result+=results.getInt(1)+" ";
            for(int i=2;i<=9;i++)
                result+=results.getString(i)+" ";
            result+=results.getInt(10)+"</br>";
        }
        return result;
   }
   public void displayTable() throws SQLException
   {
      String select = "SELECT * FROM users";
      results = statement.executeQuery(select);
      System.out.println();
      while (results.next())
      {
         System.out.print(results.getInt(1)+" ");
         for(int i=2;i<=9;i++)
         System.out.print(results.getString(i)+" ");
	 System.out.println(results.getInt(10));
      }
   }
}
