package model;

import java.util.ArrayList;
import java.util.List;

public class TrickModel {
//	private String trick_aItem;
//	private String trick_bItem;
//	
//	public String getTrick_aItem() {
//		return trick_aItem;
//	}
//	public void setTrick_aItem(String trick_aItem) {
//		this.trick_aItem = trick_aItem;
//	}
//	
//	public String getTrick_bItem() {
//		return trick_bItem;
//	}
//	public void setTrick_bItem(String trick_bItem) {
//		this.trick_bItem = trick_bItem;
//	}
//	
	
	List<String> trick_a=new ArrayList<>();
	List<String> trick_b=new ArrayList<>();
	
	public void setintoTrick_a(String trick_a) {
		this.trick_a.add(trick_a);
	}
	public void setintoTrick_b(String trick_b) {
		this.trick_b.add(trick_b);
	}
	
	public List<String> getTrick_aList() {
		return trick_a;
	}
	public List<String> getTrick_bList() {
		return trick_b;
	}
	

}
