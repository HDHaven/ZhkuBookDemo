package service;

import java.util.Map;

import bean.Book;
import bean.PageBean;
import dao.BookDAO;
import dao.OrderDAO;
import dao.StoreDAO;

/**
 * ���ҵ��������ͼ��������������Լ����뿪�ꡣ
 * 
 * ͼ�����:	(1)��ȡ����������ͼ����Ϣ������ͼ������ȡ������ͼ����Ϣ
 * 			(2)���һ��ͼ�飬���ǰ�жϸ�ͼ���Ƿ����
 * 			(3)�޸�ͼ��ļ۸���߿����
 * 			(4)ɾ��һ��ͼ��
 * 
 * ��������:	(1)��ȡ���������ж�����Ϣ�����ݶ���״̬��ȡ������Ϣ���鿴�����ջ���ַ
 * 			(2)�޸Ķ���״̬
 * 
 * @author ����
 *
 */
public class ManagerService {
	
	private StoreDAO sDao;
	private BookDAO bDao;
	private OrderDAO oDao;
	
	public ManagerService() {
		sDao = new StoreDAO();
		bDao = new BookDAO();
		oDao = new OrderDAO();
	}
	
	/**
	 * ���ܣ������ҽ������ʱҵ�񣬻�ȡһ��������Ϣ
	 * @param userName
	 * @return �ɹ��򷵻ص�����Ϣ�����򷵻�null��
	 */
	@SuppressWarnings("rawtypes")
	public Map enterStore(String userName) {
		return sDao.getStoreByUserName(userName);
	}
	
	/**
	 * ���ܣ����������ͼ��ҵ�����һ��ͼ����Ϣ
	 * @param b
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addBook(Book b) {
		boolean success = false;
		// �����жϸ����Ƿ��Ѿ�����
		if(! bDao.isExisted(b.getStoreName(), b.getBookName())) {
			// �����ڣ�ִ����Ӳ���
			if(bDao.addBook(b)) {
				// ��ӳɹ�
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * ���ܣ������Ҳ鿴����������ͼ��ҵ��
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByStoreName(String storeName, int curPage) {
		return bDao.getBookByStoreName(storeName, curPage);
	}
	
	/**
	 * ���ܣ������Ҹ�����������ͼ��ҵ��
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByNameInStore(String storeName, String bookName, int curPage) {
		return bDao.getBookByNameInStore(storeName, bookName, curPage);
	}
	
	/**
	 * ���ܣ�������ɾ��ͼ��ҵ�񣬸���ͼ������ɾ��
	 * @param bookId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteBook(int bookId) {
		return bDao.deleteBook(bookId);
	}
	
	/**
	 * ���ܣ��������޸�ͼ��ҵ����Ҫ�޸�ͼ��ļ۸�Ϳ����
	 * @param b
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateBookPrice(int bookId, int bookPrice) {
		
		return bDao.updateBookPrice(bookPrice, bookId);
	}
	
	/**
	 * ���ܣ��������޸�ͼ��ҵ����Ҫ�޸�ͼ��ļ۸�Ϳ����
	 * @param b
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateBookSumNum(int bookId, int bookSumNum) {
		return bDao.updateBookSumNum(bookSumNum, bookId);
	}
	
	/**
	 * ���ܣ������Ҳ鿴���ж���ҵ��
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻ض����б���Ϣ�����򷵻�null��
	 */
	public PageBean getOrderByStoreName(String storeName, int curPage) {
		return oDao.getOrderByStoreName(storeName, curPage);
	}
	
	/**
	 * ���ܣ������Ҹ��ݶ���״̬�鿴����ҵ��
	 * @param storeName
	 * @param orderState
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�����򷵻�null��
	 */
	public PageBean getOrderByStateInStore(String storeName, String orderState, int curPage) {
		return oDao.getOrderByStateInStore(storeName, orderState, curPage);
	}
	
	/**
	 * ���ܣ�����鿴�����ջ���ַҵ��
	 * @param orderId
	 * @return �ɹ��򷵻�һ��������Ϣ�����򷵻�null��
	 */
	@SuppressWarnings("rawtypes")
	public Map getOrderDetailById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * ���ܣ��������޸Ķ���״̬ҵ�񣬸��ݶ�������޸�
	 * @param orderId
	 * @param newOrderState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		return oDao.updateOrderState(productId, newOrderState);
	}
	
}
