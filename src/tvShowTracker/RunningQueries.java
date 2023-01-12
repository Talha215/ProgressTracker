package tvShowTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import connections.ConnectionManager;

public class RunningQueries {
	
	public static void main(String[] args) {
		
		// Connection -> represent the connection to the DB
		//Connection conn = ConnectionManager.getConnection();
		
		
		try (Connection conn = ConnectionManager.getConnection()) {
			
			// STATEMENT --> represent an SQL statement we need to run
			
			// create the object that represents the statement
			Statement stmt = conn.createStatement();
			
			
			// execute some sort of update (update, delete, insert, things that change data in a table)
			// count = number of rows changed/updated
			int count = stmt.executeUpdate("insert into address(street, city, state, zip_code) values('13 Jump Street', 'Chicago', 'IL', '12345')");
			
			System.out.println("Rows Inserted: " + count);
			
			// can reuse the same statement and run different queries
			count = stmt.executeUpdate("update address set street = '100 Other Street' where city = 'Chicago'");
			
			System.out.println("Rows Updated: " + count);
			
			
			// statements should be closed once you are done using them
			stmt.close();
			
			
			// PreparedStatement is going to have parameters / arguments for different parts of your query
			PreparedStatement pstmt = conn.prepareStatement("update address set street = ? where city = ?");
			
			pstmt.setString(1, "1 Hello Street");
			pstmt.setString(2, "Chicago");
			
			count = pstmt.executeUpdate();
			
			System.out.println("Rows Updated with Pr. Stmt: " + count);
			
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
