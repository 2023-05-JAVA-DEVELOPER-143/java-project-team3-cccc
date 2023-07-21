package product;  
/*
 ------- -------- ------------- 
P_NO    NOT NULL NUMBER(10)    
P_NAME  NOT NULL VARCHAR2(50)  
P_PRICE NOT NULL NUMBER(10)    
P_IMAGE NOT NULL VARCHAR2(100) 
P_DESC           VARCHAR2(200) 
 */
public class ProductSQL {
	
	
   public ProductSQL() {

	}
   
public static final String PRODUCT_INSERT= "insert into product(p_no,p_name,p_price,p_image,p_desc) values(product_p_no_SEQ.nextval, ?, ?, ?,?)";   
public static final String PRODUCT_UPDATE= "update product set  p_name = ?, p_price = ?, p_image = ?, p_desc = ? where p_no = ?";    
public static final String PRODUCT_DELETE = "delete from product where p_no = ?";    
public static final String Product_SELECT_BY_NO= "select p_no, p_name, p_price, p_image, p_desc from product where p_no = ?";    
public static final String Product_SELECT_ALL ="select p_no, p_name, p_price, p_image, p_desc from product";
public static final String Product_SELECT_BY_NO_Pn= "select p_name,from product where p_no = ?";    
}
