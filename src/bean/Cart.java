package bean;

public class Cart {
	/**
	 * ���ﳵʵ���࣬��Ӧ���ݿ��еĹ��ﳵ��tb_Cart��
	 */
	private int cartId;// ���ﳵ���
	private String userName;// ���ﳵ�����û�
	private String storeName;// ͼ����������
	private String bookName;// ���ﳵͼ������
	private String bookPrice;// ���ﳵͼ�鵥��
	private String bookNumber;// ���ﳵÿ���������
	
	public Cart() {
	}

	public Cart(String userName, String storeName, String bookName, String bookPrice, String bookNumber) {
		super();
		this.userName = userName;
		this.storeName = storeName;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookNumber = bookNumber;
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

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(String bookNumber) {
		this.bookNumber = bookNumber;
	}
	
}
