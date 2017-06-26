package dao;

import java.util.List;
import java.util.Map;

import bean.Cart;
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
		Object[] params = { userName };
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
		Object[] params = { userName, storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * 功能：往购物车中添加一条记录
	 * @param c
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addBookInCart(Cart c) {
		boolean success = false;
		String sql = "insert into tb_Cart values(null, ?, ?, ?, ?, ?, ?) ";
		Object[] params = { c.getUserName(), c.getStoreName(), c.getBookName(), 
				c.getBookPrice(), c.getBookNumber(), c.getBookImage() };
		if(db.update(sql, params) > 0)
			success = true;	// 添加成功
		return success;
	}
	
	/**
	 * 功能：根据店铺名、书名以及用户名移除购物车中的商品
	 * @param storeName
	 * @param bookName
	 * @param userName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteFromCart(int cartId) {
		boolean success = false;
		String sql = "delete from tb_Cart where cartId = ? ";
		Object[] params = { cartId };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：根据购物车编号修改购物车中对应图书的数量
	 * @param cartId
	 * @param bookNumber
	 * @return
	 */
	public boolean updateCart(int cartId, int bookNumber) {
		boolean success = false;
		String sql = "update tb_Cart set bookNumber = ? where cartId = ? ";
		Object[] params = { bookNumber, cartId };
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
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean isExisted(String userName, String storeName, String bookName) {
		boolean exist = false; 
		String sql = "select * from tb_Cart where userName = ? and storeName = ? and bookName = ? ";
		Object[] params = { userName, storeName, bookName };
		Map m = db.getMap(sql, params);
		if(m != null) {	// 购物车已存在该书
			exist = true;
		}
		return exist;
	}
	
	/**
	 * 功能：根据用户名返回购物车信息
	 * @param userName
	 * @return 成功则返回购物车信息，否则返回null。
	 */
	public List getCartByUserName(String userName) {
		List list = null;
		String sql = "select * from tb_Cart where userName = ?";
		Object[] params = { userName };
		list = db.getList(sql, params);
		return list;
	}
	
}
