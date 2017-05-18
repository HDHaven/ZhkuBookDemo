package bean;

public class Order {
	/**
	 * ����ʵ���࣬��Ӧ���ݿ��еĶ�����tb_Order��
	 */
	private int orderId;// �������
	private String storeName;// ���ļҵ��µĵ�
	private String orderDate;// �µ�����
	private String orderPrice;// �����ܼ�
	private String orderState;// ����״̬
	private String orderConsignee;// �ջ���
	private String orderAddr;// �����ջ���ַ
	private String orderPhone;// �ջ�����ϵ��ʽ
	private String userName;// �µ��û�
	private String productList;// ������������Ʒ����Ʒ��:����:����;��Ʒ��:����:����;��
	
	public Order() {
	}

	public Order(String storeName, String orderDate, String orderPrice, String orderState, String orderConsignee,
			String orderAddr, String orderPhone, String userName, String productList) {
		super();
		this.storeName = storeName;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.orderState = orderState;
		this.orderConsignee = orderConsignee;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.userName = userName;
		this.productList = productList;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public String getOrderConsignee() {
		return orderConsignee;
	}

	public void setOrderConsignee(String orderConsignee) {
		this.orderConsignee = orderConsignee;
	}

	public String getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(String orderAddr) {
		this.orderAddr = orderAddr;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getProductList() {
		return productList;
	}

	public void setProductList(String productList) {
		this.productList = productList;
	}
	
}
