package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import util.DBConnection;

public class JdbcContent {
	
	public static void template(String query,Context context){
		try (
				Connection con = DBConnection.getConn();
				CallableStatement cstmt = con.prepareCall(query);
		){
			context.act(cstmt);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	    
	}
}

