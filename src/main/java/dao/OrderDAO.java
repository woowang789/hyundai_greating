package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import util.DateParser;
import vo.OrderProductVO;
import vo.OrderVO;

final public class OrderDAO {
	private OrderDAO() {}
	
	private static OrderDAO instance = new OrderDAO();
	
	public static OrderDAO getInstance() {
		return instance;
	}
	
	public OrderVO getOrder(String userId, Date date) {
		String query = "{call p_single_order(?,?,?)}";
		OrderVO orderVo = new OrderVO();
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, userId);
			cstmt.setTimestamp(2, new Timestamp(date.getTime()));
			cstmt.registerOutParameter(3, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(3);
			while(rs.next()) {
				String prodname = rs.getString(2);
				String prodoptname = rs.getString(3);
				String prodthnlimgurl = rs.getString(4);
				int quantity = rs.getInt(5);
				int prodprice =rs.getInt(6);
				int marketprice = rs.getInt(7);
				int discntprice = rs.getInt(8);
				int totalprodprice = rs.getInt(9);
				int totaldiscntprice = rs.getInt(10);
				int totalcusprice = rs.getInt(11);
				String status = rs.getString(12);
				String recipient = rs.getString(13);
				String rctel = rs.getString(14);
				String rcadd = rs.getString(15);
				
				OrderProductVO prodVO = new OrderProductVO();
				prodVO.setProdName(prodname);
				prodVO.setOptName(prodoptname);
				prodVO.setThumbImgUrl(prodthnlimgurl);
				prodVO.setQty(quantity);
				prodVO.setMarketPrice(marketprice);
				prodVO.setOriginPrice(prodprice*quantity);
				prodVO.setDiscountAmount(discntprice);
				
				orderVo.setStatus(status);
				orderVo.setReceiverName(recipient);
				orderVo.setReceiverTel(rctel);
				orderVo.setReceiverAddr(rcadd);
				
				orderVo.getOrderProds().add(prodVO);

			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return orderVo;
	}
	
	public List<OrderProductVO> getOrderList(String userId){
		List<OrderProductVO> list = new ArrayList<>();
		String query = "{call test2(?,?)}";
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, userId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				String time = rs.getString(1);
				String prodName = rs.getString(2);
				String thumbImgUrl = rs.getString(3);
				String optnName = rs.getString(4);
				int marketPrice = rs.getInt(5);
				int qty = rs.getInt(6);
				
				System.out.println(time);
				System.out.println(prodName);
				
				OrderProductVO vo = new OrderProductVO();
				vo.setOrderDate(DateParser.strToDate(time));
				vo.setProdName(prodName);
				vo.setThumbImgUrl(thumbImgUrl);
				vo.setOptName(optnName);
				vo.setMarketPrice(marketPrice);
				vo.setQty(qty);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
