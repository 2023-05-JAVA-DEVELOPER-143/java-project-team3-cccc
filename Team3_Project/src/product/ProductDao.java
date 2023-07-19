package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DataSource;

public class ProductDao {  
	private DataSource dataSource;

	public ProductDao() throws Exception {
		this.dataSource = new DataSource();

	}
	
  
	/*
	 * selelctByPK : 상품번호로 검색
	 */
	public Product SelectByPK(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_NO);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product=
					new Product(
							rs.getInt("p_no"),
							rs.getString("p_name"), 
							rs.getInt("p_price"), 
							rs.getString("p_image"), 
							rs.getString("p_desc"));
	
		}
		return product;
	}
	/*
	 * selectAll : 상품전체검색
	 */
	public List<Product> selectAll() throws Exception{
		List<Product> productList=new ArrayList<Product>();
		
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_ALL);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()) {
			Product product=new Product(
								rs.getInt("p_no"),
								rs.getString("p_name"), 
								rs.getInt("p_price"), 
								rs.getString("p_image"), 
								rs.getString("p_desc"));
			productList.add(product);
		}
		return productList;
	}
	
	
	
}
