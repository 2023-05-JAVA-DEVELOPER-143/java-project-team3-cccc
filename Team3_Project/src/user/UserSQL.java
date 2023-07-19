package user;
/*userId                        		VARCHAR2(100)		 NULL ,
password                      		VARCHAR2(100)		 NULL ,
name                          		VARCHAR2(100)		 NULL ,
address                       		VARCHAR2(100)		 NULL ,
phone                         		VARCHAR2(50)		 NULL ,
gender                        		VARCHAR2(10)		 NULL 
);*/
public class UserSQL {
	
	public static final String USER_INSERT =
	"insert into userinfo values(?,?,?,?,?,?)";

	public static final String USER_UPDATE =
	"update userinfo set password = ?,name = ?,address=?,phone=?,gender=? where userid = ?";


	public static final String USER_DELETE =
	"delete from userinfo where userid=?";

	public static final String USER_SELECT_BY_ID =
	"select * from userinfo where userid = ?";
}
