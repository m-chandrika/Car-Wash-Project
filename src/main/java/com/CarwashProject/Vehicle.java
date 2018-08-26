package com.CarwashProject;


// The Model - the entity or form backing object
public class Vehicle {
	
	private String vtype;
	private long id;
	
	public Vehicle(String vtype, long id, String isMud, String bedStatus, String secondTimeFlag, String charges,
			String content) {
		super();
		this.vtype = vtype;
		this.id = id;
		this.isMud = isMud;
		this.bedStatus = bedStatus;
		this.secondTimeFlag = secondTimeFlag;
		this.charges = charges;
		this.content = content;
	}
	
	public Vehicle() {
		super();
		
	}

	private String isMud;
	private String bedStatus;
	private String secondTimeFlag;
	private String charges;
	private String content;
	
	
	public String getIsMud() {
		return isMud;
	}

	public void setIsMud(String isMud) {
		this.isMud = isMud;
	}

	public String getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}

	public String getSecondTimeFlag() {
		return secondTimeFlag;
	}

	public void setSecondTimeFlag(String secondTimeFlag) {
		this.secondTimeFlag = secondTimeFlag;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVtype() {
		return vtype;
	}

	public void setVtype(String vtype) {
		this.vtype = vtype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCharges() {
		return charges;
	}

	public void setCharges(String charges) {
		this.charges = charges;
	}
	

}
