package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.LoginModel;
import model.ProfileModel;

public class ProfileDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	public void setDetail(LoginModel loginModel,ProfileModel profileModel) {
//		System.out.println("setDetail呼び出しOK");
//		System.out.println("profileModel型のインスタンスに入った入力データ:"+profileModel.getSelfintro());
		
			
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(false);
	        
	        //userdetailにidが登録済みか調べる
	        String sql = "select * from userdetail where id = ?;";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)){
	        	stmt.setString(1,loginModel.getId());
 	        	ResultSet rs=stmt.executeQuery();
 	        	conn.commit();
 	        	
// 	        	System.out.println("userdetailにid登録済みか調べたOK");
	        	
 	        	//id未登録だったら、idから全てinsert
 	        	if(!rs.next()) { 	 	        	
 	        		String sqlIn = "insert into userdetail values(?,?,?,?,?,?,?,?,?,?);";
// 	        		System.out.println("id未登録として分岐");
 	        		try(PreparedStatement stmtIn = conn.prepareStatement(sqlIn)){
 	        		stmtIn.setString(1, loginModel.getId());
	        		stmtIn.setString(2, profileModel.getImg());
	        		stmtIn.setString(3, profileModel.getUsername());
	        		stmtIn.setString(4, profileModel.getPref());
	        		stmtIn.setString(5, profileModel.getCar());
	        		stmtIn.setString(6, profileModel.getStyle());
	        		stmtIn.setString(7, profileModel.getGeer());
	        		stmtIn.setString(8, profileModel.getSelfintro());
	        		stmtIn.setString(9, profileModel.getInsta());
	        		stmtIn.setString(10, profileModel.getX());
//	        		System.out.println("id未登録ケースsetDetail成功");
	        		stmtIn.executeUpdate();
	        		conn.commit();
 	        		}catch(SQLException e) {
 	        			e.printStackTrace();
 	        			conn.rollback();
 	        			System.out.println("エラー1"+e.getMessage());
 	        		}
 	        	}
 	        	 	        	
 	        	//idが登録済みだったら
 	        	//（ProfileModelには入力されたものがはいってる）
 	        	else  {
// 	        		System.out.println("id登録済みとして分岐");
 	        		
// 	        		String str=rs.getString("username");
// 	 	        	System.out.println(str);
 	        		
 	        		//入力がnullじゃなければ、データベースを更新
 	        		
 	        		if(profileModel.getImg()!=null) {
 		        		String sqlImg=" UPDATE userdetail SET img = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtImg = conn.prepareStatement(sqlImg)){
 		        		stmtImg.setString(1, profileModel.getImg());
// 		        		System.out.println("proifleModelのimg:"+profileModel.getImg());
 		        		stmtImg.setString(2, loginModel.getId());
 		        		stmtImg.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 		        		
 	 	        	}
 	        		
 	        		if(profileModel.getUsername()!=null) {
 	        			String sqlUsername=" UPDATE userdetail SET username = ? WHERE id = ?;";
 	        			try(PreparedStatement stmtUsername = conn.prepareStatement(sqlUsername)){
 	        			stmtUsername.setString(1, profileModel.getUsername());
// 	        			System.out.println("proifleModelのusername:"+profileModel.getUsername());
 	        			stmtUsername.setString(2, loginModel.getId());
 	        			stmtUsername.executeUpdate(); 
 	        			conn.commit();
 	        			}catch(SQLException e) {
 	        				e.printStackTrace();
 	        				conn.rollback();
 	 	        			System.out.println(e.getMessage());
 	        			}
 	        		}	        		
 	        		
 	        		if(profileModel.getPref()!=null) {
 		        		String sqlPref=" UPDATE userdetail SET pref = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtPref = conn.prepareStatement(sqlPref)){
 		        		stmtPref.setString(1, profileModel.getPref());
// 		        		System.out.println("proifleModelのpref:"+profileModel.getPref());
 		        		stmtPref.setString(2, loginModel.getId());
 		        		stmtPref.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		
 	        		if(profileModel.getCar()!=null) {
 		        		String sqlCar=" UPDATE userdetail SET car = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtCar = conn.prepareStatement(sqlCar)){
 		        		stmtCar.setString(1, profileModel.getCar());
// 		        		System.out.println("proifleModelのcar:"+profileModel.getCar());
 		        		stmtCar.setString(2, loginModel.getId());
 		        		stmtCar.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		
 	        		if(profileModel.getStyle()!=null) {
 		        		String sqlStyle=" UPDATE userdetail SET style = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtStyle = conn.prepareStatement(sqlStyle)){
 		        		stmtStyle.setString(1, profileModel.getStyle());
// 		        		System.out.println("proifleModelのstyle:"+profileModel.getStyle());
 		        		stmtStyle.setString(2, loginModel.getId());
 		        		stmtStyle.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		if(profileModel.getGeer()!=null) {
 		        		String sqlGeer=" UPDATE userdetail SET geer = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtGeer = conn.prepareStatement(sqlGeer)){
 		        		stmtGeer.setString(1, profileModel.getGeer());
// 		        		System.out.println("proifleModelのgeer:"+profileModel.getGeer());
 		        		stmtGeer.setString(2, loginModel.getId());
 		        		stmtGeer.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		
 	        		if(profileModel.getSelfintro()!=null) {
 		        		String sqlSelfintro=" UPDATE userdetail SET selfintro = ? WHERE id = ?;";
// 		        		System.out.println("selfintroのinputはnullじゃないとして分岐");
 		        		
 		        		try(PreparedStatement stmtSelfintro = conn.prepareStatement(sqlSelfintro)){
 		        		stmtSelfintro.setString(1, profileModel.getSelfintro());
// 		        		System.out.println("proifleModelのselfintro:"+profileModel.getSelfintro());
 		        		stmtSelfintro.setString(2, loginModel.getId());
 		        		stmtSelfintro.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 		        		
 	 	        	}else {
// 	 	        		System.out.println("selfintroのinputはnullとして分岐");
 	 	        	}
 	        		
 	        		if(profileModel.getInsta()!=null) {
 		        		String sqlInsta=" UPDATE userdetail SET insta = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtInsta = conn.prepareStatement(sqlInsta)){
 		        		stmtInsta.setString(1, profileModel.getInsta());
 		        		stmtInsta.setString(2, loginModel.getId());
 		        		stmtInsta.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		
 	        		if(profileModel.getX()!=null) {
 		        		String sqlX=" UPDATE userdetail SET x = ? WHERE id = ?;";
 		        		try(PreparedStatement stmtX = conn.prepareStatement(sqlX)){
 		        		stmtX.setString(1, profileModel.getX());
 		        		stmtX.setString(2, loginModel.getId());
 		        		stmtX.executeUpdate(); 
 		        		conn.commit();
 		        		}catch(SQLException e) {
 		        			e.printStackTrace();
 		        			conn.rollback();
 	 	        			System.out.println(e.getMessage());
 		        		}
 	 	        	}
 	        		
// 	        		System.out.println("id登録済みケースsetDetail終了");
	        			
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
	
	public ProfileModel getDetail(LoginModel loginModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from userdetail where id = ?;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	stmt.setString(1,loginModel.getId());
	        ResultSet rs=stmt.executeQuery();
	        
	        ProfileModel profileModel=new ProfileModel();
	        
	        while(rs.next()) {
	        
	        String img=rs.getString("img");
	        profileModel.setImg(img);
	        
	        String username=rs.getString("username");
	        profileModel.setUsername(username);
	        
	        String pref=rs.getString("pref");
	        profileModel.setPref(pref);
	        
	        String car=rs.getString("car");
	        profileModel.setCar(car);
	        
	        String style=rs.getString("style");
	        profileModel.setStyle(style);
	        
	        String geer=rs.getString("geer");
	        profileModel.setGeer(geer);
	        
	        String selfintro=rs.getString("selfintro");
	        profileModel.setSelfintro(selfintro); 
	        
	        String insta=rs.getString("insta");
	        profileModel.setInsta(insta); 
	        
	        String x=rs.getString("x");
	        profileModel.setX(x); 
	        
	
//	        System.out.println("getDetail成功");
	        }
	        
//	        System.out.println("getDetailで該当idなし");
	        return profileModel;
	       
	        
	      
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("エラー3"+e.getMessage());
			return null;
		}
		
		
	}
}
