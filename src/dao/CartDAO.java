package dao;

import java.util.List;
import java.util.Map;

import bean.Cart;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class CartDAO {
	/**
	 * �û����ﳵ���ݷ��ʲ�
	 */
	private DBUtil db;
	
	public CartDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ������û�����ȡ���ﳵ��Ʒ�����������б�
	 * @param userName
	 * @return �ɹ��򷵻ص��������ϣ����򷵻ؿ�
	 */
	public List getStoreNameInCart(String userName) {
		List list = null;
		String sql = "select storeName from tb_Cart where userName = ? ";
		Object[] params = { userName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ������û����͵�������ȡ��Ʒ��Ϣ�б�
	 * @param userName
	 * @param storeName
	 * @return �ɹ��򷵻���Ʒ��Ϣ�б����򷵻�false��
	 */
	public List getBookByStoreName(String userName, String storeName) {
		List list = null;
		String sql = "select * from tb_Cart where userName = ? and storeName = ? ";
		Object[] params = { userName, storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ������ﳵ�����һ����¼
	 * @param c
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addBookInCart(Cart c) {
		boolean success = false;
		String sql = "insert into tb_Cart values(null, ?, ?, ?, ?, ?, ?) ";
		Object[] params = { c.getUserName(), c.getStoreName(), c.getBookName(), 
				c.getBookPrice(), c.getBookNumber(), c.getBookImage() };
		if(db.update(sql, params) > 0)
			success = true;	// ��ӳɹ�
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������������Լ��û����Ƴ����ﳵ�е���Ʒ
	 * @param storeName
	 * @param bookName
	 * @param userName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteFromCart(int cartId) {
		boolean success = false;
		String sql = "delete from tb_Cart where cartId = ? ";
		Object[] params = { cartId };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݹ��ﳵ����޸Ĺ��ﳵ�ж�Ӧͼ�������
	 * @param cartId
	 * @param bookNumber
	 * @return
	 */
	public boolean updateCart(int cartId, int bookNumber) {
		boolean success = false;
		String sql = "update tb_Cart set bookNumber = ? where cartId = ? ";
		Object[] params = { bookNumber, cartId };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ������û������������������жϹ��ﳵ�����Ƿ��Ѿ����ڸ�����¼
	 * @param userName
	 * @param storeName
	 * @param bookName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean isExisted(String userName, String storeName, String bookName) {
		boolean exist = false; 
		String sql = "select * from tb_Cart where userName = ? and storeName = ? and bookName = ? ";
		Object[] params = { userName, storeName, bookName };
		Map m = db.getMap(sql, params);
		if(m != null) {	// ���ﳵ�Ѵ��ڸ���
			exist = true;
		}
		return exist;
	}
	
	/**
	 * ���ܣ������û������ع��ﳵ��Ϣ
	 * @param userName
	 * @return �ɹ��򷵻ع��ﳵ��Ϣ�����򷵻�null��
	 */
	public List getCartByUserName(String userName) {
		List list = null;
		String sql = "select * from tb_Cart where userName = ?";
		Object[] params = { userName };
		list = db.getList(sql, params);
		return list;
	}
	
}
