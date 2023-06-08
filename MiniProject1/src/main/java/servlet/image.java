package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class image extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//PrintWriter out=response.getWriter();
	
	//	String name = request.getParameter("name");
		//String image = request.getParameter("image");
		
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into image(name,image) values(?,?)");
			
			ps.setString(1, "230");
			
			FileInputStream fi=new FileInputStream("E:/image/Men Boots Shoes.jpg");
			ps.setBlob(2, fi);
		
		
			ps.executeUpdate();
			
			System.out.println("image Upload");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
