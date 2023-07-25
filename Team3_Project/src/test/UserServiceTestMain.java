package test;

import user.User;
import user.UserService;

public class UserServiceTestMain {

	@SuppressWarnings("null")
	public static void main(String[] args) throws Exception {
		User user = new User();
		UserService userService = new UserService();
		System.out.println(userService.findId("tes", "1234"));

	}

}
