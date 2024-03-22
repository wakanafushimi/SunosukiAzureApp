package test;

import dao.LoginDAO;
import model.LoginModel;
import model.UsersData;

public class LoginDAOtest {
	public static void main(String[] args) {
		testOK();
		testNG();
	}
	
	public static void testOK() {
		LoginModel loginModel=new LoginModel("userA","1234");
		
		LoginDAO loginDAO=new LoginDAO();
		UsersData usersData=loginDAO.Login(loginModel);
		
		if (usersData!=null && usersData.getId().equals("userA") && usersData.getPassword().equals("1234")) {
			System.out.println("OKテスト〇");
		}else {
			System.out.println("OKテスト×");
		}
		
	}
	
	public static void testNG() {
		LoginModel loginModel=new LoginModel("userA","12345");
		
		LoginDAO loginDAO=new LoginDAO();
		UsersData usersData=loginDAO.Login(loginModel);
		
		if(usersData==null) {
			System.out.println("NGテスト〇");
		}else {
			System.out.println("NGテスト×");
		}
	}

}
