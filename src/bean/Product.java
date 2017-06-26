package bean;

/**
 * 商品实体类
 * 
 * @author 黄华冬
 *
 */
public class Product {

	private int productId;
	private int orderId;
	private String userName;
	private String storeName;
	private String bookName;
	private int bookPrice;
	private int bookNumber;
	private String bookImage;
	private String orderState;

	public Product() {
	}

	public Product(int productId, int orderId, String userName, String storeName, String bookName, int bookPrice,
			int bookNumber, String bookImage, String orderState) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.userName = userName;
		this.storeName = storeName;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookNumber = bookNumber;
		this.bookImage = bookImage;
		this.orderState = orderState;
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

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}
