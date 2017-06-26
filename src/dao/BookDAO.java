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
		String sql = "select * from tb_Book where bookName like ? order by bookSaleNum desc ";
		bookName = "%"+ bookName +"%";
		Object[] params = { bookName };
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
		String sql = "select * from tb_Book where bookClass like ? order by bookSaleNum desc ";
		bookClass = "%"+ bookClass +"%";
		Object[] params = { bookClass };
		pb = db.getPageBean(sql, params, curPage);
		return pb;
	}
	
	/**
	 * 功能：根据图书所属店铺返回图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByStoreName(String storeName, int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Book where storeName = ? order by bookSaleNum desc";
		Object[] params = { storeName };
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
		String sql = "select * from tb_Book where storeName = ? and bookName like ? order by bookSaleNum desc ";
		bookName = "%"+ bookName +"%";
		Object[] params = { storeName, bookName };
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
		String sql = "select * from tb_Book where storeName = ? and bookClass like ? order by bookSaleNum desc ";
		bookClass = "%"+ bookClass +"%";
		Object[] params = { storeName, bookClass };
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
		Object[] params = { storeName };
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
		Object[] params = { storeName };
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
	public List getBookByLastDate() {
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
		Object[] params = {
				book.getStoreName(),book.getBookISBN(),book.getBookName(),book.getBookAuthor(),
				book.getBookPublisher(),book.getBookPrice(),0,
				book.getBookSumNum(),book.getBookClass(),book.getBookPage(),book.getBookDescript(),
				book.getBookImage()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// 添加成功
		}
		return success;
	}
	
	/**
	 * 功能：根据图书编号删除图书
	 * @param bookId
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteBook(int bookId) {
		boolean success = false;
		String sql = "delete from tb_Book where bookId = ? ";
		Object[] params = { bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：根据图书编号修改图书的价格
	 * @param bookPrice
	 * @param bookId
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateBookPrice(int bookPrice, int bookId) {
		boolean success = false;
		// 修改价格
		String sql = "update tb_Book set bookPrice = ? where bookId = ? ";
		Object[] params = { bookPrice, bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据图书编号修改图书的库存量
	 * @param bookSumNum
	 * @param bookId
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateBookSumNum(int bookSumNum, int bookId) {
		boolean success = false;
		// 修改价格
		String sql = "update tb_Book set bookSumNum = ? where bookId = ? ";
		Object[] params = { bookSumNum, bookId };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名和书名修改图书的库存量和销售量，用于添加订单时使用
	 * @param book
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateBookByOrder(Cart c) {
		boolean success = false;
		String sql = "update tb_Book set bookSaleNum = bookSaleNum+?, bookSumNum = bookSumNum-? where storeName = ? and bookName = ? ";
		Object[] params = {
				c.getBookNumber(), c.getBookNumber(), c.getStoreName(), c.getBookName()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：用于添加图书时判断该图书是否已经存在
	 * @param storeName
	 * @param bookName
	 * @return 存在则返回true，否则返回false。
	 */
	public boolean isExisted(String storeName, String bookName) {
		boolean exist = false;
		String sql = "select * from tb_Book where storeName = ? and bookName = ? ";
		Object[] params = { storeName, bookName };
		if(db.getMap(sql, params) != null) {
			// 该图书已存在
			exist = true;
		}
		return exist;
	}
	
	/**
	 * 功能：根据图书编号获取图书信息
	 * @param bookId
	 * @return 成功则返回图书信息，否则返回null。
	 */
	public Map getBookById(int bookId) {
		Map m = null;
		String sql = "select * from tb_Book where bookId = ?";
		Object[] params = { bookId };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * 功能：根据图书名称和店铺名获取图书信息
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
