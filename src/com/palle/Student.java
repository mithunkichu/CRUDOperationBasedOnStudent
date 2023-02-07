package com.palle;

public class Student 
{
	private  int snum;
	private  String name;
	private  String sub;
	private  String mail;
	
	
	
	
	
	public Student(int snum, String name, String sub, String mail) {
		super();
		this.snum = snum;
		this.name = name;
		this.sub = sub;
		this.mail = mail;
	}
	public int getSnum() {
		return snum;
	}
	public void setSnum(int snum) {
		this.snum = snum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
