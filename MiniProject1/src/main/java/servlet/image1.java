package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class image1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
	
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into image(name,image) values(?,?)");
			
			ps.setString(1,name);
			
			FileInputStream fi=new FileInputStream(image);
			ps.setBlob(2, fi);
		
		
			ps.executeUpdate();
		
			out.print("image Upload");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
