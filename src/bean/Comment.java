package bean;

public class Comment {
	/**
	 * ͼ������ʵ�����Ӧ���ݿ��е����۱�tb_Comment��
	 */
	private int commentId;// ���۱��
	private String userName;// ������
	private String storeName;// ���۵ĵ���
	private String bookName;// ���۵�ͼ��
	private String commentScore;// ���۷�����1-5�֣�
	private String commentContent;// ��������
	
	public Comment() {
	}

	public Comment(String userName, String storeName, String bookName, String commentScore, String commentContent) {
		super();
		this.userName = userName;
		this.storeName = storeName;
		this.bookName = bookName;
		this.commentScore = commentScore;
		this.commentContent = commentContent;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
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

	public String getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(String commentScore) {
		this.commentScore = commentScore;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
}
