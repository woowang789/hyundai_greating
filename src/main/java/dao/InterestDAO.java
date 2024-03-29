package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.ProductVO;

/**
 * 
 * @author 최태승
 */

final public class InterestDAO {
	private InterestDAO() {}
	
	private static InterestDAO instance = new InterestDAO();
	
	public static InterestDAO getInstance() {
		return instance;
	}
	
	public boolean exsistInterest(String userId, int prodId) {
		String sql = "{call PKG_INT.P_PROD_INTEREST_IS_EXIST(?,?,?)}";
		int count = 0;
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(sql);
		){
			cstmt.setString(1,userId);
			cstmt.setInt(2, prodId);
			cstmt.registerOutParameter(3, OracleTypes.NUMBER);
			
			cstmt.executeUpdate();
			
			count = cstmt.getInt(3);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return count==1;
	}
	public void toggleInterest(String userId, int prodId) {
		String sql = "{call PKG_INT.P_PROD_INTEREST_TOGGLE(?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(sql);
		){
			cstmt.setString(1,userId);
			cstmt.setInt(2, prodId);
			
			cstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<ProductVO> getInterestProductList(String userId){
		String query = "{call PKG_INT.P_PROD_INTEREST(?,?)}";
		List<ProductVO> list = new ArrayList<>();
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, userId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String subName = rs.getString(3);
				int originPrice = rs.getInt(4);
				int discountAmount = rs.getInt(5);
				int marketPrice = rs.getInt(6);
				String thumUrl = rs.getString(7);
				String storage = rs.getString(8);
				int stock = rs.getInt(9);
				String imgUrl = rs.getString(10);
				
				ProductVO vo = new ProductVO();
				vo.setId(id);
				vo.setThumbImgUrl(thumUrl);
				vo.setName(name);
				vo.setSubName(subName);
				vo.setStorage(storage);
				vo.setStock(stock);
				vo.setOriginPrice(originPrice);
				vo.setDiscountRate(discountAmount);
				vo.setMarketPrice(marketPrice);
				vo.setProdImgUrl(imgUrl);
				
				list.add(vo);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
