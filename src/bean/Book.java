package bean;

/**
 * 图书实体类
 */
public class Book {

	private int bookId;
	private String storeName;
	private String bookISBN;
	private String bookName;
	private String bookAuthor;
	private String bookPublisher;
	private int bookPrice;
	private int bookSaleNum;
	private int bookSumNum;
	private String bookClass;
	private String bookPage;
	private String bookDescript;
	private String bookImage;
	
	public Book() {
	}

	public Book(int bookId, String storeName, String bookISBN, String bookName, String bookAuthor, String bookPublisher,
			int bookPrice, int bookSaleNum, int bookSumNum, String bookClass, String bookPage, String bookDescript,
			String bookImage) {
		super();
		this.bookId = bookId;
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

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public int getBookSaleNum() {
		return bookSaleNum;
	}

	public void setBookSaleNum(int bookSaleNum) {
		this.bookSaleNum = bookSaleNum;
	}

	public int getBookSumNum() {
		return bookSumNum;
	}

	public void setBookSumNum(int bookSumNum) {
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
