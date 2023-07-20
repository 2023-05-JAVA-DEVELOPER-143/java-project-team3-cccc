package test;

import cart.Cart;
import cart.CartDao;
import product.Product;

public class CartDaoTestMain {  
	
	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();//  Dao  객체 생성
		
		// userid cart 내의 제품 존재여부
		
		int a = cartDao.countByProductNo( "dddd",1 );
		System.out.println(a);
		
		//insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, ?,?,?)
		Product product ;
		Cart cart = new Cart(0, "aaa", new Product(1, "컴퓨터", 800000, null, "23년도 최신형 컴퓨터"), 2);
		int c = cartDao.insert(cart);
		System.out.println(c);
		
		// 상품창에서 갯수 추가 update  테스트 완료
			
		int b = cartDao.updateByProductNo("dddd", 1, 145);
		System.out.println(b);
		
		cart = new Cart(17,"aaaa", new Product(1, "컴퓨터", 800000, null, "23년도 최신형 컴퓨터"), 1);
		b  = cartDao.updateProduct1up(cart);
		
		

		
	}

	

}
