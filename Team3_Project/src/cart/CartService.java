package cart;

import java.util.List;

public class CartService {
	private CartDao cartDao;
	
	public CartService() throws Exception{
		cartDao = new CartDao();
	}	

	/*
	 * 카트추가 or 수정
	 */
	public int addCart(Cart cart) throws Exception{
		String userid = cart.getUserId();
		int p_no = cart.getProduct().getP_no();
		int qty = cart.getCart_qty();
		int count = cartDao.countByProductNo(userid, p_no);
		int rowCount = 0;
		if( count > 0) {
			rowCount = cartDao.updateByProductNo(userid, p_no, qty);
		}else {
			rowCount = cartDao.insert(cart);
		}
		return rowCount;
	}
	
	/*
	 * 카트수량변경수정
	 */
	//상품창에서 갯수 선택 추가 update
	public int updateCartCartQty(String userId, int p_no, int cart_qty)throws Exception {
		return cartDao.updateByProductNo(userId, p_no, cart_qty);
	}
	// 상품리스트에서 장바구니 클릭(1개 추가) update
	public int updateCartBasket(String userId , int p_no)throws Exception {
		return cartDao.updateProduct1up(userId,p_no);
	}
	
	/*
	 * 카트보기
	 */
	public List<Cart> getCartItemByUserId(String sUserId) throws Exception{
		return cartDao.findByUserId(sUserId);
	}
	/*
	 * 카트아이템1개보기
	 */
	public Cart getCartItemByCartNo(int cart_no) throws Exception{
		return cartDao.findByCartNo(cart_no);
	}
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
