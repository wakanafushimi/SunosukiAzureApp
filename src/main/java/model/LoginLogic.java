package model;

import dao.LoginDAO;

public class LoginLogic {
	public boolean execute(LoginModel loginModel) {
		LoginDAO loginDAO=new LoginDAO();
		UsersData usersData=loginDAO.Login(loginModel);
		return usersData!=null;
	}

}
