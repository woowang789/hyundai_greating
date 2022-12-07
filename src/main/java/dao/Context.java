package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface Context {
    public void act(CallableStatement cstmt)  throws SQLException;
}