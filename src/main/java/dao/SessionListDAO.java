   package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SessionListModel;

public class SessionListDAO {
	private final String JDBC_URL="jdbc:mysql://sunosuki0226.mysql.database.azure.com/sunosuki";
	private final String DB_USER="fushimi";
	private final String DB_PASS="Wakana515";
	
	//配列sessiondetailの中身
		//[0]:sessionId
		//[1]:date
		//[2]:location
		//[3]:message
		//[4]:主催者username
		//[5]:メンバー数
		//[6]:車の台数
		//[7]:主催者のid
	
	public SessionListModel setSession(SessionListModel sessionListModel) {
		try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }
		
		List<String[]> sessiondetailList=sessionListModel.getSessiondetailList();
		List<List<String>> memberidList=sessionListModel.getMemberidList();
		List<List<String[]>> memberdetailListList=sessionListModel.getMemberdetailListList();
		String userid=null;
		String sessionid=null;
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	        conn.setAutoCommit(true);
        	String sql = "select * from session order by date;";
        	PreparedStatement stmt = conn.prepareStatement(sql);
        	ResultSet rs=stmt.executeQuery();
        	
        	//sessionテーブルの各行について
        	while(rs.next()) {
        		String[] sessiondetail=new String[8];
        		
        		sessiondetail[0]=rs.getString("sessionId");
        		sessionid=sessiondetail[0];
        		sessiondetail[1]=rs.getString("date");
        		sessiondetail[2]=rs.getString("location");
        		sessiondetail[3]=rs.getString("message");
        		userid=rs.getString("creater");
        		
        		//主催者のusernameを取得
        		String sql2 = "select username from userdetail where id=?;";
            	PreparedStatement stmt2 = conn.prepareStatement(sql2);
            	stmt2.setString(1,userid);
            	
            	ResultSet rs2=stmt2.executeQuery();
            	while(rs2.next()) {
            		sessiondetail[4]=rs2.getString("username");
            	}
            	
            	//メンバーの数を取得
            	String sql3="select count(*) from sessionmember where sessionId=?;";
            	PreparedStatement stmt3 = conn.prepareStatement(sql3);
            	stmt3.setString(1,sessiondetail[0]);
            	ResultSet rs3=stmt3.executeQuery();
            	
            	while(rs3.next()) {
            		int num=rs3.getInt("count(*)");
            		sessiondetail[5]=String.valueOf(num);
            	}
            	
            	//メンバーのidを取得
            	String sql4="select memberId from sessionmember where sessionId=?;";
            	PreparedStatement stmt4 = conn.prepareStatement(sql4);
            	stmt4.setString(1,sessiondetail[0]);
            	ResultSet rs4=stmt4.executeQuery();
            	
            	List<String> memberid=new ArrayList<>();
            	memberid.add(sessionid);
            	
            	List<String[]> memberdetailList=new ArrayList<>();
            	
            	int cars=0;
            	String carsStr=null;
            	while(rs4.next()){
            		
            		//メンバーのidをarraylistに格納
            		memberid.add(rs4.getString("memberId"));
            		
                	//メンバーの車の台数を取得
                	String sql6="select count(*) from userdetail where id=? and car='あり';";
                	PreparedStatement stmt6 = conn.prepareStatement(sql6);
                	stmt6.setString(1,rs4.getString("memberId"));
                	ResultSet rs6=stmt6.executeQuery();
                	while(rs6.next()) {
                		int count=rs6.getInt("count(*)");
                		if(count==1) {
                			cars++;
                		}
                	}
                	carsStr=String.valueOf(cars);
                	if(cars==0) {
                		carsStr="0";
                	}
//                	System.out.println(carsStr);	
                	sessiondetail[6]=carsStr;
                	
                	//memberdetail情報を取得してListに格納
                	String sql7="select * from userdetail where id = ?;";
                	PreparedStatement stmt7=conn.prepareStatement(sql7);
                	stmt7.setString(1, rs4.getString("memberId"));
                	ResultSet rs7=stmt7.executeQuery();
                	while(rs7.next()) {
                		String[] memberdetail=new String[11];
        		        int columnCount=rs7.getMetaData().getColumnCount();	
        		        memberdetail[0]=sessionid;
        		        for(int i=1;i<=columnCount;i++) {
        		        	memberdetail[i]=rs7.getString(i);
        		        }
        		        
        		        memberdetailList.add(memberdetail);
                	}
            	}
            	
            	//主催者useridをsessiondetail[7]に格納
            	sessiondetail[7]=userid;
            	
        		sessiondetailList.add(sessiondetail);
        		memberidList.add(memberid);
        		memberdetailListList.add(memberdetailList);
        		
        		
        		//チェック用
//        		System.out.println("check");
//        		for (List<String[]> innerList : memberdetailListList) {
//        			System.out.println("セッション");
//        		    for (String[] array : innerList) {
//        		        for (String element : array) {
//        		            System.out.print(element + " ");
//        		        }
//        		        System.out.println();  // 改行
//        		    }
//        		    System.out.println();  // 改行
//        		}
        		
        		
        		
        	}
        	
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("SessionListDAOのエラー");
			System.out.println(e.getMessage());
			System.out.println("SQL State: " + e.getSQLState());
		    System.out.println("Vendor Error Code: " + e.getErrorCode());
			
		}
		
		sessionListModel.setSessiondetailList(sessiondetailList);
		sessionListModel.setMemberidList(memberidList);
		sessionListModel.setMemberdetailListList(memberdetailListList);
		return sessionListModel;
		
	}
}
