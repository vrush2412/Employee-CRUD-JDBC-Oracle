package linkcode.DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection(){
    	Connection con=null;
    	try {
			Class.forName("oracle.jdbc.OracleDriver");
			
			//step2-Connection to database
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			
			System.out.println("Connection to database:"+con);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return con;
    }
}
