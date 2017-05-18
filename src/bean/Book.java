package bean;

public class Book {
	/**
	 * 图书实体类，对应数据库中的图书表（tb_Book）
	 */
	private int bookId;// 图书编号
	private String storeName;// 图书所属店铺
	private String bookISBN;// 图书ISBN号
	private String bookName;// 图书名称
	private String bookAuthor;// 图书作者
	private String bookPublisher;// 图书出版社
	private String bookPrice;// 图书单价
	private String bookSaleNum;// 图书销量
	private String bookSumNum;// 图书库存量
	private String bookClass;// 图书类别
	private String bookPage;// 图书总页数
	private String bookDescript;// 图书简介
	private String bookImage;// 图书封面
	
	public Book() {
	}

	public Book(String storeName, String bookISBN, String bookName, String bookAuthor, String bookPublisher,
			String bookPrice, String bookSaleNum, String bookSumNum, String bookClass, String bookPage,
			String bookDescript, String bookImage) {
		super();
		this.storeName = storeName;
		this.bookISBN = bookISBN;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
		this.bookPrice = bookPrice;
		this.bookSaleNum = bookSaleNum;
		this.bookSumNum = bookSumNum;
		this.bookClass = bookClass;
		this.bookPage = bookPage;
		this.bookDescript = bookDescript;
		this.bookImage = bookImage;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(String bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookSaleNum() {
		return bookSaleNum;
	}

	public void setBookSaleNum(String bookSaleNum) {
		this.bookSaleNum = bookSaleNum;
	}

	public String getBookSumNum() {
		return bookSumNum;
	}

	public void setBookSumNum(String bookSumNum) {
		this.bookSumNum = bookSumNum;
	}

	public String getBookClass() {
		return bookClass;
	}

	public void setBookClass(String bookClass) {
		this.bookClass = bookClass;
	}

	public String getBookPage() {
		return bookPage;
	}

	public void setBookPage(String bookPage) {
		this.bookPage = bookPage;
	}

	public String getBookDescript() {
		return bookDescript;
	}

	public void setBookDescript(String bookDescript) {
		this.bookDescript = bookDescript;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
	}
	
}
