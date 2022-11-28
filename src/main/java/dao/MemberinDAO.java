package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import util.DBConnection;

public class MemberinDAO {
	private MemberinDAO() {}
	
	private static MemberinDAO instance = new MemberinDAO();
	
	public static MemberinDAO getInstance() {
		return instance;
	}
	
	public void joinMember(String id, String name, String email, String birth, String sex, String password) throws ParseException {
		String query = "{call p_newuser(?,?,?,?,?,?)}";
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(birth);
		
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			cstmt.setString(1, id);
			cstmt.setString(2, name);
			cstmt.setString(3, email);
			cstmt.setTimestamp(4, new Timestamp(date.getTime())); 
			cstmt.setString(5, sex);
			cstmt.setString(6, password);
			cstmt.executeUpdate();
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

