package dao;

import java.util.Map;

import bean.PageBean;
import bean.Store;
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
		String sql = "insert into tb_TempStore values(?,?,?,?);";
		String[] params = { ts.getTempStoreName(), ts.getUserName(), ts.getTempStoreDescript(), ts.getTempStoreLicense() };
		if(db.update(sql, params) > 0) {
			// ��ӳɹ�
			success = true;
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ�����ɾ����ʱ���̱��һ����¼
	 * @param storeName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteFromTempStore(String tempStoreName) {
		boolean success = false;
		String sql = "delete from tb_Store where tempStoreName = ?";
		String[] params = { tempStoreName };
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
		String[] params = { tempStoreName };
		if(db.getMap(sql, params) != null) {
			exist = true;	// ��Ӧ�������Ѿ�����
		}
		return exist;
	}
	
	/**
	 * ���ܣ������ݿ��еĵ��̱����һ��������Ϣ
	 * @param s
	 * @return �ɹ��򷵻�true�����򷵻�false��
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
		String[] params = { newStoreState, storeName };
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
		String[] params = { storeName };
		if(db.update(sql, params) > 0) {
			success = true;	// ɾ���ɹ�
		}
		return success;
	}
	
	/**
	 * ���ܣ����ݵ������޸ĵ����������������۶�����û��¶���ʱ���޸ġ�
	 * @param storeName
	 * @param storeSaleNum
	 * @param storeSale
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean updateStore(String storeName, String storeSaleNum, String storeSale) {
		boolean success = false; 
		String sql = "update tb_Store set storeSaleNum = ?, storeSale = ? where storeName = ? ";
		String[] params = { storeSaleNum, storeSale, storeName };
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
	public boolean updateStoreEvaluate(Store s) {
		boolean success = false;
		String sql = "update tb_Store set storeScore = ?, storeComment = ?, storeEvaluate = ? where storeName = ? ";
		String[] params = { s.getStoreScore(), s.getStoreComment(), s.getStoreEvaluate(), s.getStoreName() };
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
	
}
