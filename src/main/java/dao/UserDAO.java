package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import oracle.jdbc.internal.OracleTypes;
import util.DBConnection;
import util.SHA256;
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
				String pwd = rs.getString(4);
				
				if(name == null) return null;
				vo.setId(uid);
				vo.setName(name);
				vo.setEncrypPw(pwd);
				vo.setEmail(email);
				return vo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void joinMember(String id, String name, String email, Date birth, String sex, String password) {
		String query = "{call p_newuser(?,?,?,?,?,?)}";
		
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, email);
			cstmt.setTimestamp(4, new Timestamp(birth.getTime())); 
			cstmt.setString(5, sex);
			cstmt.setString(6, SHA256.encodeSha256(password));
			cstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
