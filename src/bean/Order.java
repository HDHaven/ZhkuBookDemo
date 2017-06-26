package bean;

/**
 * 订单实体类
 * 
 * @author 黄华冬
 *
 */
public class Order {

	private int orderId;// 订单编号
	private String orderDate;// 下单日期
	private int orderPrice;// 订单总价
	private String orderConsignee;// 收货人
	private String orderAddr;// 订单收货地址
	private String orderPhone;// 收货人联系方式
	private String userName;// 下单用户

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
