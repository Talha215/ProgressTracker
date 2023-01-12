package tvShowTracker;

public class LoginTest {
	public static void main(String[] args) {
		Login login = new Login("user1", "notpassword");
		if(login.ID > 0)
			System.out.println("Match found with ID: " + login.ID); //does not run
		
		Login anotherUser = new Login("user1", "password1");
		if(anotherUser.ID > 0)
			System.out.println("Match found with ID: " + anotherUser.ID);
		
		Login lastUser = new Login("test3", "test");
		if(lastUser.ID > 0)
			System.out.println("Match found with ID: " + lastUser.ID);
	}
}
