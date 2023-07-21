package test;

import java.sql.Date;
import java.util.ArrayList;

import order.Order;
import order.OrderDao;
import order.OrderItem;
import product.Product;
import product.ProductDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
	
		OrderDao orderDao = new OrderDao();
		System.out.println(orderDao.findOrderbyUserId("1234"));
//		System.out.println(orderDao.findByOrderNo(1));
		
		// 상품주문_전체주문_유저
		/*
		ProductDao productDao=new ProductDao();
		Product product=productDao.SelectByPK(1);
		ArrayList<OrderItem> jumunList=new ArrayList<OrderItem>();
		Order Jumun1= new Order(0, "테스트1", null, 1200 ,"1234", jumunList);
		orderDao.insert(Jumun1);
		System.out.println(orderDao.insert(Jumun1));
		
		//orderDao.insert(new Order(0, "asd", null, 50000, "aaa", null));
		//orderDao.deleteByUserid("aaa");
		orderDao.deleteByO_NO(5);
		
//		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
//		Product product = new Product(0, null, 0, null, null);
//		OrderItem orderitem = new OrderItem(1, 1, 1, product);
//		
//		Order order = new Order(0, "asd", null, 789456, "aaa", null);
		*/
		
		
		int p_qty = 1; //상품 주문 갯수
		int p_no = 1; //상품 번호 지정
		
		ProductDao productDao = new ProductDao(); //상품Dao 접근
		Product product = productDao.SelectByPK(p_no); //상품 번호로 상품 콜
		
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		orderItemList.add(new OrderItem(0, p_qty, p_no, product)); // nextval로 증가 , 주문 갯수 , 상품 번호 , 상품
		
		Order order= new Order(0,product.getP_name(), new Date(0), product.getP_price(), "1234",orderItemList);
		orderDao.insert(order);
		
		System.out.println(orderDao.findOrderbyUserId("1234"));
		
	}

}
