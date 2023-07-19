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
		
		return rowCount;
	}
	
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
	
	
}
