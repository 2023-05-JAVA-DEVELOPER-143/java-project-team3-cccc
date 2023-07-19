package user;

public class UserService {

	private UserDao userDao;
	public UserService() throws Exception{
		userDao = new UserDao();
	}
	
	public int create(User user) throws Exception{
		int check = userDao.countByUserId(user.getUserId());
		if(check < 1) {
			userDao.insert(user);
		}else {
			// 중복
		}
		
		return check;
	}
	
	public User login(String userid,String password)throws Exception{
		User loginUser =userDao.selectById(userid);
		if(loginUser!=null && loginUser.getPassword().equals(password)) {
			
			return loginUser;
		}
		return null;
	}
	
}
