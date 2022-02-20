import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminHome extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
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
"}</style>");
            out.println("</head>");
            out.println("<body class='bg-img'>");
            
            out.println("<div align=right>");
            RequestDispatcher rd = request.getRequestDispatcher("AdminLogout.html");
            rd.include(request, response);
            out.println("</div>");
            
            out.println("<h1 align=center style=color:blue>Welcome Admin To Home Page</h1>");
            out.println("<p align=center><a href='upload_books.jsp'>Click here to Upload books</a></p>");
            out.println("<p align=center><a href='ShowUploadedBooks'>Show all the Uploaded books</a></p>");
            out.println("</body>");
            out.println("</html>");
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
