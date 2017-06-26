package dao;

import java.util.List;
import java.util.Map;

import bean.Book;
import bean.Cart;
import bean.PageBean;
import util.DBUtil;

@SuppressWarnings("rawtypes")
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
		String sql = "select * from tb_Book where bookName like ? order by bookSaleNum desc ";
		bookName = "%"+ bookName +"%";
		Object[] params = { bookName };
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
		String sql = "select * from tb_Book where bookClass like ? order by bookSaleNum desc ";
		bookClass = "%"+ bookClass +"%";
		Object[] params = { bookClass };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ�����ͼ���������̷���ͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByStoreName(String storeName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc";
		Object[] params = { storeName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ��ڵ����ڸ���ͼ�����ƻ�ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByNameInStore(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? and bookName like ? order by bookSaleNum desc ";
		bookName = "%"+ bookName +"%";
		Object[] params = { storeName, bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb; 
	}
	
	/**
	 * ���ܣ��ڵ����ڸ���ͼ������ȡͼ����Ϣ����ҳ��ʾ�����������Ӹߵ�������
	 * @param storeName
	 * @param bookClass
	 * @param curPage
	 * @return �ɹ��򷵻�ͼ����Ϣ�б����򷵻�null��
	 */
	public PageBean getBookByClassInStore(String storeName, String bookClass, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? and bookClass like ? order by bookSaleNum desc ";
		bookClass = "%"+ bookClass +"%";
		Object[] params = { storeName, bookClass };
		pb = db.getPageBean(sql, params, curPage);
		return pb; 
	}
	
	/**
	 * ���ܣ����ݵ�������ȡ�õ����������ϴ���4��ͼ����Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻������ϴ���4��ͼ����Ϣ�����򷵻�null��
	 */
	public List getBookByLastDateInStore(String storeName) {
		List list = null;
		String sql = "select * from tb_Book where storeName = ? order by bookId desc limit 0,4 ";
		Object[] params = { storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ����ݵ�������ȡ�õ�����������õ�4��ͼ����Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻ص�����������4��ͼ����Ϣ�����򷵻�null��
	 */
	public List getBookByHotSaleInStore(String storeName) {
		List list = null;
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc limit 0,4 ";
		Object[] params = { storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ���ȡͼ���������õ�4��ͼ����Ϣ
	 * @return �ɹ��򷵻�ͼ�����������õ�4��ͼ����Ϣ�����򷵻�null��
	 */
	public List getBookByHotSale() {
		List list = null;
		String sql = "select * from tb_Book order by bookSaleNum desc limit 0,4 ";
		list = db.getList(sql, null);
		return list;
	}
	
	/**
	 * ���ܣ���ȡͼ����������ϴ���4��ͼ����Ϣ
	 * @return �ɹ��򷵻�ͼ����������ϴ���4��ͼ����Ϣ�����򷵻�null��
	 */
	public List getBookByLastDate() {
		List list = null;
		String sql = "select * from tb_Book order by bookId desc limit 0,4 ";
		list = db.getList(sql, null);
		return list;
	}
	
	/**
	 * ���ܣ������ݿ������һ����
	 * @param book
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addBook(Book book) {
		boolean success = false;
		String sql = "insert into tb_Book values(null,?,?,?,?,?,?,?,?,?,?,?,?) ";
		Object[] params = {
				book.getStoreName(),book.getBookISBN(),book.getBookName(),book.getBookAuthor(),
				book.getBookPublisher(),book.getBookPrice(),0,
				book.getBookSumNum(),book.getBookClass(),book.getBookPage(),book.getBookDescript(),
				book.getBookImage()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ�����ͼ����ɾ��ͼ��
	 * @param bookId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteBook(int bookId) {
		boolean success = false;
		String sql = "delete from tb_Book where bookId = ? ";
		Object[] params = { bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ�����ͼ�����޸�ͼ��ļ۸�
	 * @param bookPrice
	 * @param bookId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateBookPrice(int bookPrice, int bookId) {
		boolean success = false;
		// �޸ļ۸�
		String sql = "update tb_Book set bookPrice = ? where bookId = ? ";
		Object[] params = { bookPrice, bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ�����ͼ�����޸�ͼ��Ŀ����
	 * @param bookSumNum
	 * @param bookId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateBookSumNum(int bookSumNum, int bookId) {
		boolean success = false;
		// �޸ļ۸�
		String sql = "update tb_Book set bookSumNum = ? where bookId = ? ";
		Object[] params = { bookSumNum, bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������������޸�ͼ��Ŀ��������������������Ӷ���ʱʹ��
	 * @param book
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateBookByOrder(Cart c) {
		boolean success = false;
		String sql = "update tb_Book set bookSaleNum = bookSaleNum+?, bookSumNum = bookSumNum-? where storeName = ? and bookName = ? ";
		Object[] params = {
				c.getBookNumber(), c.getBookNumber(), c.getStoreName(), c.getBookName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ��������ͼ��ʱ�жϸ�ͼ���Ƿ��Ѿ�����
	 * @param storeName
	 * @param bookName
	 * @return �����򷵻�true�����򷵻�false��
	 */
	public boolean isExisted(String storeName, String bookName) {
		boolean exist = false;
		String sql = "select * from tb_Book where storeName = ? and bookName = ? ";
		Object[] params = { storeName, bookName };
		if(db.getMap(sql, params) != null) {
			// ��ͼ���Ѵ���
			exist = true;
		}
		return exist;
	}
	
	/**
	 * ���ܣ�����ͼ���Ż�ȡͼ����Ϣ
	 * @param bookId
	 * @return �ɹ��򷵻�ͼ����Ϣ�����򷵻�null��
	 */
	public Map getBookById(int bookId) {
		Map m = null;
		String sql = "select * from tb_Book where bookId = ?";
		Object[] params = { bookId };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * ���ܣ�����ͼ�����ƺ͵�������ȡͼ����Ϣ
	 * @param storeName
	 * @param bookName
	 * @return
	 */
	public Map getABook(String storeName, String bookName) {
		Map m = null;
		String sql = "select * from tb_Book where storeName = ? and bookName = ?";
		Object[] params = { storeName, bookName };
		m = db.getMap(sql, params);
		return m;
	}
	
	
}
