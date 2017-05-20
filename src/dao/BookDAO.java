package dao;

import java.util.List;

import bean.Book;
import bean.PageBean;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class BookDAO {
	/**
	 * 图书数据访问层
	 */
	private DBUtil db;
	
	public BookDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：根据图书名称获取图书信息，分页显示，按照销量从高到低排序
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByName(String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where bookName=? order by bookSaleNum desc ";
		String[] params = { bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据图书类别获取图书信息，分页显示，按照销量从高到低排序
	 * @param bookClass
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByClass(String bookClass, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where bookClass = ? order by bookSaleNum desc ";
		String[] params = { bookClass };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据图书所属店铺返回图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByStore(String storeName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc";
		String[] params = { storeName };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：在店铺内根据图书名称获取图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByNameInStore(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? and bookName = ? order by bookSaleNum desc ";
		String[] params = { storeName, bookName };
		pb = db.getPageBean(sql, params, curPage);
		return pb; 
	}
	
	/**
	 * 功能：在店铺内根据图书类别获取图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param bookClass
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByClassInStore(String storeName, String bookClass, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? and bookClass = ? order by bookSaleNum desc ";
		String[] params = { storeName, bookClass };
		pb = db.getPageBean(sql, params, curPage);
		return pb; 
	}
	
	/**
	 * 功能：根据店铺名获取该店铺内最新上传的4本图书信息
	 * @param storeName
	 * @return 成功则返回最新上传的4本图书信息，否则返回null。
	 */
	public List getBookByLastDateInStore(String storeName) {
		List list = null;
		String sql = "select * from tb_Book where storeName = ? order by bookId desc limit 0,4 ";
		String[] params = { storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * 功能：根据店铺名获取该店铺内销量最好的4本图书信息
	 * @param storeName
	 * @return 成功则返回店铺内销量的4本图书信息，否则返回null。
	 */
	public List getBookByHotSaleInStore(String storeName) {
		List list = null;
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc limit 0,4 ";
		String[] params = { storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * 功能：获取图书表销量最好的4本图书信息
	 * @return 成功则返回图书表中销量最好的4本图书信息，否则返回null。
	 */
	public List getBookByHotSale() {
		List list = null;
		String sql = "select * from tb_Book order by bookSaleNum desc limit 0,4 ";
		list = db.getList(sql, null);
		return list;
	}
	
	/**
	 * 功能：获取图书表中最新上传的4本图书信息
	 * @return 成功则返回图书表中最新上传的4本图书信息，否则返回null。
	 */
	public List getBookIByLastDate() {
		List list = null;
		String sql = "select * from tb_Book order by bookId desc limit 0,4 ";
		list = db.getList(sql, null);
		return list;
	}
	
	/**
	 * 功能：往数据库中添加一本书
	 * @param book
	 * @return 成功则返回true，否则返回false。
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
			success = true;	// 添加成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名和书名删除图书
	 * @param storeName
	 * @param bookName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteBook(String storeName, String bookName) {
		boolean success = false;
		String sql = "delete from tb_Book where storeName = ? and bookName = ? ";
		String[] params = { storeName, bookName };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：根据图书名和店铺名修改图书的价格或者库存量
	 * @param book
	 * @return 成功则返回受影响的行数，否则返回0。
	 */
	public boolean updateBook(Book book) {
		boolean success = false;
		String sql = "update tb_Book set bookPrice = ?, bookSumNum = ? where storeName = ? and bookName = ? ";
		String[] params = {
				book.getBookPrice(), book.getBookSumNum(),
				book.getStoreName(), book.getBookName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名和书名修改图书的库存量和销售量，用于添加订单时使用
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
			success = true;	// 修改成功
		}
		return success;
	}
	
}
