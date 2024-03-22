package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.TrickModel;

public class TrickDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public void setTrick_a(LoginModel loginModel,String trick_a) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(false);
	    
	        String sqlCheck="select * from trick_a where id=? and trick=?;";
	        try (PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck)){
	        	stmtCheck.setString(1,loginModel.getId());
	        	stmtCheck.setString(2,trick_a);
 	          	conn.commit();
 	          	ResultSet rs=stmtCheck.executeQuery();
 	          
 	          	if(!rs.next()) {
	 	          	String sql = "insert into trick_a values (?,?);";
	 		        try (PreparedStatement stmt = conn.prepareStatement(sql)){
	 		        	stmt.setString(1,loginModel.getId());
	 		        	stmt.setString(2,trick_a);
	 		        	stmt.executeUpdate();
	 	 	          	conn.commit();
	 	 	        	
	 		        }catch(SQLException e){
	 		        	e.printStackTrace();
	 		        	System.out.println("エラー１"+e.getMessage());
	 		        	conn.rollback();
	 		        }
 	          	}
	        }catch(SQLException e){
	        	e.printStackTrace();
	        	System.out.println("エラー１"+e.getMessage());
	        	conn.rollback();
	        }
	        
	       
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー２"+e.getMessage());
		}		
	}
	
	public void setTrick_b(LoginModel loginModel,String trick_b) {
	
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(false);
	    
	        String sqlCheck="select * from trick_b where id=? and trick=?;";
	        try (PreparedStatement stmtCheck = conn.prepareStatement(sqlCheck)){
	        	stmtCheck.setString(1,loginModel.getId());
	        	stmtCheck.setString(2,trick_b);
 	          	conn.commit();
 	          	ResultSet rs=stmtCheck.executeQuery();
 	          
 	          	if(!rs.next()) {
			        String sql = "insert into trick_b values (?,?);";
			        try (PreparedStatement stmt = conn.prepareStatement(sql)){
			        	stmt.setString(1,loginModel.getId());
			        	stmt.setString(2,trick_b);
			        	stmt.executeUpdate();
		 	          	conn.commit();
		 	
		 	        	
			        }catch(SQLException e){
			        	e.printStackTrace();
			        	System.out.println("エラー3"+e.getMessage());
			        	conn.rollback();
			        }
		 	    }
 	          	
 	        }catch(SQLException e) {
 				e.printStackTrace();
 			}	
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー4"+e.getMessage());
		}		
	}
	
	public TrickModel getTrickModel(LoginModel loginModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		TrickModel trickModel=new TrickModel();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from trick_a where id = ?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,loginModel.getId());
	        ResultSet rs=stmt.executeQuery();
       
	        while(rs.next()) {	        
	        String trick_a=rs.getString("trick");
	        trickModel.setintoTrick_a(trick_a);
	        }       
	      
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー3"+e.getMessage());
		}
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from trick_b where id = ?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,loginModel.getId());
	        ResultSet rs=stmt.executeQuery();
	        
	        while(rs.next()) {	        
	        String trick_b=rs.getString("trick");
	        trickModel.setintoTrick_b(trick_b);
	        }       
	      
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー5"+e.getMessage());
		}
		
		return trickModel;
	
	}
	
	public void DeleteTrick_a(String deleteValuea,LoginModel loginModel) {
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
			
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "delete from trick_a where id=? and trick=?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,loginModel.getId());
        	stmt.setString(2,deleteValuea);
	        stmt.executeUpdate();
      
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー3"+e.getMessage());
		}
		
		
	}
	
public void DeleteTrick_b(String deleteValueb,LoginModel loginModel) {
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
			
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "delete from trick_b where id=? and trick=?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,loginModel.getId());
        	stmt.setString(2,deleteValueb);
	        stmt.executeUpdate();
      
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー3"+e.getMessage());
		}
		
		
	}

}
