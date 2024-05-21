import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class Rowset {

	public static void main(String[] args) throws ClassNotFoundException{
		try {
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet rs = rsf.createJdbcRowSet();
			rs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			rs.setUsername("SYSTEM");
			rs.setPassword("Shan1506");
			
			rs.setCommand("SELECT * FROM STUDENT");
			rs.execute();
			
			System.out.println("Student details in FORWARD Direction:");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			System.out.println("\nStudent deatils in BACKWARD direction:");
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			}
			System.out.println("\nFIRST Student record:");
			rs.first();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			
			System.out.println("\nLAST Student record:");
			rs.last();
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			
			System.out.println("\nStudent details from ABSOLUTE position:");
			rs.absolute(3);
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
			
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
