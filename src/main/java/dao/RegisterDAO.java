package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.LoginModel;

public class RegisterDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public boolean Register (LoginModel loginModel) {
		boolean flag=false;
		
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }

	    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);

	        String sql = "insert into user value(?,?)";
	        try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
	            pStmt.setString(1, loginModel.getId());
	            pStmt.setString(2, loginModel.getPassword());

	            int affectedRows = pStmt.executeUpdate();
	            if (affectedRows > 0) {
	                flag = true;
//	                System.out.println(affectedRows);//チェック用
	            }
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            try {
	                conn.rollback();
	                System.out.println("Rollback successful");
	            } catch (SQLException rollbackException) {
	                rollbackException.printStackTrace();
	                System.out.println("rollbackすらできず");
	            }
	        }
	        
//	        conn.commit();//チェック用
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
		return flag;
			
	}

}
