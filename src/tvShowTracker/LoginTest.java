package tvShowTracker;

public class LoginTest {
	public static void main(String[] args) {
		Login login = new Login("test", "notpassword");
		if(login.ID > 0)
			System.out.println("Match found with ID: " + login.ID); //does not run
		
		Login anotherUser = new Login("test3", "test3");
		if(anotherUser.ID > 0)
			System.out.println("Match found with ID: " + anotherUser.ID);
		
		Login lastUser = new Login("test", "test");
		if(lastUser.ID > 0)
			System.out.println("Match found with ID: " + lastUser.ID);
	}
}
