package bean;

/**
 * 用户实体类
 * 
 * @author 黄华冬
 *
 */
public class User {

	private int userId;
	private String userName;
	private String password;
	private String userType;
	private String userAddr;
	private String userPhone;
	private String userConsignee;

	public User() {
	}

	public User(int userId, String userName, String password, String userType, String userAddr, String userPhone,
			String userConsignee) {
		super();
		this.userId = userId;
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
