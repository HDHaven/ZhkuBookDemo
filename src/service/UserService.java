package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.Cart;
import bean.Comment;
import bean.Order;
import bean.PageBean;
import bean.Product;
import bean.TempStore;
import bean.User;
import dao.BookDAO;
import dao.CartDAO;
import dao.CommentDAO;
import dao.OrderDAO;
import dao.StoreDAO;
import dao.UserDAO;

/**
 * 用户业务处理类：包括登录、注册、修改密码和地址、购物车管理、订单管理、图书查询
 * 
 * 购物车管理：	(1)查看购物车（按商品所属店铺显示）
 * 			  	(2)加入购物车（插一条商品记录进购物车表）
 * 				(3)移除购物车（从购物车移除选中记录）
 * 				(4)修改商品数量（修改购物车中商品的购买数量）
 * 
 * 订单管理：	(1)添加订单（先插入一条订单信息，再根据订单编号插入购买的商品信息列表、
 * 				   更新图书的库存量和销售量，根据店铺名更新店铺的总销售量和总销售额，删除购物车记录
 * 				(2)查看订单（根据用户名查看所有订单-->根据订单编号查看订单商品信息；根据订单状态获取订单信息-->根据订单编号获取订单详细信息）
 * 				(3)取消订单（根据订单编号修改订单状态）
 * 				(4)评价订单
 * 
 * @author 黄华冬
 *
 */
@SuppressWarnings("rawtypes")
public class UserService {
	private UserDAO uDao;
	private BookDAO bDao;
	private StoreDAO sDao;
	private CartDAO cDao;
	private OrderDAO oDao;
	private CommentDAO comDao;
	
	public UserService() {
		uDao = new UserDAO();
		bDao = new BookDAO();
		sDao = new StoreDAO();
		cDao = new CartDAO();
		oDao = new OrderDAO();
		comDao = new CommentDAO();
	}
	
	/**
	 * 功能：处理用户登录，返回用户类型
	 * @param userName
	 * @param password
	 * @return 成功则返回用户类型('1'表示普通用户，'2'表示管理员)，否则返回0。
	 */
	public int login(String userName, String password) {
		return uDao.login(userName, password);
	}
	
	/**
	 * 功能：处理用户注册
	 * @param userName
	 * @param password
	 * @return 用户名已存在则返回1，注册成功则返回2，否则返回0。
	 */
	public int register(String userName, String password) {
		int recNo = 0;
		// 判断用户名是否已经存在
		if(uDao.isExisted(userName)) {
			recNo = 1;	// 用户名已存在，注册失败
			// 执行注册操作
		} else if(uDao.register(userName, password)) {
			// 注册成功
			recNo = 2;
		}
		return recNo;
	}
	
	/**
	 * 功能：根据用户名查看用户收货地址等
	 * @param userName
	 * @return 成功则返回个人信息，否则返回null。
	 */
	public Map getAddr(String userName) {
		return uDao.getUserByName(userName);
	}
	
	/**
	 * 功能：处理用户修改密码
	 * @param u
	 * @param newPassword
	 * @return 若原密码不正确，返回0；若修改成功，返回2；若修改失败，返回1。
	 */
	public int updatePassword(User u, String newPassword) {
		int recNo = 0;
		// 首先验证原密码是否正确
		if(uDao.login(u.getUserName(),u.getPassword()) > 0) {
			// 原密码正确，执行修改密码操作
			if(uDao.updatePassword(u.getUserName(), newPassword)) {
				// 修改密码成功
				recNo = 2;
			} else {
				// 修改失败
				recNo = 1;
			}
		}
		return recNo;
	}
	
	/**
	 * 功能：处理用户修改地址业务
	 * @param u
	 * @return 修改成功则返回true，否则返回false。
	 */
	public boolean updateAddr(User u) {
		return uDao.updateAddr(u);
	}
	
	/**
	 * 功能：处理用户进入店铺显示店铺信息
	 * @param storeName
	 * @return 成功则返回一条店铺信息，否则返回null。
	 */
	public Map enterStore(String storeName) {
		return sDao.getStoreByName(storeName);
	}
	
	/**
	 * 功能：处理用户根据图书名称在查询图书
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByName(String storeName, String bookName, int curPage) {
		if(storeName == null) {
			// 如果店铺名为空，全局搜索
			return bDao.getBookByName(bookName, curPage);
		} else {
			// 否则在店铺内搜索
			return bDao.getBookByNameInStore(storeName, bookName, curPage);
		}
	}
	
	/**
	 * 功能：处理用户根据图书类别在查询图书
	 * @param bookClass
	 * @param curPage
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public PageBean getBookByClass(String storeName, String bookClass, int curPage) {
		if(storeName == null) {
			// 店铺名为空，全局搜索
			return bDao.getBookByClass(bookClass, curPage);
		} else {
			// 否则，在店铺内搜索
			return bDao.getBookByClassInStore(storeName, bookClass, curPage);
		}
	}
	
	/**
	 * 功能：用户进入店铺时执行，显示店铺内最新上传的4本书
	 * @param storeName
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public List getBookByLastDate(String storeName) {
		if(storeName == null) {
			// 如果店铺名为空，全局获取
			return bDao.getBookByLastDate();
		}
		return bDao.getBookByLastDateInStore(storeName);
	}
	
	/**
	 * 功能：用户进入店铺时执行，显示店铺内销量最好的4本书
	 * @param storeName
	 * @return 成功则返回图书信息列表，否则返回null。
	 */
	public List getBookByHotSale(String storeName) {
		if(storeName == null) {
			// 如果店铺名为空，全局获取
			return bDao.getBookByHotSale();
		}
		return bDao.getBookByHotSaleInStore(storeName);
	}
	
	/**
	 * 功能：处理用户申请开店铺
	 * @param ts
	 * @return 若店铺名已存在则返回1，若申请成功返回2，否则返回0；
	 */
	public int addStore(TempStore ts) {
		int recNo = 0;
		// 首先判断店铺是否已经存在
		if(sDao.isExisted(ts.getTempStoreName()) && sDao.isExistInStore(ts.getTempStoreName())) {
			// 店铺名已存在
			recNo = 1;
		} else if(sDao.addTempStore(ts)) {
			// 添加进入临时店铺表
			recNo = 2;
		}
		return recNo;
	}
	
	/**
	 * 功能：处理用户添加商品进购物操作
	 * @param c
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addBookInCart(Cart c) {
		boolean success = false;
		// 首先判断购物车是否已存在该件商品
		if(cDao.isExisted(c.getUserName(), c.getStoreName(), c.getBookName())) {
			// 购物车中已存在，不做任何操作返回true
			success = true;
		} else if(cDao.addBookInCart(c)) { // 不存在，执行添加操作
			// 添加成功
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：处理用户修改购物车的图书数量
	 * @param cartId
	 * @param bookNumber
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateCart(int cartId, int bookNumber) {
		return cDao.updateCart(cartId, bookNumber);
	}
	
	/**
	 * 功能：处理用户删除购物车中的图书
	 * @param cartId
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteFromCart(int cartId) {
		return cDao.deleteFromCart(cartId);
	}
	
	/**
	 * 功能：处理用户查看购物车功能，返回的数据结构是Map<String,List<Map<String,String>>>
	 * @param userName
	 * @return 成功则返回购物车商品列表信息，否则返回null；
	 */
	@SuppressWarnings("unchecked")
	public Map getCartByUserName(String userName) {
		Map m = null;
		// (1)根据用户名查找用户的购物车中包含了几家店铺的商品
		List list = cDao.getStoreNameInCart(userName); 
		if(list != null && !list.isEmpty()) {	// 购物车中有商品
			m = new HashMap();
			// (2)根据用户名和店铺名获取购物车中商品信息列表
			for(int i = 0; i < list.size(); i++) {
				Map mm = (Map) list.get(i);
				List cartList = cDao.getBookByStoreName(userName, (String) mm.get("storeName"));
				m.put((String)mm.get("storeName"), cartList);
			}
		}
		return m;
	}
	
	/**
	 * 功能：处理用户修改订单状态，取消订单业务。
	 * @param orderId
	 * @param newOrderState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateOrderState(int productId, String newOrderState) {
		return oDao.updateOrderState(productId, newOrderState);
	}
	
	/**
	 * 功能：添加订单业务处理，下单成功，修改对应图书的库存量和销售量以及对应店铺的总销售量
	 *       下单数据来源于购物车，删除购物车中的商品信息
	 * @param o
	 * @param cartList 从购物车中获取被选中的商品，Cart对象
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addOrder(Order o, List cartList) {
		boolean success = false;
		// 首先添加订单信息
		if(oDao.addOrder(o)) {
			// 添加成功，获取订单编号
			Map m = oDao.getOrderId(o.getUserName(), o.getOrderDate());
			int orderId = (int) m.get("orderId");
			String userName = o.getUserName();
			String orderState = "待处理";
			for (Object obj : cartList) {
				Cart c = (Cart) obj;
				Product p = new Product(0, orderId, userName, c.getStoreName(), 
						c.getBookName(), c.getBookPrice(), c.getBookNumber(), c.getBookImage(), orderState);
				if(! oDao.addProduct(p)) // 添加订单对应商品列表失败，直接返回false。
					return false;
				// 添加订单对应商品列表成功，修改对应图书的销售量和库存量以及对应店铺的销售额和销售量，
				if(bDao.updateBookByOrder(c) && sDao.updateStore(c.getStoreName(), c.getBookNumber(), c.getBookPrice())) {
					// 下单成功，从购物车中删除已购买的商品
					cDao.deleteFromCart(c.getCartId());
					success = true;
				}
			}
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：处理用户查看订单包含的商品信息列表业务
	 * @param orderId
	 * @return 成功则返回该订单编号所属的商品信息，否则返回null。
	 */
	public List getOrderProductById(int orderId) {
		return oDao.getOrderProductById(orderId);
	}
	
	/**
	 * 功能：处理用户根据状态查看订单的业务
	 * @param userName
	 * @param curPage
	 * @return 成功则返回订单信息列表，否则返回null。
	 */
	public PageBean getOrder(String userName, String orderState, int curPage) {
		if(orderState == null) {
			// 如果订单状态为空，获取所有订单
			return oDao.getOrderByUserName(userName, curPage);
		}
		return oDao.getOrderByStateInUser(userName, orderState, curPage);
	}
	
	/**
	 * 功能：处理用户查看订单详细信息的业务
	 * @param orderId
	 * @return 成功则返回一条订单信息，否则返回null。
	 */
	public Map getOrderById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * 功能：处理用户评论图书，同时对对应的店铺评价进行修改
	 * @param c
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addComment(Comment c) {
		boolean success = false;
		// 添加评论，同时修改店铺评分
		if(comDao.addComment(c) && sDao.updateStoreEvaluate(c)) {
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：处理用户查看图书详细信息时，显示该图书的评论信息。
	 * @param storeName
	 * @param bookName
	 * @param curPage
	 * @return 成功则返回评论信息列表，否则返回null。
	 */
	public PageBean getBookComment(String storeName, String bookName, int curPage) {
		return comDao.getComment(storeName, bookName, curPage);
	}
	
	/**
	 * 功能：处理用户查看图书详细信息业务
	 * @param bookId
	 * @return 成功则返回图书详情，否则返回null。
	 */
	public Map getBookById(int bookId) {
		return bDao.getBookById(bookId);
	}
	
	/**
	 * 功能：判断用户是否为店家
	 * @param userName
	 * @return 是则返回true，否则返回false。
	 */
	public boolean isManager(String userName) {
		boolean success = false;
		if(sDao.getStoreByUserName(userName) != null) {
			// 是店家
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：获取用户从购物中选中的商品
	 * @param userName
	 * @param request
	 * @return 成功则返回商品列表，否则返回null。
	 */
	@SuppressWarnings("unchecked")
	public List getProdcutList(String userName, HttpServletRequest request) {
		List productList = new ArrayList();
		// (1)获取用户购物车列表
		List cartList = cDao.getCartByUserName(userName);
		if(cartList != null && cartList.size() > 0) {
			// 购物车不为空，遍历，获取用户选中的商品，添加
			for (Object obj : cartList) {
				Map m = (Map) obj;
				int cartId = (int) m.get("cartId");
				if(request.getParameter(""+ cartId).equals("true")) {
					// (2)该商品被选中
					Cart c = new Cart();
					c.setCartId(cartId);
					c.setBookImage((String) m.get("bookImage"));
					c.setBookName((String) m.get("bookName"));
					c.setBookNumber((int) m.get("bookNumber"));
					c.setBookPrice((int) m.get("bookPrice"));
					c.setStoreName((String) m.get("storeName"));
					c.setUserName((String) m.get("userName"));
					productList.add(c);
				}
			}
		}
		return productList;	// 返回商品列表信息
	}
	
	public Map getABook(String storeName, String bookName) {
		return bDao.getABook(storeName, bookName);
	}
	
}
