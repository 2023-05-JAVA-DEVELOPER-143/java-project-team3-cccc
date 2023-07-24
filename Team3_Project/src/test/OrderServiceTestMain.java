package test;

import java.util.ArrayList;
import java.util.List;

import order.Order;
import order.OrderItem;
import order.OrderService;

public class OrderServiceTestMain {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		OrderService orderService = new OrderService();
		//주문 1개 삭제 테스트 완료
			//System.out.println(orderService.deleteOrderNo(94));
			List<OrderItem> items = new ArrayList<OrderItem>();
			System.out.println(orderService.OrderCash(new Order(0, "바지외 ..", null, 13200, "dddd", null)));
			
	}

}
