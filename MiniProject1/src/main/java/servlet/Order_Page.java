package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Order;
import Model.User;
import connection.DbCon;

@WebServlet("")
public class Order_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date();

			User auth = (User) request.getSession().getAttribute("auth");

		if (auth!=null) {

			String productId = request.getParameter("id");
			
			//int productQuantity = Integer.parseInt(request.getParameter("quantity"));
			
			String quantity = request.getParameter("quantity");
	        int productQuantity = Integer.parseInt(quantity);
			
			if (productQuantity <= 0) {
				productQuantity = 1;
				
			}
			Order ordermodel = new Order(DbCon.getConnection());
			ordermodel.setId(Integer.parseInt(productId));
			ordermodel.setUid(auth.getId());  
			ordermodel.setQunatity(productQuantity);
			ordermodel.setDate(formatter.format(date));

			Dao.Order ordredao = new Dao.Order();
			Boolean result = ordredao.insertOrder(ordermodel);
			if (result) {
				response.sendRedirect("order.jsp");
			} else {
				out.print("order failed");
			}
		} else {
			 response.sendRedirect("Loginpage.jsp");
		}

		}   catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}
