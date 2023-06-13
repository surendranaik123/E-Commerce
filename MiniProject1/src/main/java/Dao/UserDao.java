package Dao;

import java.sql.*;
import Model.*;

public class UserDao {
	private Connection con;

	private String query;
    private PreparedStatement pst;
    private ResultSet rs;

	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String email, String password) throws ClassNotFoundException {
		User user = null;
        try {
        	
        	Class.forName("oracle.jdbc.driver.OracleDriver");
 		   con= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
 		   PreparedStatement pst=con.prepareStatement("select * from userdata where email=? and password=?");
        
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setName(rs.getString("name"));
            	user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
}