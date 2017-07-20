package com.haven.model;

import java.util.List;

/**
 * �û�ʵ���࣬��Ӧ���ݿ��е��û���
 */
public class User {

	private int userId; // �û����
	private String userName; // �û���
	private String password; // ����
	private String userType; // �û����ͣ���1����ʾ��ͨ�û�����2����ʾ����Ա
	private List<Address> addrList; // �û���ַ�б�
	
	public User() {
	}

	public User(String userName, String password, String userType, List<Address> addrList) {
//		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.addrList = addrList;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public List<Address> getAddrList() {
		return addrList;
	}

	public void setAddrList(List<Address> addrList) {
		this.addrList = addrList;
	}
	
}
