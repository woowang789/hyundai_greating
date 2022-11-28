package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import util.DateParser;
import vo.OrderReviewInsertVO;

final public class OrderReviewInsertDAO {
	private static OrderReviewInsertDAO instance = new OrderReviewInsertDAO();

	private OrderReviewInsertDAO() {
	}

	public static OrderReviewInsertDAO getInstance() {
		return instance;
	}

	public List<OrderReviewInsertVO> getOrderReviewInsertList(String pUserId, int pProdId, int pProdOpId, String pOrderDate) {
		List<OrderReviewInsertVO> oriList = new ArrayList<>();
		String query = "{call p_cmt_insert(?,?,?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, pUserId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				String commentTitle = rs.getString(1);
				String commentText = rs.getString(2);
				String orderReviewDate = rs.getString(3);
				int prodOpId = rs.getInt(4);
				int prodId = rs.getInt(5);
				String userId = rs.getString(6);
				String orderDate = rs.getString(7);

				Date orDate = DateParser.strToDate(orderReviewDate);
				Date oDate = DateParser.strToDate(orderDate);

				System.out.println(pUserId + " " + pProdId + "" + pProdOpId + "" + pOrderDate);

				OrderReviewInsertVO ori = new OrderReviewInsertVO();
				ori.setCommentTitle(commentTitle);
				ori.setCommentText(commentText);
				ori.setOrderReviewDate(orDate);
				ori.setProdOpId(prodOpId);
				ori.setProdId(prodId);
				ori.setUserId(userId);
				ori.setOrderDate(oDate);
				oriList.add(ori);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return oriList;
	}

}