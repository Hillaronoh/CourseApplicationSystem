/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package myproject;

import java.sql.*;

/**
 *
 * @author hillary
 */
public class Common {
    static Connection conn=null;
    String db="jdbc:mysql:///project1c";
    String user="root";
    String password="";
    
    public Common() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(db,user,password);
        }
        catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
}

