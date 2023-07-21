package product;

import java.util.List;

public class ProductService {
	private ProductDao productDao;
	public ProductService() throws Exception{
		productDao=new ProductDao();
	}
	/*
	 * 전체상품보기
	 */
	public List<Product> productList() throws Exception{
			return productDao.selectAll();
	}
	/*
	 * 상품상세보기
	 */
	public Product productDetail(int p_no) throws Exception{
		return productDao.SelectByPK(p_no);
	}
	
	// 상품이름으로 상품이름 찾기
	public String productFindName(String p_name) throws Exception{
		 Product product =  productDao.SelectByname_Name(p_name);
		 if (product.getP_name() == null) {
			System.out.println("없는 상품");
		}
		 return product.getP_name();
	}
	
	// 상품번호로 이름 찾기 
	public String productName(int p_no) throws Exception{
		Product product =  productDao.SelectByPK_Name(p_no);
		 return product.getP_name();
	}
	
	// 상품번호로 가격 찾기 
	public int productPrice(int p_no) throws Exception{
		Product product= productDao.SelectByPK_Price(p_no);
		 return product.getP_price();
	}
	// 상품번호로 세부내역 찾기 
	public String productDesc(int p_no) throws Exception{
		  Product product= productDao.SelectByPK_Desc(p_no);
		 return product.getP_desc();
	}
	
	
	
}
