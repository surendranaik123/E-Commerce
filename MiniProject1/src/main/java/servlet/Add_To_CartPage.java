package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;

import Model.Cart;

@WebServlet("/Add_To_CartPage")
public class Add_To_CartPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try  {
//        	out.print("add to cart servlet");

			ArrayList<Cart> cartList = new ArrayList<>();

			 int id = Integer.parseInt(request.getParameter("id"));
			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);
			jakarta.servlet.http.HttpSession session = request.getSession();
            @SuppressWarnings("unchecked")
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
            if (cart_list == null) {
                cartList.add(cm);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            } else {
                cartList = cart_list;

                boolean exist = false;
                for (Cart c : cart_list) {
                    if (c.getId() == id) {
                        exist = true;
                        out.print("<a href='index.jsp'>GO to Home Page</a>");
                        out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='cart.jsp'>GO to Cart Page</a></h3>");
                    }
                }

                if (!exist) {
                    cartList.add(cm);
                    response.sendRedirect("index.jsp");
                }
            }
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
