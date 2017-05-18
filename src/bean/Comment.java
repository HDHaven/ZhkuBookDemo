package bean;

public class Comment {
	/**
	 * 图书评论实体表，对应数据库中的评论表（tb_Comment）
	 */
	private int commentId;// 评论编号
	private String userName;// 评论人
	private String storeName;// 评论的店铺
	private String bookName;// 评论的图书
	private String commentScore;// 评论分数（1-5分）
	private String commentContent;// 评论内容
	
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
