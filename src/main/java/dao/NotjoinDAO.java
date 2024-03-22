package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.LoginModel;

public class NotjoinDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public void deleteMember(String sessionId,LoginModel loginModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "delete from sessionmember where sessionid=? and memberid=?;";
        	PreparedStatement stmt=conn.prepareStatement(sql);
        	stmt.setString(1,sessionId);
        	stmt.setString(2,loginModel.getId());
        	stmt.executeUpdate();
        	
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
	}
}
