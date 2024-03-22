package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PeersModel {
	List<String[]> list=new ArrayList<>();
	Set<String> set = new HashSet<String>();
	
	public List<String[]> getList(){
		return this.list;
	}	
	public Set<String> getSet(){
		return this.set;
	}
}
