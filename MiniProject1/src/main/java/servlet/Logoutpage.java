package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/Log_out1")
public class Logoutpage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
			try {
				if(request.getSession().getAttribute("auth")!=null) {
					request.getSession().removeAttribute("auth");
					response.sendRedirect("Loginpage.jsp");
				}else {
					response.sendRedirect("index.jsp");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
