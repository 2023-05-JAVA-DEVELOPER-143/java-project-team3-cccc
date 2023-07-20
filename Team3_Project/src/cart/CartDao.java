package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;

import user.User;

import product.Product;


public class CartDao {  
	
	private DataSource dataSource;
	
	public CartDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
	// userid cart 내의 제품 존재여부 (Test완료)
	public int countByProductNo(String userid, int p_no) throws Exception{
		int count=0;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_COUNT_PRODUCT_BY_USERID);
			pstmt.setString(1, userid);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count=rs.getInt(1);
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return count;

	}
	
	//cart insert(Test완료)
	public int insert(Cart cart) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {  
				con=dataSource.getConnection();
				pstmt=con.prepareStatement(CartSQL.CART_INSERT);				
				pstmt.setString(1, cart.getUserId());
				pstmt.setInt(2, cart.getProduct().getP_no());
				pstmt.setInt(3, cart.getCart_qty());
				insertRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
			
		}
		return insertRowCount;
	}
	

	//상품창에서 갯수 추가 update (Test완료)
	public int updateByProductNo(String userId, int p_no, int cart_qty) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_PRODUCT_UP_QTYSET);
			pstmt.setInt(1, cart_qty);
			pstmt.setString(2,userId);
			pstmt.setInt(3, p_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	
	// 상품리스트에서 장바구니 클릭 update
	public int updateProduct1up(String userId , int p_no) throws Exception{
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_PRODUCT_1UP);
			pstmt.setString(1, userId);
			pstmt.setInt(2, p_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	

	//cart List-find //userId를 이용해서 사용자 카트 안의 모든 제품 찾기(Test완료)
	public List<Cart> findByUserId(String userId) throws Exception  {
		List<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL. CART_FIND_ALL_PRODUCT_BY_USERID);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cartList.add(new Cart( rs.getInt("cart_no"),
						 			   rs.getString("userid"),
								       new Product(rs.getInt("p_no"),
							    		       rs.getString("p_name"),
							    		       rs.getInt("p_price"),
							    		       rs.getString("p_image"),
							    		       rs.getString("p_desc")),
									   rs.getInt("cart_qty")));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		
		return cartList;
	}
	

	
	//cart PK delete // Test완료
	public int deleteByCartNo(int cart_no) throws Exception {  
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_NO);
			pstmt.setInt(1, cart_no);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	//cart userId delete
	public int deleteByUserId(String userId) throws Exception {
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, userId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	//Cart no로 Cart search
	public Cart findByCartNo(int cart_no) throws Exception {
		return null;
	}
	
	
}
