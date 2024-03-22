package test;

import java.util.List;

import dao.SessionListDAO;
import model.SessionListModel;

public class SessionListTest {
	public static void main(String[] args) {
		SessionListDAO sessionListDAO= new SessionListDAO();
		SessionListModel sessionListModel=new SessionListModel();
		sessionListModel=sessionListDAO.setSession(sessionListModel);
		List<String[]> sessionList=sessionListModel.getSessionList();
		List<List<String>> memberList=sessionListModel.getMemberList();
		for(String[] session:sessionList) {
			System.out.println(session[0]+session[1]+session[2]+session[5]+session[6]);
		}
		for(List<String> member:memberList) {
			for(String individual:member) {
				System.out.println(individual);
			}
		}
		
	}

}