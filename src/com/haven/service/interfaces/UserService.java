package com.haven.service.interfaces;

import java.util.List;

import com.haven.model.Address;
import com.haven.model.Store;
import com.haven.model.TempStore;
import com.haven.model.User;

/**
 * �û�ҵ���ӿڣ�������ַ����ҵ�񡢹��ﳵ����ҵ���Լ�������Ϣ����ҵ��
 */
public interface UserService {

	// ���û���Ĳ���
	
	/**
	 * ��¼
	 * @param userName	���û���
	 * @param password	������
	 * @return			����¼�ɹ������û����󣬷��򷵻�null��
	 */
	User login(String userName, String password);
	
	/**
	 * ע��
	 * @param userName			���û���
	 * @param password			������
	 * @param confirmPassword	��ȷ������
	 * @return					��ע��ɹ������û����󣬷��򷵻�null��
	 */
	User register(String userName, String password, String confirmPassword);
	
	/**
	 * �����û�����޸�����
	 * @param userId				���û����
	 * @param userName				���û���
	 * @param oldPassword			��������
	 * @param newPassword			��������
	 * @param confirmNewPassword	��ȷ��������
	 * @return						���޸ĳɹ�����true�����򷵻�false��
	 */
	boolean updatePassword(int userId, String userName, String oldPassword, String newPassword, String confirmNewPassword);
	
	// �Ե�ַ��Ĳ���
	
	/**
	 * �û���ӵ�ַ
	 * @param a	����ַ��Ϣ
	 * @return	���ɹ��򷵻ص�ַ��Ϣ�����򷵻�null��
	 */
	Address addAddr(Address a);
	
	/**
	 * ���ݵ�ַ���ɾ����ַ��Ϣ����������ɾ���Լ�����ɾ��
	 * @param ids	����ַ���
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean deleteAddr(String[] ids);
	
	/**
	 * ���ݵ�ַ����޸ĵ�ַ��Ϣ
	 * @param a	����ַ��Ϣ
	 * @return	���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean updateAddr(Address a);
	
	/**
	 * �����û���Ż�ȡ�û���ַ
	 * @param userId	���û����
	 * @return			���ɹ��򷵻ص�ַ�б���Ϣ�����򷵻�null��
	 */
	List<Address> getAddrInfo(int userId);
	
	/**
	 * ���ݵ�ַ��Ż�ȡ��ַ��Ϣ
	 * @param addrId	����ַ���
	 * @return			���ɹ��򷵻ص�ַ��Ϣ�����򷵻�null��
	 */
	Address chooseAddr(String addrId);
	
	// �Ե��̱�Ĳ���
	
	/**
	 * �����û����뿪���̣�����ǰ�жϵ������Ƿ��Ѿ�����
	 * @param ts	����ʱ���̶���
	 * @return		���ɹ��򷵻���ʱ������Ϣ�����򷵻�null��
	 */
	TempStore addStore(TempStore ts);
	
	/**
	 * �����û��鿴������̽��ȣ�״̬��
	 * @param userName	���û���
	 * @return			���ɹ��򷵻ظ��û��������ʱ������Ϣ�����򷵻�null��
	 */
	TempStore checkState(String userName);
	
	/**
	 * �����û��������
	 * @param storeId	�����̱��
	 * @param userName	������
	 * @return			���ɹ��򷵻ص�����Ϣ�����򷵻�null��
	 */
	Store enterStore(String storeId, String userName);
	
}
