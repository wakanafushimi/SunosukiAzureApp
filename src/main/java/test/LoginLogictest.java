package test;

import model.LoginLogic;
import model.LoginModel;

public class LoginLogictest {
	public static void main(String[] args) {
		OKtest();
		NGtest();
	}
	
	public static void OKtest() {
		LoginModel loginModel=new LoginModel("userA","1234");
		LoginLogic loginLogic=new LoginLogic();
		Boolean flag=loginLogic.execute(loginModel);
		if(flag) {
			System.out.println("OKテスト〇");
		}else {
			System.out.println("OKテスト×");
		}
		
	}
	
	public static void NGtest() {
		LoginModel loginModel=new LoginModel("userA","12345");
		LoginLogic loginLogic=new LoginLogic();
		Boolean flag=loginLogic.execute(loginModel);
		if(flag) {
			System.out.println("NGテスト×");
		}else {
			System.out.println("NGテスト〇");
		}
		
	}

}
