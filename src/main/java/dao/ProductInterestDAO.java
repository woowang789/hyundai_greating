package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.ProductDetailVO;
import vo.ProductVO;

final public class ProductInterestDAO {
	private static ProductDAO instance = new ProductDAO();
	private ProductDAO() {}
	
	public static ProductDAO getInstance() {
		return instance;
	}
	public ProductDetailVO getProductDetail(String prodId) {
		ProductDetailVO vo = new ProductDetailVO();
		String query= "{call get_prod_detail(?,?,?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.registerOutParameter(4, OracleTypes.CURSOR);
			ResultSet igdtRs = (ResultSet) cstmt.getObject(2);
			while(igdtRs.next()) {
				String iconUrl = igdtRs.getString(1);
				System.out.println(iconUrl);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}
	public List<ProductVO> getProductList(String cateId){
		List<ProductVO> list = new ArrayList<>();
		String query = "{call find_prod_by_cate(?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, cateId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String thumbUrl = rs.getString(3);
				String storage = rs.getString(4);
				String subName = rs.getString(5);
				int stock = rs.getInt(6);
				String grts = rs.getString(7);
				int discnt = rs.getInt(8);
				int originPrice =rs.getInt(9);
				int marketPrice = rs.getInt(10);
				System.out.println(id+" "+name);
				
				ProductVO p = new ProductVO();
				p.setId(id);
				p.setThumbImgUrl(thumbUrl);
				p.setName(name);
				p.setSubName(subName);
				p.setStorage(storage);
				p.setOriginPrice(originPrice);
				p.setStock(stock);
				p.setMarketPrice(marketPrice);
				p.setDiscountRate(discnt);
				p.setGrts(grts);
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
}
