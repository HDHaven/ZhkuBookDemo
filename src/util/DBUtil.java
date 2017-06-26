package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.PageBean;

public class DBUtil {

	private String driver = null;
	private String url = null;
	private String userName = null;
	private String password = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private int pageSize = 8; // 每页显示的记录数

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DBUtil() {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/db_ZhkuBook?unicode=true&characterEncoding=utf-8";
		userName = "root";
		password = "";
	}

	// 获取连接对象
	private Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("数据库驱动加载失败");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("连接数据库失败");
			e.printStackTrace();
		}

		return conn;
	}

	// 获取语句对象
	private PreparedStatement getPreparedStatement(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("获取语句对象失败");
			e.printStackTrace();
		}

		return pstmt;
	}

	// 给pstmt的SQL语句设置参数
	private void setParams(String sql, Object[] params) {
		pstmt = this.getPreparedStatement(sql);
		if (params != null && params.length != 0) {
			for (int i = 0; i < params.length; i++) {
				try {
					if (params[i] instanceof Integer) {
						pstmt.setInt(i + 1, (int) params[i]);
					} else if (params[i] instanceof String) {
						pstmt.setString(i + 1, (String) params[i]);
					} else {
						System.out.println("参数有误！");
					}
				} catch (SQLException e) {
					System.out.println("设置参数失败");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 执行数据库查询操作，将返回结果封装到List对象中
	 * 
	 * @param sql
	 * @param params
	 * @return 成功则返回List集合，否则返回null。
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getList(String sql, Object[] params) {
		List list = new ArrayList();
		try {
			this.setParams(sql, params);
			rs = pstmt.executeQuery();
			if(rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				while (rs.next()) {
					Map m = new HashMap();
					for (int i = 1; i <= rsmd.getColumnCount(); i++) {
						String colName = rsmd.getColumnName(i);
						Object o = rs.getObject(colName);
						if (o instanceof Integer) {
							m.put(colName, (int) o);
						} else if (o instanceof String) {
							m.put(colName, (String) o);
						}
					}
					list.add(m);
				}
			}
		} catch (SQLException e) {
			System.out.println("查询失败");
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	/**
	 * 执行数据库查询操作时，将返回的结果封装到List对象中
	 * 
	 * @param sql
	 * @param params
	 * @return 返回一条查询结果封装到Map集合中，否则返回null。
	 */
	@SuppressWarnings({ "rawtypes" })
	public Map getMap(String sql, Object[] params) {
		List list = getList(sql, params);
		if (list == null || list.isEmpty()) {
			return null;
		} else {
			return (Map) list.get(0);
		}
	}

	/**
	 * 更新数据库调用的update方法
	 * 
	 * @param sql
	 * @param params
	 * @return 成功则返回受影响的行数，否则返回0。
	 */
	public int update(String sql, Object[] params) {
		int recNo = 0;
		try {
			setParams(sql, params);
			recNo = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("更新数据失败");
			recNo = 0;
			e.printStackTrace();
		} finally {
			close();
		}

		return recNo;
	}

	// 关闭资源
	private void close() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 用于分页查询之前，统计在查询条件下返回的记录条数
	 * 
	 * @param sql
	 * @param params
	 * @return 成功则返回总记录条数，否则返回0。
	 */
	private int getTotalRows(String sql, Object[] params) {
		int totalRows = 0;
		sql = sql.toLowerCase();
		String countSql = "";
		// 修改SQL语句求总记录数
		countSql = "select count(*) as tempNum " + sql.substring(sql.indexOf("from"));
		this.setParams(countSql, params);
		// count中存放总记录数
		String count = "";
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		totalRows = Integer.parseInt(count);
		return totalRows;
	}

	/**
	 * 分页显示查询结果时，将当前页中的所有信息封装到PageBean中
	 * 
	 * @param sql
	 * @param params
	 * @param curPage
	 * @return 成功则返回一个PageBean对象，否则返回null。
	 */
	@SuppressWarnings("rawtypes")
	public PageBean getPageBean(String sql, Object[] params, int curPage) {
		String newSql = sql + " limit " + (curPage - 1) * pageSize + "," + pageSize;
		List data = this.getList(newSql, params);
		PageBean pb = null;
		if(data != null && !data.isEmpty()) {
			pb = new PageBean();
			pb.setCurPage(curPage);
			pb.setPageSize(pageSize);
			pb.setTotalRows(getTotalRows(sql, params));
			pb.setData(data);
		}
		return pb;
	}

}
