import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Display {
	public static void main(String[] args) {
		try {
			//Register the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Create connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","Shan1506");
			//Create statement
			Statement stmt= con.createStatement();
			//Execute queries
			ResultSet rs = stmt.executeQuery("SELECT * FROM Book");
			System.out.println("SlNo || Book_Name || Author || Available\n");
				while(rs.next()) {
					System.out.println(rs.getInt(1)+" || "+rs.getString(2)+ " || "+rs.getString(3)+" || "+rs.getString(4));
				}
			//Close connection
			con.close();
					
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
