package bean;

/**
 * ����ʵ����
 * 
 * @author �ƻ���
 *
 */
public class Order {

	private int orderId;// �������
	private String orderDate;// �µ�����
	private int orderPrice;// �����ܼ�
	private String orderConsignee;// �ջ���
	private String orderAddr;// �����ջ���ַ
	private String orderPhone;// �ջ�����ϵ��ʽ
	private String userName;// �µ��û�

	public Order() {
	}

	public Order(int orderId, String orderDate, int orderPrice, String orderConsignee, String orderAddr,
			String orderPhone, String userName) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.orderConsignee = orderConsignee;
		this.orderAddr = orderAddr;
		this.orderPhone = orderPhone;
		this.userName = userName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
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

}
