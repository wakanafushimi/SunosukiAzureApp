package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.PeersModel;

public class PeersDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public List<String[]> getPeers() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		List<String[]> peers=new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from userdetail;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery();
	               
	        while(rs.next()) {
	        	String[] peer=new String[10];		        
		        int columnCount=rs.getMetaData().getColumnCount();	
		        
		        for(int i=1;i<=columnCount;i++) {
		        	peer[i-1]=rs.getString(i);
		        }
		        
		        peers.add(peer);
		     
	         }
	        
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー1"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return peers;
		
		
	}
	
	public PeersModel getPeersTrick_a() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		PeersModel peersModel=new PeersModel();
		List<String[]> list=peersModel.getList();
		Set<String> set=peersModel.getSet();		
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from trick_a;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery();
	               
	        while(rs.next()) {
	        	String[] trick_aArray=new String[2];		        
		        int columnCount=rs.getMetaData().getColumnCount();	
		        
		        for(int i=1;i<=columnCount;i++) {
		        	trick_aArray[i-1]=rs.getString(i);
		        }
		        
		        list.add(trick_aArray);
		        set.add(trick_aArray[0]);
	         }
	        
	    }catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー2"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return peersModel;
		
	}
	
	public List<String[]> getPeersTrick_b() {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		List<String[]> peersTrick_b=new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from trick_b;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
	        ResultSet rs=stmt.executeQuery();
	               
	        while(rs.next()) {
	        	String[] trick_bArray=new String[2];		        
		        int columnCount=rs.getMetaData().getColumnCount();	
		        
		        for(int i=1;i<=columnCount;i++) {
		        	trick_bArray[i-1]=rs.getString(i);
		        }
		        
		        peersTrick_b.add(trick_bArray);
		     
	         }
	        
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー3"+e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		return peersTrick_b;
		
		
	}
}
