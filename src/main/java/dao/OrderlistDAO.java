package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.OrderlistVO;

public class OrderlistDAO {
	private OrderlistDAO() {
	}

	private static OrderlistDAO instance = new OrderlistDAO();
	
	public static OrderlistDAO getInstance() {
		return instance;
	}
	
	public List<OrderlistVO> getOrderlist(String test2){
		List<OrderlistVO> list = new ArrayList<>();
		String query = "{call test2(?,?)}";
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, test2);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				String ordertime = rs.getString(1);
				String prodname = rs.getString(2);
				String thumbImgUrl = rs.getString(3);
				String prodoptname = rs.getString(4);
				int originPrice =rs.getInt(5);
				int orderquantity = rs.getInt(6);
				
				System.out.println(ordertime);
				System.out.println(prodname);
				
				String dateStr = (ordertime);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = df.parse(dateStr);
				
				OrderlistVO p = new OrderlistVO();
				p.setOrdertime(ordertime);
				p.setProdname(prodname);
				p.setThumbImgUrl(thumbImgUrl);
				p.setProdoptName(prodoptname);
				p.setOriginPrice(originPrice);
				p.setOrderquantity(orderquantity);
				list.add(p);
			}
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
}
