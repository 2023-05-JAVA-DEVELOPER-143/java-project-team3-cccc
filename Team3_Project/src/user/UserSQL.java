package user;
/*userId                        		VARCHAR2(100)		 NULL ,
password                      		VARCHAR2(100)		 NULL ,
name                          		VARCHAR2(100)		 NULL ,
address                       		VARCHAR2(100)		 NULL ,
phone                         		VARCHAR2(50)		 NULL ,
gender                        		VARCHAR2(10)		 NULL 
);*/
public class UserSQL {
	
	// 회원등록
	public static final String USER_INSERT =
	"insert into userinfo values(?,?,?,?,?,?)";
	
	// 회원수정
	public static final String USER_UPDATE =
	"update userinfo set password = ?,name = ?,address=?,phone=?,gender=? where userid = ?";
	
	// 회원탈퇴
	public static final String USER_DELETE =
	"delete from userinfo where userid=?";
	
	// 아이디 선택 찾기
	public static final String USER_SELECT_BY_ID =
	"select * from userinfo where userid = ?";
	
	// 아이디 찾기
	public static final String USER_FIND_BY_ID =
	"select * from userinfo where name=? AND phone=?";
	
	// 비밀번호 찾기
	public static final String USER_FIND_BY_PASSWORD =
	"select * from userinfo where userid = ? AND name=? AND phone=?";
	
	// 아이디 중복 확인
	public static final String USER_SELECT_BY_ID_COUNT =
	"select count(*) from userinfo where userid=?";
	
}
