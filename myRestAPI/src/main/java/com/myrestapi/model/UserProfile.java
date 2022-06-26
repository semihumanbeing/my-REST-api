package com.myrestapi.model;

public class UserProfile {
	
	// 서버 어플리케이션을 만들 때에는 멤버변수를 private 으로 만들고 
	// 멤버 변수에 접근해서 값을 세팅하기 위한 getter/setter를 만드는 것이 일반적인 관례이다.
	
	private String id;
	private String name;
	private String phone;
	private String address;
	
	public UserProfile(String id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	

}
