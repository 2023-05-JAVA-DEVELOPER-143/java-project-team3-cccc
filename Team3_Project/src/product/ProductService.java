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
	
}
