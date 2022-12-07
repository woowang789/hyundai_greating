package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.OracleTypes;
import util.DBConnection;
import vo.CommentVO;

final public class CommentDAO {
	private CommentDAO() {}
	
	private static CommentDAO commentDao = new CommentDAO();
	
	public static CommentDAO getInstance() {
		return commentDao;
	}
	
	public void insertComment(
			String userId, int prodId, int optnId, 
			Date orderDate, String title,String text) {
		String query = "{call PKG_CMT.p_cmt_insert(?,?,?,?,?,?)}";
		try (	Connection con = DBConnection.getConn(); 
				CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, title);
			cstmt.setString(2, text);
			cstmt.setInt(3, optnId);
			cstmt.setInt(4, prodId);
			cstmt.setString(5, userId);
			cstmt.setDate(6, orderDate);

			cstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<CommentVO> getCommentList(String prodId){
		List<CommentVO> list = new ArrayList<>();
		String query = "{ call PKG_CMT.p_cmt(?,?) }";
		try (	Connection con = DBConnection.getConn(); 
				CallableStatement cstmt = con.prepareCall(query);) {
			cstmt.setString(1, prodId);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			while(rs.next()) {
				String title = rs.getString(1);
				String text = rs.getString(2);
				Date cmtDate = rs.getDate(3);
				String userAId = rs.getString(4);
				String userId = rs.getString(5);
				int optnId = rs.getInt(6);
				String optnName = rs.getString(7);
				
				CommentVO vo = new CommentVO();
				vo.setTitle(title);
				vo.setText(text);
				vo.setCommentDate(cmtDate);
				vo.setUserIdWithMask(userAId);
				vo.setUserId(userId);
				vo.setOptnId(optnId);
				vo.setOptnName(optnName);
				
				list.add(vo);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
