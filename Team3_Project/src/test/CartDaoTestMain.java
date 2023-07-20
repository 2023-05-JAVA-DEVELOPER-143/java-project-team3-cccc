package test;

import cart.CartDao;

public class CartDaoTestMain {  
	
	public static void main(String[] args) throws Exception {
		// 상품창에서 갯수 추가 update  테스트 완료
		CartDao cartDao = new CartDao();	
		int a = cartDao.updateByProductNo("dddd", 1, 145);
		System.out.println(a);
		
		
		/*
		//insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, ?,?,?)
		Product product ;
		Cart cart = new Cart(0, "aaa", new Product(0, "컴퓨터", 1500000, null, null), 1);
		int b = cartDao.insert(cart);
		System.out.println(b);
		*/
	}

	

}
