package user;

public class UserTest {
	public static void main(String[] args) throws Exception{
		UserService service = new UserService();	
		service.create(new User("zzzz", "1234", "zzzz", "제주", "1234", "남"));
		
		
	}
	
}
