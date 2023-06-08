package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class imagefetch extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {

        	Class.forName("oracle.jdbc.driver.OracleDriver");
		    Connection   con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
		    System.out.print("connected done");
             PreparedStatement pst=con.prepareStatement("select * from image");
               ResultSet rs=  pst.executeQuery();
           
               while(rs.next()) {
                   image im= new image();
               
                
               }
               
               
               con.close();  
             
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
