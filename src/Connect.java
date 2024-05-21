import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

	public static void main(String[] args) {
		try {
			// Load Driver Class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Create Connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Shan1506");
			
			if(con==null) {
				System.out.println("Connection Unsuccessful");
			} else {
				System.out.println("Connection successful");
			}
			con.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
