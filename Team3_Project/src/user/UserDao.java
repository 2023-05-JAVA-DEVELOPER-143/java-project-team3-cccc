package user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DataSource;

/*
이름       널?       유형            
-------- -------- ------------- 
USERID   NOT NULL VARCHAR2(100) 
PASSWORD          VARCHAR2(100) 
NAME              VARCHAR2(100) 
ADDRESS           VARCHAR2(100) 
PHONE             VARCHAR2(50)  
GENDER            VARCHAR2(10) 
*/

public class UserDao {
	private DataSource dataSource;
	
	public UserDao() throws Exception{
		dataSource = new DataSource();
	}
	
	public int insert(User user) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_INSERT);
		pstmt.setString(1, user.getUserId());
		pstmt.setString(2, user.getPassword());
		pstmt.setString(3, user.getName());
		pstmt.setString(4, user.getAddress());
		pstmt.setString(5, user.getPhone());
		pstmt.setString(6, user.getGender());
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		
		return rowCount;
	}
	//delete:고객 아이디에 해당하는를 고객정보를 삭제
	public int delete(String userId) throws Exception {
	    Connection con = dataSource.getConnection();
	    PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_DELETE);
	    pstmt.setString(1, userId);
	    int deleteRowCount = pstmt.executeUpdate();
		
	    pstmt.close();
	    dataSource.close(con);
		
	    return deleteRowCount;
	}
	//ss

	public int update(User user)throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
		pstmt.setString(1, user.getPassword());
		pstmt.setString(2, user.getName());
		pstmt.setString(3, user.getAddress());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getGender());
		pstmt.setString(6, user.getUserId());
		int rowCount = pstmt.executeUpdate();
		
		
		return rowCount;
	}
	

	public User selectById(String userId) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(null);
		
		
		return null;
	}

}
