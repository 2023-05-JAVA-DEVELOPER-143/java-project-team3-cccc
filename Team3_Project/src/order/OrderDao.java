package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import common.DataSource;

public class OrderDao {
	private DataSource dataSource;

	// 데이터 소스 생성
	public OrderDao() throws Exception {

		dataSource = new DataSource();
	}
	
	// 상품주문_장바구니내

	// 상품주문_선택주문_1건

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
			pstmt2.setInt	(2, orderItem.getOi_no());
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

	// 주문 선택삭제_주문번호로 주문삭제(ORDER_DELETE_BY_USERID)
	
	// 주문 전체삭제()_유저아이디로 주문삭제(ORDER_DELETE_BY_O_NO)
	

	// 주문 리스트	전체_유저아이디로 주문검색(ORDER_SELECT_BY_USERID)
	
	// 주문 리스트 1건_유저아이디+상품로 주문 검색(ORDER_SELECT_WITH_PRODUCT_BY_USERID)


}
