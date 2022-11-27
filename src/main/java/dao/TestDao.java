package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import util.DBConnection;

public final class TestDao {
	private static TestDao instance = new TestDao();
	private TestDao() {}
	
	public static TestDao getInstance() {
		return instance;
	}
	
	
	public List listMembers() {
		List list = new ArrayList();
		String query = "select * from t1 ";
		try (
			Connection con = DBConnection.getConn();
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){

			while (rs.next()) {
				String id = rs.getString("name");
				System.out.println(id);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}