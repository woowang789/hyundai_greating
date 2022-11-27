package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.ProductInterestVO;

final public class ProductInterestDAO {
	private static ProductInterestDAO instance = new ProductInterestDAO();
	private ProductInterestDAO() {}
	
	public static ProductInterestDAO getInstance() {
		return instance;
	}

	public List<ProductInterestVO> getProductInterestList(String pUserId){
		List<ProductInterestVO> pilist = new ArrayList<>();
		String query = "{call P_PROD_INTEREST(?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, pUserId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				int prodId = rs.getInt(1);
				String prodName = rs.getString(2);
				String subName = rs.getString(3);
				int discntRate = rs.getInt(4);
				int discntPrice = rs.getInt(5);
				int originPrice =rs.getInt(6);
				String thnlImgURL = rs.getString(7);
				System.out.println(prodId+" "+prodName);
				
				ProductInterestVO pi = new ProductInterestVO();
				pi.setProdId(prodId);
				pi.setProdName(prodName);
				pi.setSubName(subName);
				pi.setDiscntPrice(discntRate);
				pi.setDiscntPrice(discntPrice);
				pi.setOriginPrice(originPrice);
				pi.setThnlImgURL(thnlImgURL);
				pilist.add(pi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pilist;
	}
	
	
	
	
}
