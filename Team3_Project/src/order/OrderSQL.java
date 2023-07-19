package order;

public class OrderSQL {

	
	// 주문추가
	public final static String ORDER_INSERT = "insert into orders(o_no,o_desc,o_date,o_price, userId) values (orders_o_no_SEQ.nextval,?,sysdate,?,?)";
	
	// 주문상품추가
	public final static String ORDERITEM_INSERT = "insert into order_item(oi_no,oi_qty,o_no,p_no) values(order_item_oi_no_SEQ.nextval,?,orders_o_no_SEQ.currval,?)";
	
	// 유저아이디로 주문삭제
	public final static String ORDER_DELETE_BY_USERID= "delete from orders where userid=?";
	
	// 주문번호로 주문삭제
	public final static String ORDER_DELETE_BY_O_NO ="delete from orders where o_no=?";

	// 유저아이디로 주문 검색
	public final static String ORDER_SELECT_BY_USERID = "select * from orders where userid=?";
		
	// 유저아이디+상품로 주문 검색
	public final static String ORDER_SELECT_WITH_PRODUCT_BY_USERID = 
	"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.userid=? and o.o_no = ?";
	
}
