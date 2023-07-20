package test;

import java.util.ArrayList;
import order.Order;
import order.OrderDao;
import order.OrderItem;
import product.Product;
import product.ProductDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
	
		// 상품주문_전체주문_유저
		OrderDao orderDao = new OrderDao();
		/*ProductDao productDao=new ProductDao();
		Product product=productDao.SelectByPK(1);
		ArrayList<OrderItem> jumunList=new ArrayList<OrderItem>();
		Order Jumun1= new Order(0, "테스트", null, 1200 ,"aaa", jumunList);
		orderDao.insert(Jumun1);
		System.out.println(orderDao.insert(Jumun1));*/
		
		//orderDao.insert(new Order(0, "asd", null, 50000, "aaa", null));
		//orderDao.deleteByUserid("aaa");
		orderDao.deleteByO_NO(5);
		
	}

}
