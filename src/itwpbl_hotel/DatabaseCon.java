/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itwpbl_hotel;

/**
 *
 * @author abhid
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseCon{
	Connection con;
	Statement s;
	DatabaseCon()
	{
	String url = "jdbc:mysql://localhost:3306/UserLogin";
	String user = "root";
	String pass = "Procoder@2003";
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	 con = DriverManager.getConnection(url,user,pass); 
         s  = con.createStatement();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}

}
