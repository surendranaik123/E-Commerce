package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
@WebServlet("/Product_Manual")
public class ProductManual extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into prod(id,name,category,price,image) values(?,?,?,?,?)");
			/*ps.setInt(1, 1);
			ps.setString(2, "New Arrival Men Shoes");
			ps.setString(3, "Men Boots Shoe");
			ps.setString(4, "240.00");
			FileInputStream fi1=new FileInputStream("E:/image/2.jpg");
			ps.setBlob(5, fi1);*/
			
			
			ps.setInt(1, 2);
			ps.setString(2, "Men Casual Shoes For Office");
			ps.setString(3, "Men Casual Shoes");
			ps.setDouble(4, 510.00);
			InputStream fi2=new FileInputStream("E:/image/download (2).jpg");
			ps.setBlob(5, fi2);
			
			
			/*ps.setInt(1, 3);
			ps.setString(2, "Pulling off a casual look");
			ps.setString(3, "Men Chukka boot");
			ps.setString(4, "430.00");
			FileInputStream fi3=new FileInputStream("E:/image/Men Chukka boot.jpg");
			ps.setBlob(5, fi3);
			
			
			ps.setInt(1, 4);
			ps.setString(2, "Designed for basketball players");
			ps.setString(3, "Men High-Top Shoes");
			ps.setString(4, "600.00");
			FileInputStream fi4=new FileInputStream("E:/image/Men High-Top Shoes.jpg");
			ps.setBlob(5, fi4);
			
			
				
			ps.setInt(1, 5);
			ps.setString(2, "Protect your feet against bruising");
			ps.setString(3, "Men Hiking Shoes");
			ps.setString(4, "880.00");
			FileInputStream fi5=new FileInputStream("E:/image/Men Hiking Shoes.jpg");
			ps.setBlob(5, fi5);
			
			
			
			ps.setInt(1, 6);
			ps.setString(2, "Suede loafers to keep things casual.");
			ps.setString(3, "Men loafer Shoes");
			ps.setString(4, "340.00");
			FileInputStream fi6=new FileInputStream("E:/image/Men loafer Shoes.jpg");
			ps.setBlob(5, fi6);
			
			
			ps.setInt(1, 7);
			ps.setString(2, "Outdoor shoes or Indoor slippers");
			ps.setString(3, "Men Maccasin Shoes");
			ps.setString(4, "1110.00");
			FileInputStream fi7=new FileInputStream("E:/image/Men Maccasin Shoes.jpg");
			ps.setBlob(5, fi7);
			
			ps.setInt(1, 8);
			ps.setString(2, "Traditional men's dress shoes");
			ps.setString(3, "Men Oxford Shoes");
			ps.setString(4, "425.00");
			FileInputStream fi8=new FileInputStream("E:/image/Men Oxford Shoes .jpg");
			ps.setBlob(5, fi8);
			
				ps.setInt(1, 9);
			ps.setString(2, "Excellent as walking shoes");
			ps.setString(3, "Men Sports Shoes");
			ps.setString(4, "550.00");
			FileInputStream fi9=new FileInputStream("E:/image/Men Sports Shoes.jpg");
			ps.setBlob(5, fi9);
			
			ps.setInt(1, 10);
			ps.setString(2, "Smart casual settings");
			ps.setString(3, "Men Suede Shoes");
			ps.setString(4, "659.00");
			FileInputStream fi=new FileInputStream("E:/image/Men Suede Shoes.jpg");
			ps.setBlob(5, fi);*/
			
			
	
			ps.executeUpdate();
			
			System.out.println("image Upload");
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	
	}

}
