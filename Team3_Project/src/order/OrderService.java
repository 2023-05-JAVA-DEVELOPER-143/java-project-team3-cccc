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
	
	/*
	 * 주문전체삭제
	 */
	
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
	 * cart에서 주문
	 */
	
	
}
