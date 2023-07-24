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

// 상품 번호로 이름, 가격, 세부내역 검색
public static final String Product_SELECT_BY_NO_Name = "select p_name from product where p_no = ?";    
public static final String Product_SELECT_BY_NO_Price = "select p_price from product where p_no = ?";    
public static final String Product_SELECT_BY_NO_desc = "select p_desc from product where p_no = ?";    
public static final String Product_SELECT_BY_NO_Image = "select p_image from product where p_no = ?";    

// 상품 이름으로 상품이름 검색 기능
public static final String Product_SELECT_BY_Name_Name = "select p_name from product where p_name like '%'||?||'%'";    
public static final String Product_SELECT_BY_Name_No = "select p_no from product where p_name like '%'||?||'%'";    

}
