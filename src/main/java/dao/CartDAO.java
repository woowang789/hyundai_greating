package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.CartProductVO;

final public class CartDAO {

	private CartDAO() {}
	
	private static CartDAO instance = new CartDAO();
	
	public static CartDAO getInstance() {
		return instance;
	}
	
	public List<CartProductVO> getCartProductList(String userId){
		List<CartProductVO> list = new ArrayList<>();
		String query= "{call p_cart(?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, userId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				String prodId = rs.getString(1);
				String prodOptnId = rs.getString(2);
				String prodName = rs.getString(3);
				String prodOptnName = rs.getString(4);
				String thumbUrl = rs.getString(5);
				int originPrice =rs.getInt(6);
				int marketPrice = rs.getInt(7);
				int discntRate = rs.getInt(8);
				int qty = rs.getInt(9);
				int stock = rs.getInt(10);
				
				CartProductVO vo = new CartProductVO();
				vo.setProdId(prodId);
				vo.setProdOptnId(prodOptnId);
				vo.setProdName(prodName);
				vo.setProdOptnName(prodOptnName);
				vo.setThumbUrl(thumbUrl);
				vo.setOriginPrice(originPrice);
				vo.setMarketPrice(marketPrice * qty);
				vo.setDiscntRate(discntRate);
				vo.setQty(qty);
				vo.setStock(stock);
				
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public void updateCartProduct(String userId, int optnId,int stock) {
		String sql = "{call p_cart_update(?,?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(sql);
		){
			cstmt.setString(1,userId);
			cstmt.setInt(2, optnId);
			cstmt.setInt(3, stock);
			
			cstmt.executeUpdate();
			System.out.println("업데이트 완료");
			
		}catch (SQLException e) {
			System.out.println("업데이트 에러 발생");
			e.printStackTrace();
		}
	}
	
	
}
