package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.SingleOrderVO;

public class SingleOrderDAO {
	private SingleOrderDAO() {	
	}
	
	private static SingleOrderDAO instance = new SingleOrderDAO();
	
	public static SingleOrderDAO getInstance() {
		return instance;
	}
	public List<SingleOrderVO> getOrderlist(String useridinput, String dateinput) throws ParseException{
		List<SingleOrderVO> list = new ArrayList<>();
		String query = "{call p_single_order(?,?,?)}";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = df.parse(dateinput);
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, useridinput);
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
				System.out.println(prodname);
				
				
				SingleOrderVO p = new SingleOrderVO();
				p.setProdname(prodname);
				p.setProdoptname(prodoptname);
				p.setProdthnlimgurl(prodthnlimgurl);
				p.setQuantity(quantity);
				p.setProdprice(prodprice);
				p.setMarketprice(marketprice);
				p.setDiscntprice(discntprice);
				p.setTotalprodprice(totalprodprice);
				p.setTotaldiscntprice(totaldiscntprice);
				p.setTotalcusprice(totalcusprice);
				p.setStatus(status);
				p.setRecipient(recipient);
				p.setRctel(rctel);
				p.setRcadd(rcadd);
				
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

}
