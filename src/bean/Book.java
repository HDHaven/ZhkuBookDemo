package bean;

public class Book {
	/**
	 * ͼ��ʵ���࣬��Ӧ���ݿ��е�ͼ���tb_Book��
	 */
	private int bookId;// ͼ����
	private String storeName;// ͼ����������
	private String bookISBN;// ͼ��ISBN��
	private String bookName;// ͼ������
	private String bookAuthor;// ͼ������
	private String bookPublisher;// ͼ�������
	private String bookPrice;// ͼ�鵥��
	private String bookSaleNum;// ͼ������
	private String bookSumNum;// ͼ������
	private String bookClass;// ͼ�����
	private String bookPage;// ͼ����ҳ��
	private String bookDescript;// ͼ����
	private String bookImage;// ͼ�����
	
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
