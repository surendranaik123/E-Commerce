package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;

import Dao.UserDao;
import Model.User;
import connection.DbCon;

@WebServlet("/Loginpage")
public class Loginpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		
       
        try {
        	String email = request.getParameter("email");
			String password = request.getParameter("password");

			UserDao udao = new UserDao(DbCon.getConnection());
			User user = udao.userLogin(email, password);
			if (user != null) {
				request.getSession().setAttribute("auth", user);
             	System.out.print("user logged in");
			     response.sendRedirect("index.jsp");
			} else {
				out.println("there is no user");
			}
 
		    out.close();  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
