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
	
	// 상품 이름으로 상품이름 검색
	public Product SelectByname_Name(String p_name) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_Name_Name);
		pstmt.setString(1, p_name);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product= new Product(rs.getString("p_name"),
								 null
								);		
			} 
		return product;
	}
	
	// 상품 이름으로 상품번호 검색
	public Product SelectByname_No(String p_name) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_Name_No);
		pstmt.setString(1, p_name);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product= new Product(
					rs.getInt("p_no"),null,0,null,null);	
			} 
		return product;
	}

	
	
	// 상품번호로 상품이름 검색
	public Product SelectByPK_Name(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_NO_Name);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product= new Product(rs.getString("p_name"),
								 null
								);		
			} 
		return product;
	}
	// 상품번호로 상품가격 검색
	public Product SelectByPK_Price(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_NO_Price);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product= new Product(rs.getInt("p_price"));		
		} 
		return product;
	}

	// 상품번호로 상품세부정보 검색
	public Product SelectByPK_Desc(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_NO_desc);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product= new Product(null,
								rs.getString("p_desc"));	
		} 
		return product;
	}
	// 상품번호로 상품이미지 
	public Product SelectByPK_Image(int p_no) throws Exception{
		Product product=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(ProductSQL.Product_SELECT_BY_NO_Image);
		pstmt.setInt(1, p_no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			product=new Product(
					0,null,0,rs.getString("p_image"),null);
	
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
