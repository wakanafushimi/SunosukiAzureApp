package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginModel;
import model.ScheduleModel;

public class ScheduleDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public ScheduleModel getYoursessionList(LoginModel loginModel,ScheduleModel scheduleModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
	        
	        //自分が参加するsessionのsessionidをsessionArrayに入れる
        	String sql = "select sessionId from sessionmember where memberId = ?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1, loginModel.getId());
	        ResultSet rs=stmt.executeQuery();
	        
	        List<String> yoursessionList=scheduleModel.getYoursessionList();
	        
	        while(rs.next()) {
	        	yoursessionList.add(rs.getString("sessionId"));
//	        	System.out.println(rs.getString("sessionId")); //チェック用
	        }
	        
	        scheduleModel.setYoursessionList(yoursessionList);
//	        System.out.println(yoursessionList.size());	//チェック用
	        
	        //合致したsessionのメンバーをArrayListに入れる
	        
	        List<List<String>> yoursessionmemberList=scheduleModel.getYoursessionmemberList();
	        
	        for(int i=0;i<yoursessionList.size();i++) {
	        	String sql2="select memberId from sessionmember where sessionId = ?;";
	        	PreparedStatement stmt2 = conn.prepareStatement(sql2);
	        	stmt2.setString(1,yoursessionList.get(i));
	        	ResultSet rs2=stmt2.executeQuery();
	        	
	        	List<String> yoursessionmember=new ArrayList<>();
	        	yoursessionmember.add(yoursessionList.get(i));
	        	
	        	while(rs2.next()) {
		        	yoursessionmember.add(rs2.getString("memberId"));
		        }
	        	
	        	yoursessionmemberList.add(yoursessionmember);
	        }
	        scheduleModel.setYoursessionmemberList(yoursessionmemberList);
	        
	        
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("ScheduleDAOのエラー");
			System.out.println("エラー1"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return scheduleModel;		
	}
}
