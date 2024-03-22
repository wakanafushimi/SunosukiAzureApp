package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.ForCoachModel;

public class ForCoachDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public ForCoachModel getCoaches(ForCoachModel forCoachModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select id from trick_a where trick = ?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1, forCoachModel.getTrick());
	        ResultSet rs=stmt.executeQuery();
	        
	        List<String> coachesList=forCoachModel.getCoachesList();
	        
	        while(rs.next()) {
	        	coachesList.add(rs.getString(1));
//	        	System.out.println(rs.getString(1));
	        }
	        
//	        for(String coach:coachesList) {
//	        	System.out.println(coach);
//	        }
	        
	        forCoachModel.setCoachesList(coachesList);
	        System.out.println(coachesList.size());	//チェック用
	        
	        if(coachesList!=null) {
		        String[] coaches=new String[coachesList.size()];
//		        System.out.println(coaches.length); //チェック用
		        
		        int i=0;
		        for(String values:coachesList) {
		        	coaches[i]=values;
		        	System.out.println(coaches[i]);	
		        	i=i+1;
		        }
		        
		        forCoachModel.setCoaches(coaches);
	        }
	        
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー1"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return forCoachModel;		
	}
		
}
