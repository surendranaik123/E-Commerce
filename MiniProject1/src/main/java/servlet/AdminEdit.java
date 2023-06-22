package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.jgroups.demos.wb.SendDialog;

public class AdminEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
	       
	       try {
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

				System.out.println("connection done");

				PreparedStatement ps = con.prepareStatement("select name,email,password from Admin where id=?");
				
				int id = Integer.parseInt(request.getParameter("id"));
				 ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		                 rs.next();
		                 pw.println("<center>");
		                 pw.println("<tr>");
		                 pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
		                 pw.println("<form action='EditAdmin?id="+id+"' method='get'>");
		                 pw.println("<table class='table table-hover table-striped'>");
		                 
		                 pw.println("Admin Edit Option");
		                 pw.println("<br>");
		                 pw.println("=============");
		             
		                 pw.println("<tr>");
		                 pw.println("<td>Name</td>");
		                 pw.println("<td><input type='text' name='name' value='"+rs.getString(1)+"'></td>");
		                 pw.println("</tr>");
		                
		                 pw.println("<tr>");
		                 pw.println("<td>Email</td>");
		                 pw.println("<td><input type='email' name='email' value='"+rs.getString(2)+"'></td>");
		                 pw.println("</tr>");
		                 
		                 pw.println("<tr>");
		                 pw.println("<td>Password</td>");
		                 pw.println("<td><input type='text' name='password' value='"+rs.getString(3)+"'></td>");
		                 pw.println("<br>");
		                 pw.println("</tr>");
		                 pw.println("<td><button type='submit' class='btn btn-outline-success'>Update</button></td>");
		                 pw.println("</table>");
		                 pw.println("</form>");
		                 pw.println("</div>");
		                 pw.println("</center>");
		                 
		                 
		                 
		} catch (Exception e) {
			e.printStackTrace();
			pw.close();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
