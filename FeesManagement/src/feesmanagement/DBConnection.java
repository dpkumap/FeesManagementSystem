/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package feesmanagement;
import java.sql.*;

public class DBConnection {
    
    public static Connection getConnection()
    {
        Connection con=null;
        try
        {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","postgres");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return con;
    }
    
}
