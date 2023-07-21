package test;    


import product.ProductService;

public class ProductServiceTest {

	public static void main(String[] args) throws Exception {
		
		ProductService productService = new ProductService();
		productService.productList();
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(2));
		System.out.println(productService.productDesc(2));
		System.out.println(productService.productName(2));
		System.out.println(productService.productPrice(2));
		System.out.println(productService.productFindName("바지"));
	
		
		
		
	}

}
