package user;

public class UserService {

	private UserDao userDao;
	public UserService() throws Exception{
		userDao = new UserDao();
	}
	
	public User login(String userid,String password)throws Exception{
		User loginUser =userDao.selectById(userid);
		if(loginUser!=null && loginUser.getPassword().equals(password)) {
			
			return loginUser;
		}
		
		
		return null;
		
		
	}
	
	
	
	
}
