package bean;

public class Order {
	/**
	 * 订单实体类，对应数据库中的订单表（tb_Order）
	 */
	private int orderId;// 订单编号
	private String storeName;// 从哪家店下的单
	private String orderDate;// 下单日期
	private String orderPrice;// 订单总价
	private String orderState;// 订单状态
	private String orderConsignee;// 收货人
	private String orderAddr;// 订单收货地址
	private String orderPhone;// 收货人联系方式
	private String userName;// 下单用户
	private String productList;// 订单包含的商品（商品名:单价:数量;商品名:单价:数量;）
	
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
