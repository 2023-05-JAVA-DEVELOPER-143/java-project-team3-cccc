package order;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;
import product.Product;

public class OrderDao {
	private DataSource dataSource;

	// 데이터 소스 생성
	public OrderDao() throws Exception {
		dataSource = new DataSource();
	}

	// 상품주문_전체주문_유저
	public int insert(Order order) throws Exception{
		Connection con = null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		
		try {
			con = dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt	(2, order.getO_price());
			pstmt1.setString(3, order.getUserId());
			pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			for(OrderItem orderItem:order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getOi_no());
				pstmt2.executeUpdate();
			}
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}

	// 개인주문삭제(ORDER_DELETE_BY_USERID)
	public int deleteByUserid(String userid) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_USERID);
		pstmt.setString(1, userid);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	
	// 주문번호로 삭제 (ORDER_DELETE_BY_O_NO)
	public int deleteByO_NO(int o_no) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_DELETE_BY_O_NO);
		pstmt.setInt(1, o_no);
		int rowCount = pstmt.executeUpdate();
		
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}
	

	// 주문 리스트 유저의 전체주문리스트(ORDER_SELECT_BY_USERID)
	public List<Order> findOrderbyUserId(String userId) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_BY_USERID);
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Order> orderList = new ArrayList<Order>();
		Order order = null;
		while(rs.next()) {
			int no = rs.getInt("o_no");
			String desc = rs.getString("o_desc");
			Date date = rs.getDate("o_date");
			int price = rs.getInt("o_price");
			String id = rs.getString("userid");
			order = new Order(no, desc, date, price, id , null );
			orderList.add(order);
		}
		
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return orderList;
	}
	
	// 주문 리스트 1건_유저아이디+상품로 주문 검색(ORDER_SELECT_WITH_PRODUCT_BY_USERID)
	public Order findOrderWithProductByUserId(String userid,int o_no) throws Exception{
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSQL.ORDER_SELECT_WITH_PRODUCT_BY_USERID);
		pstmt.setString(1, userid);
		pstmt.setInt(2, o_no);
		ResultSet rs = pstmt.executeQuery();
		Order order = null;
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>(); 
		if(rs.next()) {
			String o_desc = rs.getString("o_desc");
			Date o_date = rs.getDate("o_date");
			int o_price = rs.getInt("o_price");
			
			while(rs.next()) {
				int oi_no = rs.getInt("oi_no");
				int oi_qty = rs.getInt("oi_qty");
				
				orderItemList.add(new OrderItem(oi_no, oi_qty, o_no,
						new Product(rs.getInt("p_no"),
								rs.getString("p_name"),
								rs.getInt("p_price"),
								rs.getString("p_image"),
								rs.getString("p_desc"))));
			}
			order = new Order(o_no, o_desc, o_date, o_price, userid, orderItemList);
		}
		rs.close();
		pstmt.close();
		dataSource.close(con);
		return order;
	}
	
}
