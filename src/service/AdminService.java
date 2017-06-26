package service;

import java.util.List;
import java.util.Map;

import bean.PageBean;
import bean.TempStore;
import dao.OrderDAO;
import dao.StoreDAO;
import dao.UserDAO;

/**
 * �û�����Ա�����û��Լ����̡�
 * 
 * �û�����:	(1)�鿴�����û�������Ϣ
 *         	(2)�����û����鿴�û�������Ϣ����һ�����ݶ�����Ų鿴��������Ʒ��Ϣ
 *         	(3)�����û���ɾ���û�
 *         
 * ���̹���:	(1)��ȡ��ʱ���̱����Ϣ����ͨ����˵ĵ�����ӵ����̱��У�Ȼ�������ʱ���̱���ɾ��
 *          (2)���ݵ�����ɾ��������Ϣ
 *          (3)���ݵ������޸ĵ���״̬
 *          (4)�鿴���е�����Ϣ�����ݵ������鿴���̶�����Ϣ
 * 
 * @author ����
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
	 * ���ܣ��������Ա�鿴�û�������Ϣҵ��
	 * @param curPage
	 * @return �ɹ��򷵻��û���Ϣ�б����򷵻�null��
	 */
	public PageBean getAllUserInfo(int curPage) {
		return uDao.getAllUser(curPage);
	}
	
	/**
	 * ���ܣ��������Ա�鿴�û����Ѽ�¼
	 * @param userName
	 * @param curPage
	 * @return �ɹ��򷵻ض�����Ϣ�����򷵻�null��
	 */
	public PageBean getOrderByUserName(String userName, int curPage) {
		return oDao.getOrderByUserName(userName, curPage);
	}
	
	/**
	 * ���ܣ��������Ա�鿴������Ʒ�б�
	 * @param orderId
	 * @return �ɹ��򷵻���Ʒ�б���Ϣ�����򷵻�null��
	 */
	@SuppressWarnings("rawtypes")
	public List getOrderProductById(int orderId) {
		return oDao.getOrderProductById(orderId);
	}
	
	/**
	 * ���ܣ��������Աɾ���û�ҵ��
	 * @param userName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteUserByName(String userName) {
		return uDao.deleteUserByName(userName);
	}
	
	/**
	 * ���ܣ��������Ա�鿴������Ϣҵ��
	 * @param curPage
	 * @return �ɹ��򷵻ص�����Ϣ�б����򷵻�null��
	 */
	public PageBean getAllStoreInfo(int curPage) {
		return sDao.getAllStore(curPage);
	}
	
	/**
	 * ���ܣ��������Ա��ȡ��ʱ���̱�ҵ����ӵ���ǰ�Ĳ���
	 * @param curPage
	 * @return �ɹ��򷵻���ʱ������Ϣ�б����򷵻�null��
	 */
	public PageBean getStoreInfoInTempStore(int curPage) {
		return sDao.getStoreFromTempStore(curPage);
	}
	
	/**
	 * ���ܣ��������Ա��ӵ���ҵ�����ǰ�жϵ����Ƿ��Ѿ����ڣ�
	 * 		��ӳɹ���ɾ����ʱ���̱��еĵ���
	 * @param ts
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean addStore(TempStore ts) {
		boolean success = false;
		if(! sDao.isExistInStore(ts.getTempStoreName())) {
			// �����ڸõ��̣������
			if(sDao.addStore(ts) && sDao.deleteFromTempStore(ts.getTempStoreId())) {
				// ��ӳɹ�
				success = true;
			}
		}
		return success;
	}
	
	/**
	 * ���ܣ��������Ա�鿴���̶���ҵ��
	 * @param storeName
	 * @param curPage
	 * @return �ɹ��򷵻ص��̶�����Ϣ�����򷵻�null��
	 */
	public PageBean getOrderInfoByStoreName(String storeName, int curPage) {
		return oDao.getOrderByStoreName(storeName, curPage);
	}
	
	/**
	 * ���ܣ��������Ա�鿴���̶����ջ���Ϣ
	 * @param orderId
	 * @return �ɹ��򷵻�һ��������Ϣ�����򷵻�null��
	 */
	@SuppressWarnings("rawtypes")
	public Map getOrderDetailById(int orderId) {
		return oDao.getOrderDetailById(orderId);
	}
	
	/**
	 * ���ܣ��������Աɾ������ҵ��
	 * @param storeName
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean deleteStore(String storeName) {
		return sDao.deleteStore(storeName);
	}
	
	/**
	 * ���ܣ��������Ա�޸ĵ���״̬ҵ��
	 * @param storeName
	 * @param newStoreState
	 * @return �ɹ��򷵻�true�����򷵻�false��
	 */
	public boolean udpateStoreState(String storeName, String newStoreState) {
		return sDao.updateStoreState(storeName, newStoreState);
	}
	
	/**
	 * ���ܣ��������Աɾ����ʱ������Ϣ
	 * @param tempStoreId
	 * @return
	 */
	public boolean deleteTempStoreById(int tempStoreId) {
		return sDao.deleteFromTempStore(tempStoreId);
	}
	
	/**
	 * ���ܣ����ݵ�������ȡ������Ϣ
	 * @param storeName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map getStoreByName(String storeName) {
		return sDao.getStoreByName(storeName);
	}
	
	
}