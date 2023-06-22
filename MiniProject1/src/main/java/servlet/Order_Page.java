package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Cart;
import Model.Order;
import Model.User;

@WebServlet("")
public class Order_Page extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();

			User auth = (User) request.getSession().getAttribute("auth");

			if (auth != null) {
				String productId = request.getParameter("id");
				// String productQuantity = request.getParameter("quantity");

				int productQuantity = Integer.parseInt(request.getParameter("quantity"));

				if (productQuantity <= 0) {
					productQuantity = 1;
				}
				Order orderModel = new Order();
				orderModel.setId(Integer.parseInt(productId));
				orderModel.setUid(auth.getId());
				orderModel.setQunatity(productQuantity);
				orderModel.setDate(formatter.format(date));

				Dao.Order orderDao = new Dao.Order();
				boolean result = orderDao.insertOrder(orderModel);
				if (result) {

					out.println("order Sucess");
				} else {
					out.println("order failed");
				}
			} else {
				response.sendRedirect("Loginpage.jsp");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
