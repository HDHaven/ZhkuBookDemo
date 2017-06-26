package service;

import java.util.Map;

import bean.Book;
import bean.PageBean;
import dao.BookDAO;
import dao.OrderDAO;
import dao.StoreDAO;

/**
 * 店家业务处理：包括图书管理、订单管理以及申请开店。
 * 
 * 图书管理:	(1)获取店铺内所有图书信息，根据图书名获取店铺内图书信息
 * 			(2)添加一本图书，添加前判断该图书是否存在
 * 			(3)修改图书的价格或者库存量
 * 			(4)删除一本图书
 * 
 * 订单管理:	(1)获取店铺内所有订单信息，根据订单状态获取订单信息，查看订单收货地址
 * 			(2)修改订单状态
 * 
 * @author 丘练
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
	 * 功能：处理店家进入店铺时业务，获取一条店铺信息
	 * @param userName
	 * @return 成功则返回店铺信息，否则返回null。
	 */
	@SuppressWarnings("rawtypes")
	public Map enterStore(String userName) {
		return sDao.getStoreByUserName(userName);
	}
	
	/**
	 * 功能：处理店家添加图书业务，添加一条图书信息
	 * @param b
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addBook(Book b) {
		boolean success = false;
		// 首先判断该书是否已经存在
		if(! bDao.isExisted(b.getStoreName(), b.getBookName())) {
			// 不存在，执行添加操作
			if(bDao.addBook(b)) {
				// 添加成功
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * 功能：处理店家查看店铺内所有图书业务
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByStoreName(String storeName, int curPage) {
		return bDao.getBookByStoreName(storeName, curPage);
	}
	
	/**
	 * 功能：处理店家根据书名搜索图书业务。
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByNameInStore(String storeName, String bookName, int curPage) {
		return bDao.getBookByNameInStore(storeName, bookName, curPage);
	}
	
	/**
	 * 功能：处理店家删除图书业务，根据图书百年好删除
	 * @param bookId
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteBook(int bookId) {
		return bDao.deleteBook(bookId);
	}
	
	/**
	 * 功能：处理店家修改图书业务，主要修改图书的价格和库存量
	 * @param b
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateBookPrice(int bookId, int bookPrice) {
		
		return bDao.updateBookPrice(bookPrice, bookId);
	}
	
	/**
	 * 功能：处理店家修改图书业务，主要修改图书的价格和库存量
	 * @param b
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateBookSumNum(int bookId, int bookSumNum) {
		return bDao.updateBookSumNum(bookSumNum, bookId);
	}
	
	/**
	 * 功能：处理店家查看所有订单业务
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回订单列表信息，否则返回null。
	 */
	public PageBean getOrderByStoreName(String storeName, int curPage) {
		return oDao.getOrderByStoreName(storeName, curPage);
	}
	
	/**
	 * 功能：处理店家根据订单状态查看订单业务
	 * @param storeName
	 * @param orderState
	 * @param curPage
	 * @return 成功则返回订单信息，否则返回null。
	 */
	public PageBean getOrderByStateInStore(String storeName, String orderState, int curPage) {
		return oDao.getOrderByStateInStore(storeName, orderState, curPage);
	}
	
	/**
	 * 功能：处理查看订单收货地址业务
	 * @param orderId
	 * @return 成功则返回一条订单信息，否则返回null。
	 */
	@SuppressWarnings("rawtypes")
	public Map getOrderDetailById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * 功能：处理店家修改订单状态业务，根据订单编号修改
	 * @param orderId
	 * @param newOrderState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		return oDao.updateOrderState(productId, newOrderState);
	}
	
}
