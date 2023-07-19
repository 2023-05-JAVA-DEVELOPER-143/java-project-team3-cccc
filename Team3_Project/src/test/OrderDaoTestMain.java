package test;

import java.util.ArrayList;
import order.Order;
import order.OrderDao;
import product.Product;
import product.ProductDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
	
		// 상품주문_전체주문_유저
		OrderDao orderDao = new OrderDao();
		ProductDao productDao=new ProductDao();
		Product product=productDao.SelectByPK(1);
		ArrayList<order.OrderItem> jumunList=new ArrayList<order.OrderItem>();		
		Order Jumun1= new Order(0, "테스트", null, 1200 ,"aaa", jumunList);
		orderDao.insert(Jumun1);
		System.out.println(orderDao.insert(Jumun1));
	}

}
