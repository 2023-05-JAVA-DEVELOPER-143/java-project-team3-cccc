package cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import common.DataSource;

public class CartDao {  
	
	private DataSource dataSource;
	
	public CartDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
	// userid cart 내의 제품 존재여부
	public int countByProductNo(String userid, int p_no) {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(userid);
		
		return 0;
	}
	
	//cart insert
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
	
	//상품창에서 갯수 추가 update 
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
	
	//  이해 못한 부분있어서 남깁니다
	/*
	//본인 카트에서 갯수 추가 update
	public int updateProduct1up(int cart_no, int cart_qty)  {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSQL.CART_PRODUCT_1UP);
			pstmt.setInt(1, cart_qty);
			pstmt.setString(2,userId);
			pstmt.setInt(3, cart.getProduct().getP_no());
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;

	}*/
	

	//cart List-find
	public List<Cart> findByUserId(String userId)  {
		return null;
	}
	//cart PK delete
	public int deleteByCartNo(int cart_no)  {
		return 0;
	}
	//cart userId delete
	public int deleteByUserId(String userId)  {
		return 0;
	}
	//Cart no로 Cart search
	public Cart findByCartNo(int Cart_no) {
	return null;
	}
	
	
}
