package model;

import java.util.ArrayList;
import java.util.List;

public class ForCoachModel {
	private String trick;
	List<String> coachesList=new ArrayList<>();
	String[] coaches=new String[coachesList.size()];

	public String getTrick() {
		return trick;
	}

	public void setTrick(String trick) {
		this.trick = trick;
	}

	public List<String> getCoachesList() {
		return coachesList;
	}
	public void setCoachesList(List<String> coachesList) {
		this.coachesList=coachesList;
	}

	public String[] getCoaches() {
		return coaches;
	}

	public void setCoaches(String[] coaches) {
		this.coaches = coaches;
	}
	
	
	
	
}
