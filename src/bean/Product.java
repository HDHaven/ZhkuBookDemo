package bean;

public class Product {
	/**
	 * 商品实体类
	 */
	private String bookName;
	private String bookPrice;
	private String bookNumber;
	
	public Product() {
	}

	public Product(String bookName, String bookPrice, String bookNumber) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookNumber = bookNumber;
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
