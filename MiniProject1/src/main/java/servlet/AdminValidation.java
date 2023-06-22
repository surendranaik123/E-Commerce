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

import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class AdminValidation
 */
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
		
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        request.setAttribute("email", email);
        request.setAttribute("password", password);
 
        try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("connection done");
			PreparedStatement pst = con.prepareStatement("select * from Admin where email=? and password=?");

			pst.setString(1, email);
			pst.setString(2, password);
			
			
			ResultSet rs = pst.executeQuery();
			RequestDispatcher requestDispatcher=null;
			
		    if(rs.next()){  
		    	  response.sendRedirect("NewFile.jsp");
		    }  
		    else{  
		        out.print("Sorry username or password error");  
		      //  RequestDispatcher rd=request.getRequestDispatcher("index.html");  
		      //  rd.include(request,response);  
		    }  
		        
        
		    out.close();  
		} catch (Exception e) {
			// TODO: handle exception
		}
        }
        	
        	
		     
		  
	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	}

}
