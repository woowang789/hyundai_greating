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
import vo.OrderReviewVO;

final public class OrderReviewDAO {
	private static OrderReviewDAO instance = new OrderReviewDAO();

	private OrderReviewDAO() {
	}

	public static OrderReviewDAO getInstance() {
		return instance;
	}

	public List<OrderReviewVO> getOrderReviewList(String pUserId, int pProdId, int pProdOpId, Date pOrderDate) {
		List<OrderReviewVO> orList = new ArrayList<>();
		String query = "{call p_cmt_insert(?,?,?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, pUserId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				String commentTitle = rs.getString(1);
				String commentText = rs.getString(2);
				Date orderReviewDate = rs.getDate(3);
				int prodOpId = rs.getInt(4);
				int prodId = rs.getInt(5);
				String userId = rs.getString(6);
				Date orderDate = rs.getDate(7);
				

				System.out.println(pUserId + " " + pProdId + "" + pProdOpId + "" + pOrderDate);

				OrderReviewVO or = new OrderReviewVO();
				or.setCommentTitle(commentTitle);
				or.setCommentText(commentText);
				or.setOrderReviewDate(orderReviewDate);
				or.setProdOpId(prodOpId);
				or.setProdId(prodId);
				or.setUserId(userId);
				or.setOrderDate(orderDate);
				orList.add(or);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orList;
	}

}