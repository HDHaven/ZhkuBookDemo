package dao;

import bean.Comment;
import bean.PageBean;
import util.DBUtil;

public class CommentDAO {
	/**
	 * �����������ݷ��ʲ�
	 */
	private DBUtil db;
	
	public CommentDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ����ݵ�������������ȡͼ��������Ϣ����ҳ��ʾ
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�������Ϣ�б����򷵻�null��
	 */
	public PageBean getComment(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Comment where storeName=? and bookName=? ";
		String[] params = { storeName, bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ������ݿ�����۱������һ�����ۣ���ӳɹ���Ҫ�Ե������ֽ�����Ӧ���޸�
	 * @param c
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addComment(Comment c) {
		boolean success = false;
		String sql = "insert into tb_Comment values(null,?,?,?,?,?)";
		String[] params = { c.getUserName(), c.getStoreName(), c.getBookName(), c.getCommentScore(), c.getCommentContent() };
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
}
