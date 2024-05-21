import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {

	public static void main(String[] args) throws ClassNotFoundException {
		String withdrawQuery = "UPDATE Accounts SET balance = balance - ? WHERE account_num = ?";
		String depositQuery = "UPDATE Accounts SET balance = balance + ? WHERE account_num = ?";
		try {
			// Register the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded Successfully !");
            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shan1506");
            System.out.println("Connection Estabilished Successfully !");
            // Set Auto Commit to false
            con.setAutoCommit(false);
            PreparedStatement withdrawSt = con.prepareStatement(withdrawQuery);
            PreparedStatement depositSt = con.prepareStatement(depositQuery);
            
            withdrawSt.setDouble(1, 500.00);
            withdrawSt.setString(2, "account123");
            depositSt.setDouble(1, 500.00);
            depositSt.setString(2, "account369");
            
            int rowsAffectedWithdraw = withdrawSt.executeUpdate();
            int rowsAffectedDeposit = depositSt.executeUpdate();
            
            
            if(rowsAffectedWithdraw > 0 && rowsAffectedDeposit > 0) {
            	con.commit();
            	System.out.println("Transaction Successfull....");
            } else {
            	con.rollback();
            	System.out.println("Transaction Failed !!!");
            }
            con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
