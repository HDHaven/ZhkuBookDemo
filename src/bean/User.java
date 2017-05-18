package bean;

public class User {
	/**
	 * �û�ʵ���࣬��Ӧ���ݿ��е��û���tb_User��
	 */
	private int userId;// �û����
	private String userName;// �û���
	private String password;// ����
	private String userType;// �û�����
	private String userAddr;// �û��ջ���ַ
	private String userPhone;// �û���ϵ�绰
	private String userConsignee;// �ջ�������
	
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
