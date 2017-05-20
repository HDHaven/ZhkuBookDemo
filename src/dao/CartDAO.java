package dao;

import java.util.List;
import java.util.Map;

import bean.Book;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class CartDAO {
	/**
	 * 用户购物车数据访问层
	 */
	private DBUtil db;
	
	public CartDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：根据用户名获取购物车商品所属店铺名列表
	 * @param userName
	 * @return 成功则返回店铺名集合，否则返回空
	 */
	public List getStoreNameInCart(String userName) {
		List list = null;
		String sql = "select storeName from tb_Cart where userName = ? ";
		String[] params = { userName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * 功能：根据用户名和店铺名获取商品信息列表
	 * @param userName
	 * @param storeName
	 * @return 成功则返回商品信息列表，否则返回false。
	 */
	public List getBookByStoreName(String userName, String storeName) {
		List list = null;
		String sql = "select * from tb_Cart where userName = ? and storeName = ? ";
		String[] params = { userName, storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * 功能：往购物车中添加一条记录
	 * @param b
	 * @param userName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addBookInCart(Book b, String userName, String bookNumber) {
		boolean success = false;
		String sql = "insert into tb_Cart values(null, ?, ?, ?, ?, ?) ";
		String[] params = { userName, b.getStoreName(), b.getBookName(), b.getBookPrice(), bookNumber };
		if(db.update(sql, params) > 0)
			success = true;	// 添加成功
		return success;
	}
	
	/**
	 * 功能：根据店铺名和书名移除购物车中的商品
	 * @param storeName
	 * @param bookName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteFromCart(String storeName, String bookName) {
		boolean success = false;
		String sql = "delete from tb_Cart where storeName = ? and bookName = ? ";
		String[] params = { storeName, bookName };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：根据购物车编号删除购物车中的商品
	 * @param cartId
	 * @param bookNumber
	 * @return
	 */
	public boolean updateCart(String storeName, String userName, String bookNumber) {
		boolean success = false;
		String sql = "update tb_Cart set bookNumber = ? where storeName = ? and userName = ? ";
		String[] params = { bookNumber, storeName, userName };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据用户名、店铺名和书名判断购物车表中是否已经存在该条记录
	 * @param userName
	 * @param storeName
	 * @param bookName
	 * @return 成功则返回对应图书的购买吗数量，否则返回null。
	 */
	public String isExisted(String userName, String storeName, String bookName) {
		String bookNumber = null; 
		String sql = "select bookNumber from tb_Cart where userName = ? and storeName = ? and bookName = ? ";
		String[] params = { userName, storeName, bookName };
		Map m = db.getMap(sql, params);
		if(m != null) {	// 购物车已存在
			bookNumber = (String) m.get("bookNumber");
		}
		return bookNumber;
	}
	
}
