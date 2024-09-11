
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class MySQL {

    public static Connection conn;
    
    static {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/church_db", "root", "mAvishka@2002");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public static ResultSet execute(String query) {
        
        try {
            
            Statement stmt = conn.createStatement();
            
            if (query.startsWith("SELECT")) {
                ResultSet resultSet = stmt.executeQuery(query);
                return resultSet;
            } else {
                int rs = stmt.executeUpdate(query);
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }

}