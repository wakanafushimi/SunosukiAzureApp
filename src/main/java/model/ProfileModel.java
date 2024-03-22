package model;

public class ProfileModel {
	private String img=null; 
	private String username=null;
	private String pref=null;
	private String car=null;
	private String style=null;
	private String geer=null;
	private String selfintro;
	private String insta=null;
	private String x=null;
	
	
	public void setImg(String img) {
		this.img=img;
	}
	public String getImg() {
		return img;
	}
	
	public void setUsername(String username) {
		this.username=username;
	}
	public String getUsername() {
		return username;
	}
	
	public void setPref(String pref) {
		this.pref=pref;
	}
	public String getPref() {
		return pref;
	}
	
	public void setCar(String carStr) {
		this.car=carStr;
	}
	
	public String getCar() {
		return car;
	}
	
	public void setSelfintro(String selfintro) {
		this.selfintro=selfintro;
	}
	public String getSelfintro() {
		return selfintro;
	}
	
	public void setStyle(String style) {
		this.style = style;
	}
	public String getStyle() {
		return style;
	}
	
	public void setGeer(String geer) {
		this.geer = geer;
	}
	public String getGeer() {
		return geer;
	}
	public String getInsta() {
		return insta;
	}
	public void setInsta(String insta) {
		this.insta = insta;
	}
	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
}
