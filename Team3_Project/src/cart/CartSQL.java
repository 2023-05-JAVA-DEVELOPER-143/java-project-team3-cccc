package cart;

public class CartSQL {
// select count(*) as p_count from cart c join userinfo u on c.userid=u.userid where u.userid='guard1' and c.p_no=1;
	public static final String CART_COUNT_PRODUCT_BY_USERID =
			"select count(*) as p_count from cart c join userinfo u on c.userid=u.userid where u.userid=? and c.p_no=?";

// insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, 'guard1',1,2);
	public static final String CART_INSERT 
		= "insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, ?,?,?)";
	
	public static final String CART_PRODUCT_UP_QTYSET 
	= "update cart set cart_qty=? where userId =? and p_no=?";
	
	public static final String CART_PRODUCT_1UP 
	= "update cart set cart_qty=cart_qty+1 where userId=? and p_no=?";
	
	
//select * from cart c join product p on c.p_no=p.p_no where userId='guard1';	
	public static final String CART_FIND_ALL_PRODUCT_BY_USERID 
		= "select * from cart c join product p on c.p_no=p.p_no where userId=?";
	
//select count(*) as p_count from cart where userId ='guard1'and p_no =1;	
	public static final String CART_FIND_PRODUCT_USERID_PRODUCTNO 
		= "select * from cart c "
				+ "join product p on c.p_no=p.p_no "
				+ "join UserInfo u on c.userId = u.userId "
				+ "where c.userId=? and c.p_no=?";
	
//	select * from cart where  cart_no=?"
	public static final String CART_FIND_CART_NO 
	= "select * from  cart c join product p on c.p_no=p.p_no where cart_no=?";

//delete from cart where cart_no=1;	
	public static final String CART_DELETE_BY_NO 
		= "delete from cart where cart_no=?";
	
//delete from cart where userId='guard1';
	public static final String CART_DELETE_BY_USERID 
		= "delete from cart where userId=?";

}