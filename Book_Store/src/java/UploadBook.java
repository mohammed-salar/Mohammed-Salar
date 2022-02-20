import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import com.oreilly.servlet.MultipartRequest;  
import java.sql.Connection;
import java.sql.Statement;
      
    public class UploadBook extends HttpServlet 
    {  
      
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException 
    {  
      
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
              
    /*MultipartRequest m=new MultipartRequest(request,"C:\\Users\\fcit\\Documents\\NetBeansProjects\\Adv_Java_Project\\web\\book");  
    out.print("successfully uploaded "); */
    
    String filename = request.getParameter("filename");
    String category = request.getParameter("type");
    String author = request.getParameter("author_name");
    
    try
    {
        Connection cn = ConnectionPool.getConnection();
            
        Statement smt = cn.createStatement();
        
        int i=smt.executeUpdate("insert into book (book_name,category,author) values ('"+filename+"','"+category+"','"+author+"')");
        
        if(i>0)
        {
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
".container {\n" +
"  position: absolute;\n" +
"  left: 470;\n" +
"  margin: 0px;\n" +
"  max-width: 500px;\n" +
"  padding: 20px;\n" +
"  background-color: invisible;\n" +
"}\n" +
"input[type=file], input[type=password] {\n" +
"  width: 100%;\n" +
"  padding: 15px;\n" +
"  margin: 5px 0 22px 0;\n" +
"  border: none;\n" +
"  background: #f1f1f1;\n" +
"}\n" +
"\n" +
"input[type=file]:focus, input[type=password]:focus {\n" +
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
            
            out.println("<body class='bg-img'>");
            out.println("<form class='container' action='UploadFile' method='post' enctype='multipart/form-data'>");
            out.println("<table align=center>");
            out.println("<h2 align=center style=color:blue>Choose the File again to Upload </h2>");
            out.println("<tr>");
            out.println("<td style=color:blue>Choose File</td>");
            out.println("<td><input type=file name='file_name'></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=2 align=center><input type=submit value=Upload class=btn></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("</body>");
        }
        else
        {
           out.println("data not insert"); 
        }
        cn.close();
    }
    catch(Exception e)
    {
        out.println(e.getMessage());
    }
    }  
    }  