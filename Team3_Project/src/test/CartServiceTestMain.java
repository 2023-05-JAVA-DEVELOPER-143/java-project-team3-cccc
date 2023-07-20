package test;

import java.util.List;

import cart.Cart;
import cart.CartService;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception{
		CartService cartService = new CartService();
		
		/*
		 * 카트추가 or 수정
		 */
		
		
		
		/*
		 * 카트수량변경수정(test완료)
		 */
		//상품창에서 갯수 선택 추가
		System.out.println(cartService.updateCartCartQty("5124", 4, 13));

		// 상품리스트에서 장바구니 클릭(1개 추가) update
		System.out.println(cartService.updateCartBasket("dddd", 8));
		/*
		 * 카트보기 getCartItemByUserId(test완료)
		 */
		List list =cartService.getCartItemByUserId("aaa");
		System.out.println(list);
		
		/*
		 * 카트아이템1개보기(test완료)
		 */
		Cart cart1 =cartService.getCartItemByCartNo(36);
		System.out.println(cart1);
		
		/*
		 * 카트아이템1개삭제
		 */
		
		/*
		 * 카트삭제
		 */
		
		
		

	
	
	
	
	
	
	
	
	
	
	}

}
