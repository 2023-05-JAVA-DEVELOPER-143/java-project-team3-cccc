package ShoppingMall.Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Dao(Data Access Object) 클래스
 * 	 -  address 테이블에 CRUD(Create,Read,Update,Delete)작업을하는 
 *      단위 메쏘드를 가지고있는 클래스	
 */	public class ShoppingMallDao {
	 
	private DataSource dataSource;
	public ShoppingMallDao() throws Exception{
		dataSource = new DataSource();
	}


	public int insert(Shop insertShopMember) throws Exception {
		String insertSql = "insert into ShoppingMallmember values"
				+ "(ShoppingMall_no_seq.nextval,?,?,?,?,?,?)";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(insertSql);
		pstmt.setString(1, insertShopMember.getName());
		pstmt.setString(2, insertShopMember.getBirthday());
		pstmt.setString(3, insertShopMember.getPhone());
		pstmt.setString(4, insertShopMember.getAddress());
		pstmt.setString(5, insertShopMember.getId());
		pstmt.setString(6, insertShopMember.getPassword());
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public int updateByPrimaryKey(Shop updateShopMember) throws Exception {
		String updateSql = "update ShoppingMallmember  set name= ?, birthday = ?, phone= ?, "
				+ "address = ? , id = ? , password = ?  where no= ?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(updateSql);

		pstmt.setString(1, updateShopMember.getName());
		pstmt.setString(2, updateShopMember.getBirthday());
		pstmt.setString(3, updateShopMember.getPhone());
		pstmt.setString(4, updateShopMember.getAddress());
		pstmt.setString(5, updateShopMember.getId());
		pstmt.setString(6, updateShopMember.getPassword());
		pstmt.setInt(7, updateShopMember.getNo());
		int rowCount = pstmt.executeUpdate();
		return rowCount;
	}

	public int deleteByPrimaryKey(int no) throws Exception {
		String deleteSql = "delete from ShoppingMallmember where no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(deleteSql);
		pstmt.setInt(1, no);
		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}

	public Shop findByPrimaryKey(int no) throws Exception {
		Shop findShopMember = null;
		String selectSql = "select no,name,birthday,phone,address,id,password from ShoppingMallmember where no=?";
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(selectSql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String birthday = rs.getString("birthday");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			String id = rs.getString("id");
			String password = rs.getString("password");
			findShopMember = new Shop(number, name,birthday, phone, address, id, password);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return findShopMember;
	}

	public ArrayList<Shop> findAll() throws Exception {
		ArrayList<Shop> shopMemberList = new ArrayList<Shop>();

		String selectSql = "select no, name,birthday, phone, address, id, password from ShoppingMallmember order by no";
		Connection con = dataSource.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(selectSql);
		while (rs.next()) {
			int number = rs.getInt("no");
			String name = rs.getString("name");
			String birthday = rs.getString("birthday");
			String phone = rs.getString("phone");
			String address = rs.getString("address");
			String id = rs.getString("id");
			String password = rs.getString("password");
			Shop tempShopMember =  new Shop(number, name,birthday, phone, address, id, password);
			shopMemberList.add(tempShopMember);

		}
		rs.close();
		stmt.close();
		dataSource.close(con);
		return shopMemberList;
	}

}