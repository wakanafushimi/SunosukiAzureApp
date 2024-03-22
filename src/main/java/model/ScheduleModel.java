package model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleModel {
	List<String> yoursessionList=new ArrayList<>();
	List<List<String>> yoursessionmemberList=new ArrayList<>();

	public List<String> getYoursessionList() {
		return yoursessionList;
	}
	public void setYoursessionList(List<String> yoursessionList) {
		this.yoursessionList = yoursessionList;
	}
	
	public List<List<String>> getYoursessionmemberList() {
		return yoursessionmemberList;
	}
	public void setYoursessionmemberList(List<List<String>> yoursessionmemberList) {
		this.yoursessionmemberList = yoursessionmemberList;
	}
	

}
