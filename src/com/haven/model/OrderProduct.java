package com.haven.model;

public class OrderProduct {

	private int productId; // ��Ʒ���
	private int orderId; // ��Ʒ����������
	private int bookId; // ��Ʒ��Ӧ��ͼ����
	private String productName; // ��Ʒ����
	private double productPrice; // ��Ʒ�۸�
	private int productCount; // ��������
	private String productImage; // ��Ʒ����
	
	public OrderProduct() {
	}

	public OrderProduct(int orderId, int bookId, String productName, double productPrice, int productCount,
			String productImage) {
//		super();
		this.orderId = orderId;
		this.bookId = bookId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCount = productCount;
		this.productImage = productImage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
}
