package com.lero.model;

public class Student {
	private int studentId;
	private String stuNum;
	private String userName;
	private String password;
	private int dormBuildId = 0;
	private String dormBuildName;
	private String dormName;
	private String name;
	private String sex;
	private String tel;
	private  int recordCount;
	public Student() {
	}
	
	public Student(String userName, String password) {
		this.stuNum = userName;
		this.userName = userName;
		this.password = password;
	}
	
	
	public Student(String stuNum, String password, int dormBuildId,
				   String dormName, String name, String sex, String tel) {
		this.stuNum = stuNum;
		this.userName = stuNum;
		this.password = password;
		this.dormBuildId = dormBuildId;
		this.dormName = dormName;
		this.name = name;
		this.sex = sex;
		this.tel = tel;
	}

	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
		this.stuNum = userName;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
		this.userName = stuNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getDormBuildId() {
		return dormBuildId;
	}

	public void setDormBuildId(int dormBuildId) {
		this.dormBuildId = dormBuildId;
	}

	public String getDormBuildName() {
		return dormBuildName;
	}

	public void setDormBuildName(String dormBuildName) {
		this.dormBuildName = dormBuildName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getDormName() {
		return dormName;
	}

	public void setDormName(String dormName) {
		this.dormName = dormName;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getRecordCount(){return recordCount;}
	public void setRecordCount(int recordCount) {this.recordCount=recordCount;}
}
