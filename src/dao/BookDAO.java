package dao;

import java.util.List;

import bean.Book;
import bean.PageBean;
import util.DBUtil;

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
		
		return pb;
	}
	
	/**
	 * 功能：在店铺内根据图书名称获取图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookInStoreByName(String storeName, String bookName, int curPage) {
		PageBean pb = null;
		
		return pb; 
	}
	
	/**
	 * 功能：在店铺内根据图书类别获取图书信息，分页显示，按照销量从高到低排序
	 * @param storeName
	 * @param bookClass
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookInStoreByClass(String storeName, String bookClass, int curPage) {
		PageBean pb = null;
		
		return pb; 
	}
	
	/**
	 * 功能：根据店铺名获取该店铺内最新上传的4本图书信息
	 * @param storeName
	 * @return 成功则返回最新上传的4本图书信息，否则返回null。
	 */
	public List<Book> getBookByLastDate(String storeName) {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * 功能：根据店铺名获取该店铺内销量最好的4本图书信息
	 * @param storeName
	 * @return 成功则返回店铺内销量的4本图书信息，否则返回null。
	 */
	public List<Book> getBookByHotSale(String storeName) {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * 功能：获取图书表销量最好的4本图书信息
	 * @return 成功则返回图书表中销量最好的4本图书信息，否则返回null。
	 */
	public List<Book> getBookInHotSale() {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * 功能：获取图书表中最新上传的4本图书信息
	 * @return 成功则返回图书表中最新上传的4本图书信息，否则返回null。
	 */
	public List<Book> getBookInLastDate() {
		List<Book> list = null;
		
		return list;
	}
	
	/**
	 * 功能：往数据库中添加一本书
	 * @param book
	 * @return 成功则返回受影响的行数，否则返回0。
	 */
	public int addBook(Book book) {
		int recNo = 0;
		
		return recNo;
	}
	
	/**
	 * 功能：根据图书编号
	 * @param bookId
	 * @return 成功则返回受影响的行数，否则返回0。
	 */
	public int deleteBook(int bookId) {
		int recNo = 0;
		
		return recNo;
	}
	
	/**
	 * 功能：根据图书编号修改图书的价格或者库存量
	 * @param book
	 * @return 成功则返回受影响的行数，否则返回0。
	 */
	public int updateBook(Book book) {
		int recNo = 0;
		
		return recNo;
	}
	
}
