package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import vo.UserVO;

final public class UserDAO {
	private static UserDAO dao = new UserDAO();
	private UserDAO() {
	}
	public static UserDAO getInstance() {
		return dao;
	}
	
	public UserVO getUserById(String id) {
		String query = "{call find_user_by_id(?,?)}";
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, id);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			cstmt.execute();
				
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			UserVO vo = new  UserVO();
			while(rs.next()) {
				String uid = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				
				if(name == null) return null;
				vo.setId(uid);
				vo.setName(name);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
