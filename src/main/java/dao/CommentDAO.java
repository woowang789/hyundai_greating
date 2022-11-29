package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

import util.DBConnection;

final public class CommentDAO {
	private CommentDAO() {}
	
	private static CommentDAO commentDao = new CommentDAO();
	
	public static CommentDAO getInstance() {
		return commentDao;
	}
	
	public void insertComment(
			String userId, int prodId, int optnId, 
			Date orderDate, String title,String text) {
		String query = "{call p_cmt_insert1(?,?,?,?,?,?)}";
		try (	Connection con = DBConnection.getConn(); 
				CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, title);
			cstmt.setString(2, text);
			cstmt.setInt(3, optnId);
			cstmt.setInt(4, prodId);
			cstmt.setString(5, userId);
			cstmt.setDate(6, orderDate);

			cstmt.executeUpdate();
			System.out.println("리뷰 insert ");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
