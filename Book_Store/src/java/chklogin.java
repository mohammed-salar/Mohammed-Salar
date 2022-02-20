import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class chklogin extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String email = request.getParameter("mail");
            String psswd = request.getParameter("psswd");
            
            Connection cn = ConnectionPool.getConnection();
            
            Statement smt = cn.createStatement();
            
            ResultSet rs = smt.executeQuery("select * from user where email = '"+email+"' and password = '"+psswd+"'");
            
            if(rs.next())
            {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String mobile = rs.getString(5);
                HttpSession hs = request.getSession(true);
                hs.setAttribute("id",id);
                hs.setAttribute("name",name);
                hs.setAttribute("email",email);
                hs.setAttribute("password",psswd);
                hs.setAttribute("mobile",mobile);
                
                RequestDispatcher rd = request.getRequestDispatcher("Home");
                rd.forward(request, response);
            }
            else
            {
                out.println("<h2 align='center'>Email or Password does not match</h2>");
                RequestDispatcher rd = request.getRequestDispatcher("user.html");
                rd.include(request, response);
            }
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
