package service;

import java.util.List;
import java.util.Map;

import bean.PageBean;
import bean.TempStore;
import dao.OrderDAO;
import dao.StoreDAO;
import dao.UserDAO;

/**
 * 用户管理员管理用户以及店铺。
 * 
 * 用户管理:	(1)查看所有用户基本信息
 *         	(2)根据用户名查看用户订单信息，进一步根据订单编号查看包含的商品信息
 *         	(3)根据用户名删除用户
 *         
 * 店铺管理:	(1)获取临时店铺表的信息，将通过审核的店铺添加到店铺表中，然后将其从临时店铺表中删除
 *          (2)根据店铺名删除店铺信息
 *          (3)根据店铺名修改店铺状态
 *          (4)查看所有店铺信息，根据店铺名查看店铺订单信息
 * 
 * @author 范振东
 *
 */
public class AdminService {
	
	private UserDAO uDao;
	private OrderDAO oDao;
	private StoreDAO sDao;
	
	public AdminService() {
		uDao = new UserDAO();
		oDao = new OrderDAO();
		sDao = new StoreDAO();
	}
	
	/**
	 * 功能：处理管理员查看用户基本信息业务
	 * @param curPage
	 * @return 成功则返回用户信息列表，否则返回null。
	 */
	public PageBean getAllUserInfo(int curPage) {
		return uDao.getAllUser(curPage);
	}
	
	/**
	 * 功能：处理管理员查看用户消费记录
	 * @param userName
	 * @param curPage
	 * @return 成功则返回订单信息，否则返回null。
	 */
	public PageBean getOrderByUserName(String userName, int curPage) {
		return oDao.getOrderByUserName(userName, curPage);
	}
	
	/**
	 * 功能：处理管理员查看订单商品列表
	 * @param orderId
	 * @return 成功则返回商品列表信息，否则返回null。
	 */
	@SuppressWarnings("rawtypes")
	public List getOrderProductById(int orderId) {
		return oDao.getOrderProductById(orderId);
	}
	
	/**
	 * 功能：处理管理员删除用户业务。
	 * @param userName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteUserByName(String userName) {
		return uDao.deleteUserByName(userName);
	}
	
	/**
	 * 功能：处理管理员查看店铺信息业务
	 * @param curPage
	 * @return 成功则返回店铺信息列表，否则返回null。
	 */
	public PageBean getAllStoreInfo(int curPage) {
		return sDao.getAllStore(curPage);
	}
	
	/**
	 * 动能：处理管理员获取临时店铺表业务，添加店铺前的操作
	 * @param curPage
	 * @return 成功则返回临时店铺信息列表，否则返回null。
	 */
	public PageBean getStoreInfoInTempStore(int curPage) {
		return sDao.getStoreFromTempStore(curPage);
	}
	
	/**
	 * 功能：处理管理员添加店铺业务，添加前判断店铺是否已经存在，
	 * 		添加成功则删除临时店铺表中的店铺
	 * @param ts
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addStore(TempStore ts) {
		boolean success = false;
		if(! sDao.isExistInStore(ts.getTempStoreName())) {
			// 不存在该店铺，则添加
			if(sDao.addStore(ts) && sDao.deleteFromTempStore(ts.getTempStoreId())) {
				// 添加成功
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * 功能：处理管理员查看店铺订单业务
	 * @param storeName
	 * @param curPage
	 * @return 成功则返回店铺订单信息，否则返回null。
	 */
	public PageBean getOrderInfoByStoreName(String storeName, int curPage) {
		return oDao.getOrderByStoreName(storeName, curPage);
	}
	
	/**
	 * 功能：处理管理员查看店铺订单收货信息
	 * @param orderId
	 * @return 成功则返回一条订单信息，否则返回null。
	 */
	@SuppressWarnings("rawtypes")
	public Map getOrderDetailById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * 功能：处理管理员删除店铺业务
	 * @param storeName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteStore(String storeName) {
		return sDao.deleteStore(storeName);
	}
	
	/**
	 * 功能：处理管理员修改店铺状态业务
	 * @param storeName
	 * @param newStoreState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean udpateStoreState(String storeName, String newStoreState) {
		return sDao.updateStoreState(storeName, newStoreState);
	}
	
	/**
	 * 功能：处理管理员删除临时店铺信息
	 * @param tempStoreId
	 * @return
	 */
	public boolean deleteTempStoreById(int tempStoreId) {
		return sDao.deleteFromTempStore(tempStoreId);
	}
	
	/**
	 * 功能：根据店铺名获取店铺信息
	 * @param storeName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getStoreByName(String storeName) {
		return sDao.getStoreByName(storeName);
	}
	
	
}