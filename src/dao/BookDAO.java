package dao;

import java.util.List;

import bean.Book;
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
		String sql = "select * from tb_Book where bookClass = ? order by bookSaleNum desc ";
		String[] params = { bookClass };
		pb = db.getPageBean(sql, params, curPage);
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
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc";
		String[] params = { storeName };
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
		String sql = "select * from tb_Book where storeName = ? and bookName = ? order by bookSaleNum desc ";
		String[] params = { storeName, bookName };
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
		String sql = "select * from tb_Book where storeName = ? and bookClass = ? order by bookSaleNum desc ";
		String[] params = { storeName, bookClass };
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
		String[] params = { storeName };
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
		String[] params = { storeName };
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
	public List getBookIByLastDate() {
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
		String[] params = {
				book.getStoreName(),book.getBookISBN(),book.getBookName(),book.getBookAuthor(),
				book.getBookPublisher(),book.getBookPrice(),book.getBookSaleNum(),
				book.getBookSumNum(),book.getBookClass(),book.getBookPage(),book.getBookDescript(),
				book.getBookImage()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ�����������ɾ��ͼ��
	 * @param storeName
	 * @param bookName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteBook(String storeName, String bookName) {
		boolean success = false;
		String sql = "delete from tb_Book where storeName = ? and bookName = ? ";
		String[] params = { storeName, bookName };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ�����ͼ�����͵������޸�ͼ��ļ۸���߿����
	 * @param book
	 * @return �ɹ��򷵻���Ӱ������������򷵻�0��
	 */
	public boolean updateBook(Book book) {
		boolean success = false;
		String sql = "update tb_Book set bookPrice = ?, bookSumNum = ? where storeName = ? and bookName = ? ";
		String[] params = {
				book.getBookPrice(), book.getBookSumNum(),
				book.getStoreName(), book.getBookName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������������޸�ͼ��Ŀ��������������������Ӷ���ʱʹ��
	 * @param book
	 * @return
	 */
	public boolean updateBookByOrder(Book book) {
		boolean success = false;
		String sql = "update tb_Book set bookSaleNum = ?, bookSumNum = ? where storeName = ? and bookName = ? ";
		String[] params = {
				book.getBookSaleNum(), book.getBookSumNum(),
				book.getStoreName(), book.getBookName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
}
