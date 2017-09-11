package com.haven.model;

import java.util.List;

/**
 * ����ʵ���࣬��Ӧ���ݿ��еĶ�����
 */
public class Order {

	private int orderId;// �������
	private String storeName; // ������������
	private String orderDate;// �µ�����
	private double orderPrice;// �����ܼ�
	private String userName;// �µ��û�
	private String orderState; // ����״̬
	private int addrId; // �����ջ���ַ���
	private Address orderAddr; // �ջ���ַ
	private List<OrderProduct> productList; // ������������Ʒ�б�
	
	public Order() {
	}

	public Order(String storeName, String orderDate, double orderPrice, String userName, String orderState,
			int addrId, Address orderAddr, List<OrderProduct> productList) {
//		super();
		this.storeName = storeName;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.userName = userName;
		this.orderState = orderState;
		this.addrId = addrId;
		this.orderAddr = orderAddr;
		this.productList = productList;
	}

	public Order(String storeName, String orderDate, double orderPrice, String userName, String orderState,
			int addrId) {
//		super();
		this.storeName = storeName;
		this.orderDate = orderDate;
		this.orderPrice = orderPrice;
		this.userName = userName;
		this.orderState = orderState;
		this.addrId = addrId;
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

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public int getAddrId() {
		return addrId;
	}
	
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	
	public Address getOrderAddr() {
		return orderAddr;
	}

	public void setOrderAddr(Address orderAddr) {
		this.orderAddr = orderAddr;
	}

	public List<OrderProduct> getProductList() {
		return productList;
	}

	public void setProductList(List<OrderProduct> productList) {
		this.productList = productList;
	}
	
}
