package dao;

import java.util.Map;

import bean.PageBean;
import bean.User;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class UserDAO {
	/**
	 * 用户数据访问层
	 */
	private DBUtil db;	// 数据库工具类
	
	public UserDAO() {
		db = new DBUtil();
	}
	
	/**
	 * 功能：验证用户登录。根据用户名和密码判断是否为合法用户
	 * @param userName
	 * @param password
	 * @return 成功则返回用户类型('1'表示普通用户，'2'表示管理员)，否则返回0。
	 */
	public int login(String userName, String password) {
		int userType = 0;
		String sql = "select * from tb_User where userName=? and password=? ";
		String[] params = { userName, password };
		Map m = db.getMap(sql, params);
		if(m != null) { // 如果查询结果不为空，表示密码正确
			userType = (int)m.get("userType");
		}
		
		return userType;
	}
	
	/**
	 * 功能：根据用户名判断该用户名是否存在，用于注册时判断
	 * @param userName
	 * @return 存在则返回true，否则返回false。
	 */
	public boolean isExisted(String userName) {
		boolean exist = false;
		String sql = "select * from tb_User where userName = ? ";
		String[] params = { userName };
		if(db.getMap(sql, params) != null) {
			exist = true;	// 用户名已经存在
		}
		return exist;
	}
	
	/**
	 * 功能：用于用户注册，根据用户名和密码注册用户。
	 * @param userName
	 * @param password
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean register(String userName, String password) {
		boolean success = false;
		String sql = "insert into tb_User values(null, ?, ?, '1',null,null,null) ";
		String[] params = { userName, password };
		if(db.update(sql, params) > 0) {
			success = true;	// 添加成功
		}
		return success;
	}
	
	/**
	 * 功能：根据用户名修改用户密码
	 * @param newPassword
	 * @param userName
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updatePassword(String userName, String newPassword) {
		boolean success = false;
		String sql = "update tb_User set password = ? where userName = ? ";
		String[] params = { newPassword, userName };
		if(db.update(sql, params) > 0) {
			success = true;	// 修改成功
		}
		return success;
	}
	
	/**
	 * 功能：根据用户名修改用户地址信息
	 * @param user
	 * @return 成功则返回true，否则返回false。
	 */
	public boolean updateAddr(User user) {
		boolean success = false;
		String sql = "update tb_User set userAddr = ?, userPhone = ?, userConsignee = ? where userName = ? ";
		String[] params = {
				user.getUserAddr(), user.getUserPhone(),
				user.getUserConsignee(), user.getUserName()
		};
		if(db.update(sql, params) > 0) {
			success = true;
		}
		return success;
	}
	
	/**
	 * 功能：根据用户名返回用户信息
	 * @param userName
	 * @return 成功则返回用户信息，否则返回null。
	 */
	public Map getUserByName(String userName) {
		Map m = null;
		String sql = "select * from tb_User where userName = ? ";
		String[] params = { userName };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * 功能：用于管理员查看用户基本信息，分页查看
	 * @param curPage 当前页
	 * @return 成功则返回当前页用户信息，否则返回null。
	 */
	public PageBean getAllUser(int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_User";
		pb = db.getPageBean(sql, null, curPage);
		return pb;
	}
	
}
