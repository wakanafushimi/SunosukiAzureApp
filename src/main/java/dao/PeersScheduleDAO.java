package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.PeersScheduleModel;

public class PeersScheduleDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public PeersScheduleModel getPeersSchedule(String id,PeersScheduleModel peersScheduleModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select sessionId from sessionmember where memberId=? ;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1, id);
        	ResultSet rs=stmt.executeQuery();
        	
        	List<String> peersSchedulesessionidList=peersScheduleModel.getPeersSchedulesessionidList();
        	while(rs.next()) {
        		peersSchedulesessionidList.add(rs.getString("sessionId"));
        	}
        	peersScheduleModel.setPeersSchedulesessionidList(peersSchedulesessionidList);
        	
        	
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("PeersScheduleDAOのエラー");
			System.out.println("エラー1"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return peersScheduleModel;	
	}
}
