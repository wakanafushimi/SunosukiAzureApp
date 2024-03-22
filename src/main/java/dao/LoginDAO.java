package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.UsersData;

public class LoginDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public UsersData Login (LoginModel loginModel) {
		UsersData usersData=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
		
		try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql="select id,password from user where id=? and password=?;";
			PreparedStatement pStmt=conn.prepareStatement(sql);
			pStmt.setString(1,loginModel.getId());
			pStmt.setString(2,loginModel.getPassword());
			
			ResultSet rs=pStmt.executeQuery();
			
			if(rs.next()) {
				String id=rs.getString("id");
				String password=rs.getString("password");
				
			//ログイン成功でusersDataにアカウント情報が入る
			//ログイン失敗でusersData==null
			usersData=new UsersData(id,password);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("データベース接続失敗です");
			return null;
		}
		
		return usersData;
		
	}

}
