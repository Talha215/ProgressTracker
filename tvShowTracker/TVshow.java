package tvShowTracker;
import java.util.Scanner;


import connections.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TVshow {
	public static void main(String[] args) {
		addtvshow();
	}

	private static void addtvshow() {
		// TODO Auto-generated method stub
		System.out.println("Choose a tv show?");
		try (Connection conn = ConnectionManager.getConnection()) {

			//Statement stmt = conn.createStatement();
			Scanner sc = new Scanner(System.in);
			int tvshows_id = sc.nextInt();
			
			sc.nextLine();
			
			int login_id = sc.nextInt();
			PreparedStatement pstmt = conn.prepareStatement("select tvshow_name from tvshows where tvshows_id = ?");
			String tvshow_name = "";
			pstmt.setInt(1, tvshows_id );
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
		
				tvshow_name = rs.getString("tvshow_name");
		
				
			}
		

		
			PreparedStatement pstmt1 = conn.prepareStatement("INSERT into users(tvshows_id, login_id, show_name, show_status, progress) values(?,?,?, 'not complete', 1 )");
			
			pstmt1.setInt(1, tvshows_id);
			pstmt1.setInt(2, login_id);
			pstmt1.setString(3, tvshow_name);
			pstmt1.executeUpdate();
			
			
			System.out.println("SuccessFully selected a show");
			
			
			}catch(SQLException e) {
			System.out.println("User did not select show");
			e.printStackTrace();
			
		} 
	}


}
