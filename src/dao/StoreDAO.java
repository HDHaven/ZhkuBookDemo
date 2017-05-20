package dao;

import java.util.Map;

import bean.PageBean;
import bean.Store;
import bean.TempStore;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class StoreDAO {
	/**
	 * 店铺数据访问层
	 */
	private DBUtil db;
	
	public StoreDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：用于申请开店铺，往临时店铺中添加一条记录
	 * @param ts
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addTempStore(TempStore ts) {
		boolean success = false;
		String sql = "insert into tb_TempStore values(?,?,?,?);";
		String[] params = { ts.getTempStoreName(), ts.getUserName(), ts.getTempStoreDescript(), ts.getTempStoreLicense() };
		if(db.update(sql, params) > 0) {
			// 添加成功
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名删除临时店铺表的一条记录
	 * @param storeName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteFromTempStore(String tempStoreName) {
		boolean success = false;
		String sql = "delete from tb_Store where tempStoreName = ?";
		String[] params = { tempStoreName };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：用于管理员获取临时店铺表的所有店铺信息，分页显示
	 * @param curPage	当前页
	 * @return 成功则返回店铺信息列表，否则返回null。
	 */
	public PageBean getStoreFromTempStore(int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_TempStore ";
		pb = db.getPageBean(sql, null, curPage);
		return pb;
	}
	
	/**
	 * 功能：用于判断临时店铺表中是否存在该店铺名的店铺信息，插入前判断
	 * @param tempStoreName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean isExisted(String tempStoreName) {
		boolean exist = false;
		String sql = "select * from tb_TempStore where tempStoreName = ?";
		String[] params = { tempStoreName };
		if(db.getMap(sql, params) != null) {
			exist = true;	// 对应店铺名已经存在
		}
		return exist;
	}
	
	/**
	 * 功能：往数据库中的店铺表添加一条店铺信息
	 * @param s
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean addStore(Store s) {
		boolean success = false;
		String sql = "insert into tb_Store values(null,?,?,?,?,?,?,?,?,?,?)";
		String[] params = {
				s.getStoreName(),s.getUserName(),s.getStoreSaleNum(),s.getStoreSale(),
				s.getStoreScore(),s.getStoreComment(),s.getStoreEvaluate(),
				s.getStoreDescript(),s.getStoreLicense(),s.getStoreState()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// 添加成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名称修改店铺状态
	 * @param storeName
	 * @param newStoreState
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateStoreState(String storeName, String newStoreState) {
		boolean success = false;
		String sql = "update tb_Store set storeState = ? where storeName = ? ";
		String[] params = { newStoreState, storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改状态成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名删除店铺
	 * @param storeName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean deleteStore(String storeName) {
		boolean success = false;
		String sql = "delete from tb_Store where storeName = ?";
		String[] params = { storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// 删除成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名修改店铺总销售量和销售额，用于用户下订单时的修改。
	 * @param storeName
	 * @param storeSaleNum
	 * @param storeSale
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateStore(String storeName, String storeSaleNum, String storeSale) {
		boolean success = false; 
		String sql = "update tb_Store set storeSaleNum = ?, storeSale = ? where storeName = ? ";
		String[] params = { storeSaleNum, storeSale, storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名修改店铺评分、总评分以及总评论数，用于用户评价订单时的修改
	 * @param storeName
	 * @param storeEvaluate
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateStoreEvaluate(Store s) {
		boolean success = false;
		String sql = "update tb_Store set storeScore = ?, storeComment = ?, storeEvaluate = ? where storeName = ? ";
		String[] params = { s.getStoreScore(), s.getStoreComment(), s.getStoreEvaluate(), s.getStoreName() };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据店铺名称获取一条店铺信息
	 * @param storeName
	 * @return 成功则返回店铺信息，否则返回null。
	 */
	public Map getStoreByName(String storeName) {
		Map m = null;
		String sql = "select * from tb_Store where storeName = ? ";
		String[] params = { storeName };
		m = db.getMap(sql, params);
		return m;
	}
	
}
