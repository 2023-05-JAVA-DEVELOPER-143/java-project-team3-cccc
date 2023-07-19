package user;

public class UserService {

	private UserDao userDao;
	public UserService() throws Exception{
		userDao = new UserDao();
	}
	//로그인
	public User login(String userid,String password)throws Exception{
		User loginUser =userDao.selectById(userid);
		if(loginUser!=null && loginUser.getPassword().equals(password)) {
			
			return loginUser;
		}
		
		
		return null;
		
		
	}
	//회원 수정 
	public int loginUpdate(User user)throws Exception{
		int loginupdate=userDao.update(user);
		return loginupdate;
	}
	
	
	
	
}
