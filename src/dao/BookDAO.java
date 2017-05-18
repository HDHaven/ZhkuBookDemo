package dao;

import java.util.List;

import bean.Book;
import bean.PageBean;
import util.DBUtil;

public class BookDAO {
	/**
	 * ͼ�����ݷ��ʲ�
	 */
	private DBUtil db;
	
	public BookDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ�����ͼ�����ƻ�ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByName(String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where bookName=? order by bookSaleNum desc ";
		String[] params = { bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ�����ͼ������ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param bookClass
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByClass(String bookClass, int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
	/**
	 * ���ܣ�����ͼ���������̷���ͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByStore(String storeName, int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
	/**
	 * ���ܣ��ڵ����ڸ���ͼ�����ƻ�ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookInStoreByName(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		
		return pb; 
	}
	
	/**
	 * ���ܣ��ڵ����ڸ���ͼ������ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param bookClass
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookInStoreByClass(String storeName, String bookClass, int curPage) {
		PageBean pb = null;
		
		return pb; 
	}
	
	/**
	 * ���ܣ����ݵ�������ȡ�õ����������ϴ���4��ͼ����Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻������ϴ���4��ͼ����Ϣ�����򷵻�null��
	 */
	public List<Book> getBookByLastDate(String storeName) {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * ���ܣ����ݵ�������ȡ�õ�����������õ�4��ͼ����Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻ص�����������4��ͼ����Ϣ�����򷵻�null��
	 */
	public List<Book> getBookByHotSale(String storeName) {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * ���ܣ���ȡͼ���������õ�4��ͼ����Ϣ
	 * @return �ɹ��򷵻�ͼ�����������õ�4��ͼ����Ϣ�����򷵻�null��
	 */
	public List<Book> getBookInHotSale() {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * ���ܣ���ȡͼ����������ϴ���4��ͼ����Ϣ
	 * @return �ɹ��򷵻�ͼ����������ϴ���4��ͼ����Ϣ�����򷵻�null��
	 */
	public List<Book> getBookInLastDate() {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * ���ܣ������ݿ������һ����
	 * @param book
	 * @return �ɹ��򷵻���Ӱ������������򷵻�0��
	 */
	public int addBook(Book book) {
		int recNo = 0;
		
		return recNo;
	}
	
	/**
	 * ���ܣ�����ͼ����
	 * @param bookId
	 * @return �ɹ��򷵻���Ӱ������������򷵻�0��
	 */
	public int deleteBook(int bookId) {
		int recNo = 0;
		
		return recNo;
	}
	
	/**
	 * ���ܣ�����ͼ�����޸�ͼ��ļ۸���߿����
	 * @param book
	 * @return �ɹ��򷵻���Ӱ������������򷵻�0��
	 */
	public int updateBook(Book book) {
		int recNo = 0;
		
		return recNo;
	}
	
}
