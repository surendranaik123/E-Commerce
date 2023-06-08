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
public class ProductReg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into Product(id,name,category,price) values(?,?,?,?)");
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setString(4, price);
		
			ps.executeUpdate();
			
			
			if (ps.equals(ps)) {
				

				jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Sucess.html");
				requestDispatcher.forward(request, response);
		
			} else {

				out.print("not exsisted");
			}
			
			
		} catch (Exception e) {

			jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Failed.html");
			requestDispatcher.forward(request, response);
			e.printStackTrace();
		}
	}

}
