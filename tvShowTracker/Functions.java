package tvShowTracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import connections.ConnectionManager;

public class Functions {
	private static int userID = -1;

	public static int getUserID() {
		return userID;
	}

	/**
	 * checks the DB for username and password match returns true if login is found,
	 * false if not found sets userID if login was found (to be used with other
	 * methods)
	 */
	public static void login(String username, String password) throws InvalidLoginException {
		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT login_id, user_name, passcode FROM login");

			while (rs.next()) {
				String id = rs.getString("login_id");
				String user = rs.getString("user_name");
				String pass = rs.getString("passcode");

				if (user.equals(username) && pass.equals(password)) {
					userID = Integer.parseInt(id);
					System.out.println("Successfully logged in!");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Could not make connection.");
		}

		if (userID < 0)
			throw new InvalidLoginException();
	}

	public static void viewProgress() {
		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT tvshows_id, show_name, show_status, progress FROM users");

			List<String> notCompleted = new ArrayList<>();
			List<String> inProgress = new ArrayList<>();
			List<String> completed = new ArrayList<>();

			while (rs.next()) {
				String tvShowID = rs.getString("tvshows_id");
				String tvShowName = rs.getString("show_name");
				String status = rs.getString("show_status");
				int progress = rs.getInt("progress");

				String entry = "Tv Show - ID: " + tvShowID + ", Name: '" + tvShowName + "',"
						+ (status.equals("in-progress") ? "" : (" Progress: " + progress + "%"));
				switch (status) {
				case "not completed":
					notCompleted.add(entry);
					break;
				case "in-progress":
					inProgress.add(entry);
					break;
				case "completed":
					completed.add(entry);
					break;
				}
			}

			System.out.println("Not Completed");
			System.out.println("-------------");
			notCompleted.forEach((entry) -> System.out.println(entry));

			System.out.println("\nIn Progress");
			System.out.println("-------------");
			inProgress.forEach((entry) -> System.out.println(entry));

			System.out.println("\nCompleted");
			System.out.println("-------------");
			completed.forEach((entry) -> System.out.println(entry));

		} catch (SQLException e) {
			System.out.println("ViewProgress: Could not make connection.");
		}
	}

	public static void removeShow(int showID) {
		try (Connection conn = ConnectionManager.getConnection()) {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM users WHERE login_id= ? and show_id= ? ");
			pstmt.setInt(1, userID);
			pstmt.setInt(2, showID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Could not make connection.");
		}
	}

	public static void change() {

		System.out.println("Which entry do you want to update?");

		// List out all the show they have currently added and their progress FOR THE
		// APPROPIATE USER

		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE login_id = 1");

			while (rs.next()) {
				String id = rs.getString("tvshows_id");
				String showname = rs.getString("show_name");
				String status = rs.getString("show_status");

				System.out.println("SHOW ID: " + id + " | " + showname + " | Status = " + status);
			}

			Scanner input = new Scanner(System.in);
			System.out.println("Enter the user SHOW ID: ");
			int theID = input.nextInt();
			input.nextLine();

			System.out.println("Enter the current status: ");
			String update = input.nextLine();

			PreparedStatement pstmt = conn.prepareStatement("update users set show_status = ? where tvshows_id = ?");
			pstmt.setString(1, update);
			pstmt.setInt(2, theID);

			int run = pstmt.executeUpdate();

			// int update = stmt.executeUpdate("update users set show_status = \"not
			// completed\" where users_id = 1");
			// System.out.println("Row Updated");
			// \"in-progress\"

			input.close();

		} catch (SQLException e) {
			System.out.println("Could not make connection.");
		}
	}

	public static void display() {

		try (Connection conn = ConnectionManager.getConnection()) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM tvshows");

			while (rs.next()) {
				String id = rs.getString("tvshows_id");
				String name = rs.getString("tvshow_name");

				System.out.println("SHOW ID: " + id + " | Name: " + name);
			}

		} catch (SQLException e) {
			System.out.println("Could not make connection.");
		}

	}
}
