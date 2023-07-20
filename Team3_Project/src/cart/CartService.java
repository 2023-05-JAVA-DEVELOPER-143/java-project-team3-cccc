package cart;

public class CartService {
	private CartDao cartdao;
	
	public CartService() throws Exception{
		cartdao = new CartDao();
	}
	/*
	 * 카트추가 or 수정
	 */
	public void addCart(Cart cart) throws Exception{
		cartdao.countByProductNo(cart.getUserId(), cart.getProduct().getP_no());
		
	}
	
	/*
	 * 카트수량변경수정
	 */
	
	/*
	 * 카트보기
	 */
	
	/*
	 * 카트아이템1개보기
	 */
	
	/*
	 * 카트아이템1개삭제
	 */
	
	/*
	 * 카트삭제
	 */
	
}
