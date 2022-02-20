
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionPool 
{
    static Connection cn;
    
    public static Connection getConnection()
    {
        try
        {
           //load the driver
            Class.forName("com.mysql.jdbc.Driver");
            //create connection
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database1", "root", ""); 
        }
        catch(Exception e)
        {
            
        }
        return cn;
    }
}
