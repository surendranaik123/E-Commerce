package servlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Register")


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String language = request.getParameter("language");
		String zipcode = request.getParameter("zipcode");
		String about = request.getParameter("about");

	

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into Registration values(?,?,?,?,?,?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setString(4, phone);
			ps.setString(5, gender);
			ps.setString(6, address);
			ps.setString(7, language);
			ps.setString(8, zipcode);
			ps.setString(9, about);

		   ps.executeUpdate();

			if (ps.equals(ps)) {
                   RequestDispatcher  requestDispatcher=(RequestDispatcher) request.getRequestDispatcher("");
                    requestDispatcher.forward(request,response);
				

			} else {

				out.print("not exsisted");
			}

		} catch (Exception e) {
			e.printStackTrace();

			RequestDispatcher	requestDispatcher = request.getRequestDispatcher("failed.html");
	               requestDispatcher.forward(request, response);
		}

		out.close();

	}

}
