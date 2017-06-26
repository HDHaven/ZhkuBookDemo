package bean;

import java.io.Serializable;

public class Cart implements Serializable{
		private static final long serialVersionUID = 1L;
	/**
	 * ���ﳵʵ���࣬��Ӧ���ݿ��еĹ��ﳵ��tb_Cart��
	 */
	private int cartId;// ���ﳵ���
	private String userName;// ���ﳵ�����û�
	private String storeName;// ͼ����������
	private String bookName;// ���ﳵͼ������
	private int bookPrice;// ���ﳵͼ�鵥��
	private int bookNumber;// ���ﳵÿ���������
	private String bookImage;
	
	public Cart() {
	}

	public Cart(int cartId, String userName, String storeName, String bookName, int bookPrice, int bookNumber,
			String bookImage) {
		super();
		this.cartId = cartId;
		this.userName = userName;
		this.storeName = storeName;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookNumber = bookNumber;
		this.bookImage = bookImage;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
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

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
}
