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

public class EditAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NumberFormatException{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("mobile");

		try {
			pw.println("<center>");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement(" update Admin set name=?,mobile=?,email=?,password=? where id=?");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
            ps.setInt(4, id);
            int count = ps.executeUpdate();
            if(count==1) {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Edited Successfully</h2>");
            }else {
                pw.println("<h2 class='bg-danger text-light text-center'>Record Not Edited</h2>");
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	    pw.println("</center>");
		pw.close();
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
