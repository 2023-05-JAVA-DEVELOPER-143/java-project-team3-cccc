package order;

import java.util.List;

import cart.CartDao;
import product.ProductDao;

public class OrderService {
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao;
	
	public OrderService() throws Exception{
		orderDao = new OrderDao();
	}
	
	/*
	 * 주문1개삭제
	 */
	public int deleteOrderNo(int o_no) throws Exception {
		return orderDao.deleteByO_NO(o_no);
	}
	
	/*
	 * 주문전체삭제
	 */
	public int deleteUserAll(String userid)throws Exception {
		return orderDao.deleteByUserid(userid);
	}
	
	/*
	 * 주문목록
	 */
	public List<Order> OrderList(String userid) throws Exception{
		return orderDao.findOrderbyUserId(userid);
	}
	
	/*
	 * 주문상세보기
	 */
	public Order OrderDetail(Order order) throws Exception{
		return orderDao.findOrderWithProductByUserId(order.getUserId(), order.getO_no());
	}
	
	/*
	 * 결제하기
	 */
	public int OrderCash(Order order) throws Exception{
		int rowCount = orderDao.insert(order);
		cartDao.deleteByUserId(order.getUserId());
		return rowCount;
	}
	
	
}
