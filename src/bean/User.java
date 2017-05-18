package bean;

public class User {
	/**
	 * 用户实体类，对应数据库中的用户表（tb_User）
	 */
	private int userId;// 用户编号
	private String userName;// 用户名
	private String password;// 密码
	private String userType;// 用户类型
	private String userAddr;// 用户收货地址
	private String userPhone;// 用户联系电话
	private String userConsignee;// 收货人名称
	
	public User() {
	}

	public User(String userName, String password, String userType, String userAddr, String userPhone,
			String userConsignee) {
		super();
		this.userName = userName;
		this.password = password;
		this.userType = userType;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.userConsignee = userConsignee;
	}

	public int getUserId() {
		return userId;
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

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserConsignee() {
		return userConsignee;
	}

	public void setUserConsignee(String userConsignee) {
		this.userConsignee = userConsignee;
	}
	
}
