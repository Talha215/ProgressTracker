package tvShowTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;

import java.util.Scanner;

import connections.ConnectionManager;

public class TVshow {
	public static void main(String[] args) {
		addtvshow(1,2);
	}
	public static void addtvshow(int tvshows_id, int login_id) {
		System.out.println("Choose a tv show?");
		
		Scanner sc = new Scanner(System.in);
		
		try (Connection conn = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("INSERT into users(tvshows_id, login_id) values(?,?) ");
			pstmt.setInt(1, tvshows_id);
		
			pstmt.setInt(2, login_id);
			
			pstmt.executeUpdate();
			
	
			}catch(SQLException e) {
			System.out.println("User did not select show");
			e.printStackTrace();
			
		}
		sc.close();
	}
}
