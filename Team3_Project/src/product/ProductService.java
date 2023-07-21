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
	
	public String productName(int p_no) throws Exception{
		Product product =  productDao.SelectByPK_Name(p_no);
		 return product.getP_name();
	}
	public int productPrice(int p_no) throws Exception{
		Product product= productDao.SelectByPK_Price(p_no);
		 return product.getP_price();
	}
	public String productDesc(int p_no) throws Exception{
		  Product product= productDao.SelectByPK_Desc(p_no);
		 return product.getP_desc();
	}
	
	
	
}
