package model;

import java.util.ArrayList;
import java.util.List;

public class ForSessionModel {
	private String date;
	List<String> spesessionidList=new ArrayList<>();
	List<List<String>> spememberList=new ArrayList<>();
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public List<String> getSpesessionidList() {
		return spesessionidList;
	}
	public void setSpesessionidList(List<String> spesessionidList) {
		this.spesessionidList = spesessionidList;
	}
	public List<List<String>> getSpememberList() {
		return spememberList;
	}
	public void setSpememberList(List<List<String>> spememberList) {
		this.spememberList = spememberList;
	}
	
}
