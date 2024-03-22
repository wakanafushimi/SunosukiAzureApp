package model;

public class UsersData {
	private String id;
	private String password;
	
	public UsersData(String id,String password) {
		this.id=id;
		this.password=password;
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
}
