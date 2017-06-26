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

	private int pageSize = 8; // ÿҳ��ʾ�ļ�¼��

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

	// ��ȡ���Ӷ���
	private Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, userName, password);
		} catch (ClassNotFoundException e) {
			System.out.println("���ݿ���������ʧ��");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������ݿ�ʧ��");
			e.printStackTrace();
		}

		return conn;
	}

	// ��ȡ������
	private PreparedStatement getPreparedStatement(String sql) {
		try {
			pstmt = getConnection().prepareStatement(sql);
		} catch (SQLException e) {
			System.out.println("��ȡ������ʧ��");
			e.printStackTrace();
		}

		return pstmt;
	}

	// ��pstmt��SQL������ò���
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
						System.out.println("��������");
					}
				} catch (SQLException e) {
					System.out.println("���ò���ʧ��");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * ִ�����ݿ��ѯ�����������ؽ����װ��List������
	 * 
	 * @param sql
	 * @param params
	 * @return �ɹ��򷵻�List���ϣ����򷵻�null��
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
			System.out.println("��ѯʧ��");
			list = null;
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

	/**
	 * ִ�����ݿ��ѯ����ʱ�������صĽ����װ��List������
	 * 
	 * @param sql
	 * @param params
	 * @return ����һ����ѯ�����װ��Map�����У����򷵻�null��
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
	 * �������ݿ���õ�update����
	 * 
	 * @param sql
	 * @param params
	 * @return �ɹ��򷵻���Ӱ������������򷵻�0��
	 */
	public int update(String sql, Object[] params) {
		int recNo = 0;
		try {
			setParams(sql, params);
			recNo = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("��������ʧ��");
			recNo = 0;
			e.printStackTrace();
		} finally {
			close();
		}

		return recNo;
	}

	// �ر���Դ
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
	 * ���ڷ�ҳ��ѯ֮ǰ��ͳ���ڲ�ѯ�����·��صļ�¼����
	 * 
	 * @param sql
	 * @param params
	 * @return �ɹ��򷵻��ܼ�¼���������򷵻�0��
	 */
	private int getTotalRows(String sql, Object[] params) {
		int totalRows = 0;
		sql = sql.toLowerCase();
		String countSql = "";
		// �޸�SQL������ܼ�¼��
		countSql = "select count(*) as tempNum " + sql.substring(sql.indexOf("from"));
		this.setParams(countSql, params);
		// count�д���ܼ�¼��
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
	 * ��ҳ��ʾ��ѯ���ʱ������ǰҳ�е�������Ϣ��װ��PageBean��
	 * 
	 * @param sql
	 * @param params
	 * @param curPage
	 * @return �ɹ��򷵻�һ��PageBean���󣬷��򷵻�null��
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
