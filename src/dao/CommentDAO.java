package dao;

import bean.Comment;
import bean.PageBean;
import util.DBUtil;

public class CommentDAO {
	/**
	 * 订单评论数据访问层
	 */
	private DBUtil db;
	
	public CommentDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：根据店铺名和书名获取图书评论信息，分页显示
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回评论信息列表，否则返回null。
	 */
	public PageBean getComment(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Comment where storeName=? and bookName=? ";
		String[] params = { storeName, bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：往数据库的评论表中添加一条评论，添加成功后要对店铺评分进行相应的修改
	 * @param c
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addComment(Comment c) {
		boolean success = false;
		String sql = "insert into tb_Comment values(null,?,?,?,?,?)";
		String[] params = { c.getUserName(), c.getStoreName(), c.getBookName(), c.getCommentScore(), c.getCommentContent() };
		if(db.update(sql, params) > 0) {
			success = true;	// 添加成功
		}
		return success;
	}
	
}
