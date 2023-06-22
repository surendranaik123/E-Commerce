package Dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.catalina.connector.Response;
public class Order {
	
	public Boolean insertOrder(Model.Order ordermodel) throws ClassNotFoundException {
        boolean result = false;
      
        try {
        
        	Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection   con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
           PreparedStatement pst=con.prepareStatement("insert into orders (p_id, u_id, o_quantity, o_date) values(?,?,?,?)");
         Model.Order model1=new Model.Order();
          pst.setInt(1, model1.getId());
          pst.setInt(2, model1.getUid());
          pst.setInt(3, model1.getQunatity());
    
            pst.setString(4, model1.getDate());
            pst.executeUpdate();
            result = true;
            if (pst==model1) {
				System.out.println("data insert");
			} else {
				System.out.println("data error");
			}
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

	
/*
    public List<Order> userOrders(int id) {
        List<Order> list = new ArrayList<>();
        try {
            query = "select * from orders where u_id=? order by orders.o_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                ProductDao productDao = new ProductDao(this.con);
                int pId = rs.getInt("p_id");
                Product product = productDao.getSingleProduct(pId);
                order.setOrderId(rs.getInt("o_id"));
                order.setId(pId);
                order.setName(product.getName());
                order.setCategory(product.getCategory());
                order.setPrice(product.getPrice()*rs.getInt("o_quantity"));
                order.setQunatity(rs.getInt("o_quantity"));
                order.setDate(rs.getString("o_date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void cancelOrder(int id) {
        //boolean result = false;
        try {
            query = "delete from orders where o_id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            pst.execute();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return result;
    }*/
}