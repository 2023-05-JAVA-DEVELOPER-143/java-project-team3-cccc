package test;

import java.util.List;

import cart.Cart;
import cart.CartService;
import product.Product;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception{
		CartService cartService = new CartService();
		
		/*
		 * 카트추가 or 수정(test완료)
		 */

		Cart cart2 = new Cart(0, "aaa",new Product(11, "농구공", 50000, null, "NBA농구공") , 10);
		cartService.addCart(cart2);
		
		
		
		//  카트수량변경수정(test완료)
		 
			//상품창에서 갯수 선택 추가(test완료)
			System.out.println(cartService.updateCartCartQty("5124", 4, 13));
	
			// 상품리스트에서 장바구니 클릭(1개 추가) update(test완료)
			System.out.println(cartService.updateCartBasket("dddd", 8));
		
		
		// 카트보기 getCartItemByUserId(test완료)
		List list =cartService.getCartItemByUserId("aaa");
		System.out.println(list);
		
		
		 //카트아이템1개보기(test완료) 
		Cart cart1 =cartService.getCartItemByCartNo(36);
		System.out.println(cart1);
		
		
		 //카트아이템1개삭제	(test완료)	 
		System.out.println(cartService.cartDeleteByCartNo(40));
		
	
		
		//카트삭제(test완료)
		System.out.println(cartService.cartDeleteByUserId("aaa"));
		

	
	
	
	
	
	
	
	
	
	
	}

}
