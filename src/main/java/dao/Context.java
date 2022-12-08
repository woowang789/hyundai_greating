package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 * 
 * @author 왕종휘
 */

public interface Context {
    public void act(CallableStatement cstmt)  throws SQLException;
}