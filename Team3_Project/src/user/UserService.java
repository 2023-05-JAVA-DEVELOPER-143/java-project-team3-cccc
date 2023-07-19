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
	//회원 수정 
	public int loginUpdate(User user)throws Exception{
		int loginupdate=userDao.update(user);
		return loginupdate;
	}
	
	//회원탈퇴
	   public int deleteUser(String userId) throws Exception{
	      return userDao.delete(userId);
	   }
	
}
