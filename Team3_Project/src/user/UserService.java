package user;

public class UserService {
	private UserDao userdao;
	
	public UserService() throws Exception{
		userdao = new UserDao();
	}
	
	public void login(String userid) throws Exception{
		User findUser = userdao.selectById(userid);
		
		
	}
	
}
