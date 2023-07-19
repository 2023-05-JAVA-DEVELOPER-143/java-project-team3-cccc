package test;



import user.User;
import user.UserDao;

public class UserDaoTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	UserDao userDao = new UserDao();
	
	
	System.out.println("0.delete   --> "+userDao.delete("dddd"));
	System.out.println("1.insert   --> "+userDao.insert(new User("dddd", "dddd", "김삼조", "서울시","1234-1234" ,"남")));
	System.out.println("2.update   --> "+userDao.update(new User("dddd", "dddd", "이감조", "수원시","1234-1234" ,"남")));
	System.out.println("3.selectById-> "+userDao.selectById("dddd"));
	
	
	
	
	
	
	}
	

}
