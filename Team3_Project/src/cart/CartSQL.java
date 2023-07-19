package cart;

public class CartSQL {

// insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, 'guard1',1,2);
	public static final String CART_INSERT 
		= "insert into cart(cart_no,userId,p_no,cart_qty) values(cart_cart_no_seq.nextval, ?,?,?)";
	
//select * from cart c join product p on c.p_no=p.p_no where userId='guard1';	
	public static final String CART_FIND_ALL_PRODUCT_BY_USERID 
		= "select * from cart c join product p on c.p_no=p.p_no where userId=?";
	
//select count(*) as p_count from cart where userId ='guard1'and p_no =1;	
	public static final String CART_FIND_PRODUCT_USERID 
		= "select * from cart c join product p on c.p_no=p.p_no where userId=? and p_no=?";
	
//update cart set cart_qty=cart_qty+1 where userId = 'guard1' and p_no=1;
	public static final String CART_PRODUCT_1UP 
		= "update cart set cart_qty=cart_qty+1 where userId = ? and p_no=?";
	
//update cart set cart_qty=3 where userId = 'guard1' and p_no=1;
	public static final String CART_PRODUCT_UP_QTYSET 
		= "update cart set cart_qty=3 where userId =? and p_no=?";
	
//delete from cart where cart_no=1;	
	public static final String CART_DELETE_BY_NO 
		= "delete from cart where cart_no=?";
	
//delete from cart where userId='guard1';
	public static final String CART_DELETE_BY_USERID 
		= "delete from cart where userId=?";
}
