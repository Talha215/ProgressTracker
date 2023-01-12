package tvShowTracker;

public class LoginTest {
	public static void main(String[] args) {
		try {
			Login login = new Login("user1", "notpassword");
			System.out.println("Passed test 1");

			Login anotherUser = new Login("user1", "password1");
			System.out.println("Passed test 2");
			
			Login lastUser = new Login("test3", "test");
			System.out.println("Passed test 3");
		} catch(InvalidLoginException e) {
			e.printStackTrace();
		}
		
	}
}
