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
import vo.OrderReviewVO;

final public class OrderReviewDAO {
	private static OrderReviewDAO instance = new OrderReviewDAO();

	private OrderReviewDAO() {
	}

	public static OrderReviewDAO getInstance() {
		return instance;
	}

	public List<OrderReviewVO> getOrderReviewList(int pProdId) {
		List<OrderReviewVO> orList = new ArrayList<>();
		String query = "{call p_cmt(?,?)}";
		try (Connection con = DBConnection.getConn(); CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setInt(1, pProdId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();

			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while (rs.next()) {
				String commentTitle = rs.getString(1);
				String commentText = rs.getString(2);
				String orderReviewDate = rs.getString(3);
				String userId = rs.getString(4);

				Date orDate = DateParser.strToDate(orderReviewDate);
				// String -> Date 형변환
		

				System.out.println("Prod_ID = " + pProdId);
				System.out.println("User_ID = " + userId);

				OrderReviewVO or = new OrderReviewVO();
				or.setCommentTitle(commentTitle);
				or.setCommentText(commentText);
				or.setOrderReviewDate(orDate);
				or.setUserId(userId);
				orList.add(or);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orList;
	}

}