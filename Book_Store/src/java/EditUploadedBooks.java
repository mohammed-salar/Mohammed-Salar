import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditUploadedBooks extends HttpServlet 
{
    String id;
    String name;
    String cat;
    String author;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) 
        {
            id = request.getParameter("status");
            
            Connection cn = ConnectionPool.getConnection();
            
            Statement smt = cn.createStatement();
            
            ResultSet rs = smt.executeQuery("select*from book where book_id = "+id);
            
            if(rs.next())
            {
                
                name = rs.getString(2);
                cat = rs.getString(3);
                author = rs.getString(4);
            }
            out.println("<html>");
            out.println("<head>");
            out.println("<style>body, html {\n" +
"  height: 100%;\n" +
"  font-family: Arial, Helvetica, sans-serif;\n" +
"}\n" +
"\n" +
"* {\n" +
"  box-sizing: border-box;\n" +
"}\n" +
"\n" +
".bg-img {\n" +
"  /* The image used */\n" +
"  background-image: url(\"images/book3.jpg\");\n" +
"\n" +
"  min-height: 100%;\n" +
"\n" +
"  /* Center and scale the image nicely */\n" +
"  background-position: center;\n" +
"  background-repeat: no-repeat;\n" +
"  background-size: cover;\n" +
"  position: relative;\n" +
"}.container {\n" +
"  position: absolute;\n" +
"  left: 520;\n" +
"  margin: 0px;\n" +
"  max-width: 500px;\n" +
"  padding: 20px;\n" +
"  background-color: white;\n" +
"}\n" +
"input[type=text], input[type=password] {\n" +
"  width: 100%;\n" +
"  padding: 15px;\n" +
"  margin: 5px 0 22px 0;\n" +
"  border: none;\n" +
"  background: #f1f1f1;\n" +
"}\n" +
"\n" +
"input[type=text]:focus, input[type=password]:focus {\n" +
"  background-color: #ddd;\n" +
"  outline: none;\n" +
"}\n" +
".btn {\n" +
"  background-color:blue;\n" +
"  color: white;\n" +
"  padding: 16px 20px;\n" +
"  border: none;\n" +
"  cursor: pointer;\n" +
"  width: 100%;\n" +
"  opacity: 0.9;\n" +
"}\n" +
"\n" +
".btn:hover \n" +
"{\n" +
"  opacity: 1;\n" +
"}</style>");
            out.println("</head>");
            out.println("<body class='bg-img'>");
            
            out.println("<form action='UpdateUploadedBooks' method=post class='container'>");
            out.println("<table align=center>");
            out.println("<h1 align='center' style='color:blue'>Updation</h1>");
            out.println("<tr>");
            out.println("<td style='color:blue'>ID</td>");
            out.println("<td><input type='text' name='id' value='"+id+"' readonly></td>");
            out.println("<tr>");
            
            out.println("<tr>");
            out.println("<td style='color:blue'>Name</td>");
            out.println("<td><input type='text' name='name' value='"+name+"' readonly></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td style='color:blue'>Categoty</td>");
            out.println("<td><input type='text' name='cat' value='"+cat+"'></td>");
            out.println("<tr>");
            
            out.println("<tr>");
            out.println("<td style='color:blue'>Author</td>");
            out.println("<td><input type='text' name='author' value='"+author+"'></td>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td colspan=2 align=center><input type='submit' value='Update' class='btn'></td>");
            out.println("</tr>");
            
            out.println("</table>");
            out.println("</form>");
            out.println("<body>");
            out.println("</html>");
        }
        catch(Exception e)
        {
            System.out.println("value = "+e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
