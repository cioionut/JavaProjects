import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Ionut
 */
@WebServlet(urlPatterns = {"/edit"})
public class edit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet edit</title>");            
            out.println("</head>");
            out.println("<body>");
            
        try{
            dbProcess db = new dbProcess();
            db.edit(request.getParameter("vnume"),request.getParameter("vprenume"),request.getParameter("nume"),request.getParameter("prenume"),request.getParameter("telefon_mobil"),
            request.getParameter("email"),request.getParameter("telefon_fix"),request.getParameter("adresa"),
            request.getParameter("oras"),request.getParameter("judet"),request.getParameter("cod_postal"));
            db.displayTable();
            out.println("<h1>Editare cu succes!</h1>");
            out.println("</body>");
            out.println("</html>");
            db.link.close();
        }
        catch(ClassNotFoundException cnfEx){
            out.println("<h1>Nu am putut incarca driverul la baza de date!</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(SQLException sqlEx){
         out.println("<h1>"+sqlEx.getMessage()+"</h1>");
         out.println("</body>");
         out.println("</html>");
        }   
      }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
