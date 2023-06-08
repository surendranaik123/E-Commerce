package connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	private static Connection connection = null;
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
        if(connection == null){
        	Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection= (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
            System.out.print("connected");
        }
        return connection;
    }
}

