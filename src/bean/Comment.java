package bean;

/**
 * 评论实体类
 * @author 黄华冬
 */
public class Comment {
	
	private int commentId;
	private String userName;
	private String storeName;
	private String bookName;
	private int commentScore;
	private String commentContent;
	
	public Comment() {
	}

	public Comment(int commentId, String userName, String storeName, String bookName, int commentScore,
			String commentContent) {
		super();
		this.commentId = commentId;
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

	public int getCommentScore() {
		return commentScore;
	}

	public void setCommentScore(int commentScore) {
		this.commentScore = commentScore;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	
}
