package dao;

import java.util.Map;

import bean.Comment;
import bean.PageBean;
import bean.TempStore;
import util.DBUtil;

@SuppressWarnings("rawtypes")
public class StoreDAO {
	/**
	 * �������ݷ��ʲ�
	 */
	private DBUtil db;
	
	public StoreDAO() {
		db = new DBUtil();
	}
	
	/**
	 * ���ܣ��������뿪���̣�����ʱ���������һ����¼
	 * @param ts
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addTempStore(TempStore ts) {
		boolean success = false;
		String sql = "insert into tb_TempStore values(null,?,?,?,?);";
		Object[] params = { ts.getUserName(), ts.getTempStoreName(), ts.getTempStoreDescript(), ts.getTempStoreLicense() };
		if(db.update(sql, params) > 0) {
			// ��ӳɹ�
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ�������ʱ���̱��ɾ����ʱ���̱��һ����¼
	 * @param tempStoreId
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteFromTempStore(int tempStoreId) {
		boolean success = false;
		String sql = "delete from tb_TempStore where tempStoreId = ? ";
		Object[] params = { tempStoreId };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ڹ���Ա��ȡ��ʱ���̱�����е�����Ϣ����ҳ��ʾ
	 * @param curPage	��ǰҳ
	 * @return �ɹ��򷵻ص�����Ϣ�б����򷵻�null��
	 */
	public PageBean getStoreFromTempStore(int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_TempStore ";
		pb = db.getPageBean(sql, null, curPage);
		return pb;
	}
	
	/**
	 * ���ܣ������ж���ʱ���̱����Ƿ���ڸõ������ĵ�����Ϣ������ǰ�ж�
	 * @param tempStoreName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean isExisted(String tempStoreName) {
		boolean exist = false;
		String sql = "select * from tb_TempStore where tempStoreName = ?";
		Object[] params = { tempStoreName };
		if(db.getMap(sql, params) != null) {
			exist = true;	// ��Ӧ�������Ѿ�����
		}
		return exist;
	}
	
	/**
	 * ���ܣ������жϵ��̱����Ƿ���ڸõ������ĵ�����Ϣ������ǰ�ж�
	 * @param storeName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean isExistInStore(String storeName) {
		boolean exist = false;
		String sql = "select * from tb_Store where storeName = ? ";
		Object[] params = { storeName };
		if(db.getMap(sql, params) != null) {
			exist = true;
		}
		return exist;
	}
	
	/**
	 * ���ܣ������ݿ��еĵ��̱����һ��������Ϣ
	 * @param ts
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addStore(TempStore ts) {
		boolean success = false;
		String sql = "insert into tb_Store values(null,?,?,0,0,0,0,0,?,?,'Ӫҵ��')";
		Object[] params = {
				ts.getTempStoreName(),ts.getUserName(),
				ts.getTempStoreDescript(),ts.getTempStoreLicense()
		};
		if(db.update(sql, params) > 0) {
			success = true;	// ��ӳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ��������޸ĵ���״̬
	 * @param storeName
	 * @param newStoreState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateStoreState(String storeName, String newStoreState) {
		boolean success = false;
		String sql = "update tb_Store set storeState = ? where storeName = ? ";
		Object[] params = { newStoreState, storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸�״̬�ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ�����ɾ������
	 * @param storeName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteStore(String storeName) {
		boolean success = false;
		String sql = "delete from tb_Store where storeName = ?";
		Object[] params = { storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������޸ĵ����������������۶�����û��¶���ʱ���޸ġ�
	 * @param storeName
	 * @param bookNumber
	 * @param bookPrice
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateStore(String storeName, int bookNumber, int bookPrice) {
		boolean success = false; 
		String sql = "update tb_Store set storeSaleNum = storeSaleNum+?, storeSale = storeSale+? where storeName = ? ";
		Object[] params = { bookNumber, bookPrice*bookNumber, storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������޸ĵ������֡��������Լ����������������û����۶���ʱ���޸�
	 * @param storeName
	 * @param storeEvaluate
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateStoreEvaluate(Comment c) {
		boolean success = false;
		String sql = "update tb_Store set storeScore = storeScore+?, storeComment = storeComment+1, storeEvaluate = (storeScore+?)/(storeComment+1) where storeName = ? ";
		Object[] params = { c.getCommentScore(), c.getCommentScore(), c.getStoreName() };
		if(db.update(sql, params) > 0) {
			success = true;	// �޸ĳɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������ƻ�ȡһ��������Ϣ
	 * @param storeName
	 * @return �ɹ��򷵻ص�����Ϣ�����򷵻�null��
	 */
	public Map getStoreByName(String storeName) {
		Map m = null;
		String sql = "select * from tb_Store where storeName = ? ";
		String[] params = { storeName };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * ���ܣ������û�������ң�����һ��������Ϣ
	 * @param userName
	 * @return �ɹ��򷵻ص�����Ϣ�����򷵻�null��
	 */
	public Map getStoreByUserName(String userName) {
		Map m = null;
		String sql = "select * from tb_Store where userName = ? ";
		String[] params = { userName };
		m = db.getMap(sql, params);
		return m;
	}
	
	/**
	 * ���ܣ���ȡ���е�����Ϣ����ҳ��ʾ
	 * @param curPage
	 * @return �ɹ��򷵻ص�����Ϣ�б����򷵻�false��
	 */
	public PageBean getAllStore(int curPage) {
		PageBean pb = null;
		String sql = "select * from tb_Store";
		pb = db.getPageBean(sql, null, curPage);
		return pb;
	}
	
}
