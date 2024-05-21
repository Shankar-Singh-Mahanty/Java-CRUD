import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedure {

	public static void main(String[] args) {
		try {
			// Register the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded Successfully !");
            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shan1506");
            System.out.println("Connection Estabilished Successfully !");
            
            CallableStatement stmt = con.prepareCall("{call \"INSERTStudent\"(?, ?, ?, ?)}");

            stmt.setInt(1, 6);
            stmt.setString(2, "Ankur");
            stmt.setString(3, "DSC");
            stmt.setString(4, "6th");
            // Execute
            stmt.execute();
            
            System.out.println("Record Inserted Successfully...");
            
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
