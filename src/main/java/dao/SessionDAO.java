package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.SessionModel;

public class SessionDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public void setSession(SessionModel sessionModel,LoginModel loginModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
	        
	        //createsessionの入力値をsessionテーブルにinsert
	        //このsqlで、dateがnullなら更新されない
        	String sql = "insert into session values (null,?,?,?,?);";
        	PreparedStatement stmt = conn.prepareStatement(sql);
//        	System.out.println(sessionModel.getDate()+sessionModel.getLocation()+sessionModel.getMessage());
        	stmt.setString(1,loginModel.getId());
        	stmt.setString(2,sessionModel.getDate());
        	stmt.setString(3,sessionModel.getLocation());
        	stmt.setString(4,sessionModel.getMessage());
        	stmt.executeUpdate();
        	
        	//作ったsessionのsessionIdを取得
        	int sessionId=0;
        	String sql1="select max(sessionId) as maxsessionId from session;";
        	PreparedStatement stmt1 = conn.prepareStatement(sql1);
        	ResultSet rs=stmt1.executeQuery();
        	while(rs.next()) {
        		sessionId=rs.getInt("maxsessionId");
        	}
        	
        	//メンバーとして作成者も追加
        	String sql2="insert into sessionmember values (?,?);";
        	PreparedStatement stmt2=conn.prepareStatement(sql2);
        	stmt2.setInt(1,sessionId);
        	stmt2.setString(2,loginModel.getId());
        	stmt2.executeUpdate();
        	
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SessionDAOのエラー");
			System.out.println(e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
	}
}
