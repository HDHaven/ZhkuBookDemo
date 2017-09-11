package com.haven.service.interfaces;

import java.util.Map;

import com.haven.model.Store;

/**
 * ����Աҵ���ӿ�
 */
public interface AdminService {

	// ���û���Ĳ���
	
	/**
	 * �û�����Ա�鿴�����û���Ϣ����ҳ��ʾ��Ҳ���Ը����û�����ѯ
	 * @param userName		���û���
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻��û���Ϣ�б����򷵻�null��
	 */
	Map<String, Object> getUser(String userName, String currentPage);
	
	/**
	 * �����û����ɾ���û���Ϣ����������ɾ��������ɾ��
	 * ɾ���ɹ�֮�����û����͵�ǰҳ��ȡ�û���Ϣ�����ص�ǰҳ�û���Ϣ
	 * @param ids			���û����
	 * @param userName		���û���
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻ص�ǰҳ�û���Ϣ�� ���򷵻�null��
	 */
	Map<String, Object> deleteUser(String[] ids, String userName, String currentPage);
	
	/**
	 * �޸��û����ͣ�������ͨ�û��͹���Ա
	 * @param userId		���û����
	 * @param newType		���û�������
	 * @param userName		���û���
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻ص�ǰҳ�û���Ϣ�� ���򷵻�null��
	 */
	Map<String, Object> updateUserType(String userId, String newType, String userName, String currentPage);
	
	// �Ե��̱�Ĳ���
	
	/**
	 * ���ݵ�ǰҳ����ȡ��ʱ������Ϣ�б�
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻���ʱ������Ϣ�б����򷵻�null��
	 */
	Map<String, Object> getTempStore(String tempStoreState, String currentPage);
	
	/**
	 * ������ʱ���̽��ȣ�״̬����ȡ������Ϣ�б�
	 * @param tempStoreState	�����̽��ȣ�״̬��
	 * @return					���ɹ��򷵻���ʷ������Ϣ�б����򷵻�null��
	 */
//	List<TempStore> getTempStoreByState(String tempStoreState);
	
	/**
	 * ������ʱ���̱���޸�������ȣ�״̬��
	 * @param tempStoreId	����ʱ���̱��
	 * @param newState		���޸ĵĽ���
	 * @return				���ɹ��򷵻�true�����򷵻�false��
	 */
	Map<String, Object> updateTempStore(String tempStoreId, String newState, String tempStoreState, String currentPage);
	
	/**
	 * ������ʱ���̱��ɾ����ʱ���̣���������ɾ���Լ�����ɾ��
	 * @param ids	����ʱ���̱��
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	Map<String, Object> deleteTempStore(String[] ids, String tempStoreState, String currentPage);
	
	/**
	 * ��ͨ����˵���ʱ������ӵ����̱���
	 * @param tempStoreId	����ʱ���̱��
	 * @return				���ɹ��򷵻ص�����Ϣ�����򷵻�null��
	 */
	Store addStore(String tempStoreId);
	
	/**
	 * ���ݵ��̱��ɾ��������Ϣ����������ɾ��������ɾ��
	 * @param ids	�����̱��
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean deleteStore(String[] ids);
	
	/**
	 * ���ݵ������޸ĵ���״̬���޸ĳɹ������û���Ϣ�б�
	 * @param storeName		����������
	 * @param storeState	���޸ĵ�״̬
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻ص�����Ϣ�б����򷵻�null��
	 */
	Map<String, Object> updateStoreState(String storeName, String storeState, String currentPage);
	
	/**
	 * ���ݵ�������ѯ������Ϣ
	 * @param storeName	����������
	 * @return			���ɹ��򷵻ص�����Ϣ�б����򷵻�null��
	 */
	Store getStoreInfo(String storeName);
	
	/**
	 * �鿴���е�����Ϣ����ҳ��ʾ
	 * @param storeName		������������Ϊ���򰴵�������ѯ
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻ص�����Ϣ�б����򷵻�null��
	 */
	Map<String, Object> getAllStore(String storeName, String currentPage);
	
}
