package com.haven.model;

/**
 * ͼ������ʵ���࣬��Ӧ���ݿ��е����۱�
 */
public class BookComment {

	private int commentId; // ���۱��
	private int bookId; // ͼ����
	private int orderId; // ������������
	private String userName; // �����û�
	private int commentScore; // ���۷���
	private String commentContent; // ��������
	
	public BookComment() {
	}

	public BookComment(int bookId, int orderId, String userName, int commentScore, String commentContent) {
		super();
		this.bookId = bookId;
		this.orderId = orderId;
		this.userName = userName;
		this.commentScore = commentScore;
		this.commentContent = commentContent;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
