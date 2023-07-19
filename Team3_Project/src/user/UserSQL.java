package user;

public class UserSQL {
	
	public static final String USER_INSERT =
	"insert into userinfo values(?,?,?,?,?,?)";
	
	public static final String USER_SELECT_BY_ID =
	"select * from userinfo where userid = ?";
	
}
