import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowUploadedBooks extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  
        {
           out.println("<div align=right>");
            RequestDispatcher rd = request.getRequestDispatcher("AdminLogout.html");
            rd.include(request, response);
            out.println("</div>");
            
            Connection cn = ConnectionPool.getConnection();
           
           Statement smt = cn.createStatement();
           
           ResultSet rs = smt.executeQuery("select*from book");
           
           
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
"}.tab{background-color: white;}</style>");
           
           out.println("</head>");
           out.println("<body class=bg-img>");
           out.println("<table border=3 align='center' class='tab'>");
           out.println("<caption><h3 style='color:blue'>Uploaded Books</h3></caption>");
           out.println("<tr style='color:blue'><th>Book ID</th><th>Book Name</th><th>Category</th><th>Author</th><th>Edit</th><th>Delete</th></tr>");
           
           
           while(rs.next())
           {
               String id = rs.getString(1);
               String name = rs.getString(2);
               String cat = rs.getString(3);
               String author = rs.getString(4);
               
               out.println("<tr style='color:blue'><td>"+id+"</td><td>"+name+"</td><td>"+cat+"</td><td>"+author+"</td><td><a href='EditUploadedBooks?status="+id+"'><img src='images/edit.png' width=20 height=20></a></td><td><a href='ShowUploadDelete?status="+id+"'><img src='images/delete.png' width=20 height=20></a></td></tr>");
           }
           
           out.println("</table>");
           out.println("</body>");
           out.println("</html>");
        }
        catch(Exception e)
        {
            out.println(e.getMessage());
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
