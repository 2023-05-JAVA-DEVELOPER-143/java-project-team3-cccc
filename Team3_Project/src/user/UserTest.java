package user;

import java.security.Provider.Service;

public class UserTest {
	public static void main(String[] args) throws Exception{
		UserService service = new UserService();	
		service.create(new User("zzzz", "1234", "zzzz", "제주", "1234", "남"));
		
		//로그인
		User userlogin = service.login("zzzz", "1234");
		System.out.println(userlogin);
		
		//회원수정
		service.loginUpdate(new User("zzzz", "1234", "바뀜", "제주", "1234", "남"));
		//회원 탈퇴
		service.deleteUser("zzzz");
		
		
	}
	
	
}
