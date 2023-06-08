package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDao {
	private Connection con;
    private ResultSet rs;
	private User UserDao;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) throws ClassNotFoundException {
	
		try {
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			  con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            System.out.print("connected");
        	PreparedStatement pst=con.prepareStatement("select * from suri where email=? and password=?");
         
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	Model.User user= new Model.User(); 
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            	user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return UserDao;
    }
}
