package product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import common.DataSource;

public class ProductDao {
	private DataSource dataSource;

	public ProductDao() throws Exception {
		this.dataSource = new DataSource();

	}
	
	public int insert(Product newProduct) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_INSERT);
		pstmt.setString(1, newProduct.getP_name());
		pstmt.setInt(2, newProduct.getP_price());
		pstmt.setString(3, newProduct.getP_image());
		pstmt.setString(4, newProduct.getP_desc());
		int rowCount = pstmt.executeUpdate();
		pstmt.close(); 
		dataSource.close(con);

		return rowCount;
	}
	
/*	public int update(Product updateProduct) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(ProductSQL.PRODUCT_UPDATE);
//update product set  p_name = ?, p_price = ?, p_image = ?, p_desc = ? where p_no = ?
		pstmt.setString(1, Pro.getName());
		pstmt.setString(2, updateAddress.getPhone());
		pstmt.setString(3, updateAddress.getAddress());
		pstmt.setInt(4, updateAddress.getNo());

		int rowCount = pstmt.executeUpdate();
		pstmt.close();
		dataSource.close(con);
		return rowCount;
	}*/
	
	
	
	
	
	
	
}
