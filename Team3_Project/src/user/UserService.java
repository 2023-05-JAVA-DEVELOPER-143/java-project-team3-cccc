package user;

public class UserService {

	private UserDao userDao;
	public UserService() throws Exception{
		userDao = new UserDao();
	}

	
	public User create(User user) throws Exception{
		int usercount = userDao.countByUserId(user.getUserId());
		if(usercount<1) {
			userDao.insert(user);
		}else {
			// 중복
		}
		return null;
	}
	
	// 회원 로그인
	public User login(String userid,String password) throws Exception{
		User loginUser =userDao.selectById(userid);
		if(loginUser!=null && loginUser.getPassword().equals(password)) {
			return loginUser;
		}
		return null;
	}
	
	// 회원 아이디 찾기
		public User findId(String name,String phone) throws Exception{
			User findUser = userDao.findUserId(name, phone);
			if(findUser!=null && findUser.getName().equals(name) && findUser.getPhone().equals(phone)) {
				return findUser;
			}
			return null;
		}

		// 회원 아이디 찾기
		public User findPassword(String userid, String name, String phone) throws Exception {
			User findUserPassword = userDao.findUserPassword(userid, name, phone);
			if (findUserPassword != null && findUserPassword.getUserId().equals(userid) && findUserPassword.getName().equals(name) && findUserPassword.getPhone().equals(phone)) {
				return findUserPassword;
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
	
	//회원 중복체크
	   public boolean duplicatecheck (String userId)throws Exception{
		  boolean check =true;
		  int loginuser= userDao.countByUserId(userId);
		  if(loginuser<1) {
			  check = false;
		  }
		   return check;
	   }
	   
}
