package test;    


import product.ProductDao;
import product.ProductService;

public class ProductServiceTest {

	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductService();
		/*productService.productList();
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(2));
		System.out.println(productService.productDesc(2));
		System.out.println(productService.productName(2));
		System.out.println(productService.productPrice(2));*/
		// 상품 검색
		System.out.println(productService.productFindName("바지"));
		//System.out.println((productService.productFindNameNo("컴퓨터")));
		//System.out.println("---");
		
		//ProductDao dao = new ProductDao();
		//System.out.println(dao.SelectByname_No("바지"));
		
	}

}
