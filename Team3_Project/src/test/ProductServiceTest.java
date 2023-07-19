package test;    

import product.ProductService;

public class ProductServiceTest {

	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductService();
		productService.productList();
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(2));
		

		
	}

}
