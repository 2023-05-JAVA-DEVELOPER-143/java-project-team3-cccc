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
		Cart cart = new Cart(0, "aaa", new Product(10, "휴지", 8000, null, "좋은휴지"), 30);
		int c = cartDao.insert(cart);
		System.out.println(c);
		
	
		// 상품창 상세보기에서 갯수 추가 updateByProductNo (Test 완료)
			
		int b = cartDao.updateByProductNo("dddd", 8, 13);
		System.out.println(b);
	

		//카테고리 상품창에서 장바구니 눌러서 개수 1개 추가 update(Test완료)

		int d  = cartDao.updateProduct1up("aaa",1);
		System.out.println(d);
	
	
		//cart List-find findByUserId(Test완료)
		List listA =cartDao.findByUserId("aaa");
		System.out.println(listA);
	
		//cart PK delete   deleteByCartNo(Test완료)
		System.out.println(cartDao.deleteByCartNo(34));
		
		//cart userId delete(Test완료)
		System.out.println(cartDao.deleteByUserId("5124"));
		
		
		//findByUserIdPNo  user_id와 p_no로 Cart데이터찾기(Test완료)
		System.out.println(cartDao.findByUserIdPNo("aaa", 10));
		
		//car_no로 Cart 찾기(Test완료)
		System.out.println(cartDao.findByCartNo(40));
		
	}
	

	

}
