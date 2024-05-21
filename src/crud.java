import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class crud {

    public static void main(String[] args) {
        String Query1 = "CREATE TABLE Student(Id number(3), Name varchar2(30), Branch char(5), Semester varchar2(5) )";
        String[] Query2 = {
                "INSERT INTO Student VALUES(1,'Shankar','CSE','6th')",
                "INSERT INTO Student VALUES(2,'Ankur','CSE','6th')",
                "INSERT INTO Student VALUES(3,'Jyoti','AIML','2nd')",
                "INSERT INTO Student VALUES(4,'Isha','ICAR','1st')",
                "INSERT INTO Student VALUES(5,'Shipu','CSE','4th')"
        };
        String Query3 = "UPDATE Student SET Branch = 'CSIT' WHERE Id = 4";
        String Query4 = "DELETE FROM Student WHERE Name = 'Ankur'";
        try {
            // Register the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // Establish connection
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "Shan1506");
            // Create a statement object
            Statement stmt = con.createStatement();
            // Run Create Query
            stmt.execute(Query1);
            System.out.println("Table Created Successfully");
            
            // Execute Insert Queries using a loop
            for (String insertQuery : Query2) {
                stmt.execute(insertQuery);
            }
            System.out.println("\nRecords Inserted Successfully");

            // Display the Records
            displayRecords(stmt);

            // Update a Record
            stmt.executeUpdate(Query3);
            System.out.println("\nRecord Updated Successfully");

            // Display the Record after updating
            displayRecords(stmt);

            // Delete a Record
            stmt.execute(Query4);
            System.out.println("\nRecord Deleted Successfully");

            // Display all records after deleting one record
            displayRecords(stmt);

            // Closing the connection
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    private static void displayRecords(Statement stmt) {
        try {
            // Display the Records
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
            rs.close(); // close the ResultSet after use
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}