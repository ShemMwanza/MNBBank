
package mybank;

import java.sql.Connection;
import java.sql.*;


public class DatabaseCon {
    
    
     private static Connection connection;
    
    
    public static Connection getCon() throws Exception{
        if (connection == null)
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/mybank","root"," ");
            
        }
        return connection;
    }
    public static void setData(String s) throws Exception{
        DatabaseCon.getCon().createStatement().executeUpdate(s);
        
    }
    public static ResultSet getData(String s)throws Exception{
        
        return DatabaseCon.getCon().createStatement().executeQuery(s);
        
        
    }
}