package ShoppingMall.Dao;


public class ShoppingMallDaoTestMain {

	public static void main(String[] args) throws Exception {
		
		ShoppingMallDao shopDao=new ShoppingMallDao();
		// int no, String name, String birthday, String phone, String address, String id, String password;	
		System.out.println("1.insert:"+shopDao.insert(new Shop(1, "테스트","1997-08-20", 
				"000-0000", "제주도","holloworld","aaaaa")));
		Shop findShopMember=shopDao.findByPrimaryKey(1);
		findShopMember.setName("change");
		findShopMember.setPhone("xxx-uuuu");
		findShopMember.setAddress("LA");
		System.out.println("2.update:"+shopDao.updateByPrimaryKey(findShopMember));
		System.out.println("3.findByPrimaryKey:"+shopDao.findByPrimaryKey(1));
		System.out.println("4.findAll:"+shopDao.findAll());
	}

}
