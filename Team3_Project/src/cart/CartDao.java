package cart;

import java.util.List;

import common.DataSource;

public class CartDao {
	
	private DataSource dataSource;
	
	public CartDao() throws Exception{
		this.dataSource = new DataSource();
	}
	
	// userid cart 내의 제품 존재여부
	public int countByProductNo(String userid, int p_no) {
		return 0;
	}
	
	//cart insert
	public int insert(Cart cart)  {
		return 0;
	}
	//상품창에서 갯수 추가 update
	public int updateByProductNo(String userId, int p_no, int cart_qty)  {
		return 0;
	}
	//본인 카트에서 갯수 추가 update
	public int updateProduct1up(int cart_no, int cart_qty)  {
		return 0;
	}
	//cart List-find
	public List<Cart> findByUserId(String userId)  {
		return null;
	}
	//cart PK delete
	public int deleteByCartNo(int cart_no)  {
		return 0;
	}
	//cart userId delete
	public int deleteByUserId(String userId)  {
		return 0;
	}
	//Cart no로 Cart search
	public Cart findByCartNo(int Cart_no) {
	return null;
	}
	
	
}
