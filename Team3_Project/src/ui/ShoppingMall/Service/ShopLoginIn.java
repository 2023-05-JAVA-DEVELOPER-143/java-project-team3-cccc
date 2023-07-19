package ShoppingMall.Service;

import ShoppingMall.Dao.Shop;
import ShoppingMall.Dao.ShoppingMallDao;

public class ShopLoginIn {
	private Shop shop;
	public ShopLoginIn() {
		shop = new Shop();
	}
	
	public void joinMember() throws Exception{
		ShoppingMallDao shopDao= new ShoppingMallDao();
		shopDao.insert
		(new Shop(shop.getNo(), shop.getName(),shop.getBirthday(), 
				shop.getPhone(), shop.getAddress(),shop.getId(),shop.getPassword()));
	}
	
	public void loginMember() {
		shop.getId();
		shop.getPassword();
	}
	
	

}
