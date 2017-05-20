package dao;

import java.util.List;
import java.util.Map;

import bean.Book;
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
		String[] params = { userName };
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
		String[] params = { userName, storeName };
		list = db.getList(sql, params);
		return list;
	}
	
	/**
	 * ���ܣ������ﳵ�����һ����¼
	 * @param b
	 * @param userName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addBookInCart(Book b, String userName, String bookNumber) {
		boolean success = false;
		String sql = "insert into tb_Cart values(null, ?, ?, ?, ?, ?) ";
		String[] params = { userName, b.getStoreName(), b.getBookName(), b.getBookPrice(), bookNumber };
		if(db.update(sql, params) > 0)
			success = true;	// ��ӳɹ�
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������������Ƴ����ﳵ�е���Ʒ
	 * @param storeName
	 * @param bookName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteFromCart(String storeName, String bookName) {
		boolean success = false;
		String sql = "delete from tb_Cart where storeName = ? and bookName = ? ";
		String[] params = { storeName, bookName };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݹ��ﳵ���ɾ�����ﳵ�е���Ʒ
	 * @param cartId
	 * @param bookNumber
	 * @return
	 */
	public boolean updateCart(String storeName, String userName, String bookNumber) {
		boolean success = false;
		String sql = "update tb_Cart set bookNumber = ? where storeName = ? and userName = ? ";
		String[] params = { bookNumber, storeName, userName };
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
	 * @return �ɹ��򷵻ض�Ӧͼ��Ĺ��������������򷵻�null��
	 */
	public String isExisted(String userName, String storeName, String bookName) {
		String bookNumber = null; 
		String sql = "select bookNumber from tb_Cart where userName = ? and storeName = ? and bookName = ? ";
		String[] params = { userName, storeName, bookName };
		Map m = db.getMap(sql, params);
		if(m != null) {	// ���ﳵ�Ѵ���
			bookNumber = (String) m.get("bookNumber");
		}
		return bookNumber;
	}
	
}
