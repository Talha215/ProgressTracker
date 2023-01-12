package tvShowTracker;

public class LoginTest {
	public static void main(String[] args) {
		Login login = new Login("not", "one");
		if(login.ID > 0)
			System.out.println("Match found with ID: " + login.ID);
		
		Login anotherUser = new Login("test", "test");
		if(anotherUser.ID > 0)
			System.out.println("Match found with ID: " + anotherUser.ID);
	}
}
