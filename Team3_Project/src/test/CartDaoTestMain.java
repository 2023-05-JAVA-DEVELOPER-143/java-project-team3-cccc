package test;

import java.util.List;

import cart.Cart;
import cart.CartDao;
import product.Product;

public class CartDaoTestMain {  
	
	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();//  Dao  객체 생성
		
		// userid cart 내의 제품 존재여부 countByProductNo (Test완료)
		
		int a = cartDao.countByProductNo( "dddd",1 );
		System.out.println(a);
		
		// insert(Test완료) 
		Product product ;
		Cart cart = new Cart(0, "dddd", new Product(8, "소파", 900000, null, "돌소파"), 2);
		int c = cartDao.insert(cart);
		System.out.println(c);
		
		
		
		// 상품창에서 갯수 추가 updateByProductNo (Test 완료)
			
		int b = cartDao.updateByProductNo("dddd", 1, 145);
		System.out.println(b);
		

		b  = cartDao.updateProduct1up("aaa",1);
		

		//본인 카트에서 갯수 추가 update(아직)

		
		
		//cart List-find findByUserId(Test완료)
		List listA =cartDao.findByUserId("aaa");
		System.out.println(listA);
		
		//cart PK delete   deleteByCartNo(Test완료)
		System.out.println(cartDao.deleteByCartNo(34));
		
		//cart userId delete(Test완료)
		System.out.println(cartDao.deleteByUserId("5124"));

	}
	

	

}
