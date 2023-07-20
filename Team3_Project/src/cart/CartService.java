package cart;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception{
		this.cartDao = new CartDao();
	}
	
	/*
	 * 카트추가 or 수정
	 */
	
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
	public int cartDeleteByCartNo(int cart_no) throws Exception {
		return cartDao.deleteByCartNo(cart_no);
	}
	
	/*
	 * 카트 모두 삭제
	 */
	public int cartDeleteByUserId(String userId) throws Exception  {
		return cartDao.deleteByUserId(userId);
	}
}
