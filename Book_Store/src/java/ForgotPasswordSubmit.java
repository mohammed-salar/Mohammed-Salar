import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPasswordSubmit extends HttpServlet 
        
{
    PrintWriter out;
    String s;
    String pwd;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        s=request.getParameter("id");
        
        
        try  
        {
            Connection cn = ConnectionPool.getConnection();
            
            Statement smt = cn.createStatement();
            
            ResultSet rs = smt.executeQuery("select password from user where email='"+s+"'");
            
            if(rs.next())
            {
                pwd=rs.getString("password");
            }
            sendMail();
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

    private void sendMail() 
    {
                Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() 
                  {
			protected PasswordAuthentication getPasswordAuthentication() 
                        {
				return new PasswordAuthentication("salarmohammed32@gmail.com","dumbells2527");
			}
		  });

		try 
                {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("salarmohammed32@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(s));
			message.setSubject("Online Book Store");
			message.setText("Dear user Your password of Online Book Store is="+pwd);

			Transport.send(message);

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
"}\n" +
".h1{\n" +
"   \n" +
"    font-size: 40px;\n" +
"	font-weight: 500;\n" +
"	color:#fff;\n" +
"}</style>");
                        out.println("</head>");
                        out.println("<body class='bg-img'>");
                        out.println("<h1 align=center style='color:green' class='h1'>MAIL SENT</h1>");
                        out.println("<h3 align=center><a href='user.html'>Click here again to Login</a></h3>");
                        out.println("</body>");
                        out.println("</html>");
                } 
                catch (MessagingException e) 
                {
                    out.println("EmailId or Password Incorrect="+e.getMessage());
                }
    }

}
