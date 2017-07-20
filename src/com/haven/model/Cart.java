package com.haven.model;

/**
 * ���ﳵʵ���࣬��Ӧ���ݿ��еĹ��ﳵ��
 */
public class Cart {

	private int cartId;// ���ﳵ���
	private int bookId;// ͼ����
	private String userName;// ���ﳵ�����û�
	private String storeName;// ͼ����������
	private String bookName;// ���ﳵͼ������
	private double bookPrice;// ���ﳵͼ�鵥��
	private int bookCount;// ���ﳵÿ���������
	private String bookImage;// ͼ�����
	
	public Cart() {
	}

	public Cart(int bookId, String userName, String storeName, String bookName, double bookPrice, int bookCount,
			String bookImage) {
//		super();
		this.bookId = bookId;
		this.userName = userName;
		this.storeName = storeName;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookCount = bookCount;
		this.bookImage = bookImage;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
}
