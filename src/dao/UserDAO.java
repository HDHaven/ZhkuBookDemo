package dao;

import java.util.Map;

import bean.PageBean;
import bean.User;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class UserDAO {
	/**
	 * �û����ݷ��ʲ�
	 */
	private DBUtil db;	// ���ݿ⹤����
	
	public UserDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ���֤�û���¼�������û����������ж��Ƿ�Ϊ�Ϸ��û�
	 * @param userName
	 * @param password
	 * @return �ɹ��򷵻��û�����('1'��ʾ��ͨ�û���'2'��ʾ����Ա)�����򷵻�0��
	 */
	public int login(String userName, String password) {
		int userType = 0;
		String sql = "select * from tb_User where userName=? and password=? ";
		String[] params = { userName, password };
		Map m = db.getMap(sql, params);
		if(m != null) { // �����ѯ�����Ϊ�գ���ʾ������ȷ
			userType = (int)m.get("userType");
		}
		
		return userType;
	}
	
	/**
	 * ���ܣ������û����жϸ��û����Ƿ����
	 * @param userName
	 * @return �����򷵻�true�����򷵻�false��
	 */
	public boolean isExisted(String userName) {
		boolean exist = false;
		
		return exist;
	}
	
	/**
	 * ���ܣ������û�ע�ᣬ�����û���������ע���û���
	 * @param userName
	 * @param password
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean register(String userName, String password) {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * ���ܣ������û����޸��û�����
	 * @param newPassword
	 * @param userName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updatePassword(String userName, String newPassword) {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * ���ܣ������û����޸��û���ַ��Ϣ
	 * @param user
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateAddr(User user) {
		boolean success = false;
		
		return success;
	}
	
	/**
	 * ���ܣ������û��������û���Ϣ
	 * @param userName
	 * @return �ɹ��򷵻��û���Ϣ�����򷵻�null��
	 */
	public Map getUserByName(String userName) {
		Map m = null;
		
		return m;
	}
	
	/**
	 * ���ܣ����ڹ���Ա�鿴�û�������Ϣ����ҳ�鿴
	 * @param curPage ��ǰҳ
	 * @return �ɹ��򷵻ص�ǰҳ�û���Ϣ�����򷵻�null��
	 */
	public PageBean getAllUser(int curPage) {
		PageBean pb = null;
		
		return pb;
	}
	
}
