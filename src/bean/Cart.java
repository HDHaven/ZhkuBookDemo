package bean;

public class Cart {
	/**
	 * 购物车实体类，对应数据库中的购物车表（tb_Cart）
	 */
	private int cartId;// 购物车编号
	private String userName;// 购物车所属用户
	private String storeName;// 图书所属店铺
	private String bookName;// 购物车图书名称
	private String bookPrice;// 购物车图书单价
	private String bookNumber;// 购物车每本书的数量
	
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
