package model;

public class LoginModel {
	private String id;
	private String password;
	private boolean registerFlag;
	
	public LoginModel() {}
	
	public LoginModel(String id,String password) {
		this.id=id;
		this.password=password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	
	public boolean getRegisterFlag() {
		return registerFlag;
	}
	public void setRegisterFlag(boolean registerFlag) {
		this.registerFlag=registerFlag;
	}

}
