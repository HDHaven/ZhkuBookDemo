package com.haven.service.interfaces;

import java.util.List;
import java.util.Map;

import com.haven.model.Cart;

/**
 * ����ҵ���ӿ�
 */
public interface OrderService {
	
	/**
	 * �ӹ��ﳵ�����ɶ��������û�һ���µ�������������Ϊ�������
	 * @param ids	��������Ʒ�Ĺ��ﳵ���
	 * @return		���ɹ��򷵻�Ҫ�������Ʒ��Ϣ�б����򷵻�null
	 */
	Map<String, List<Cart>> generateOrder(String[] ids);
	
	/**
	 * ��Ӷ���
	 * @param cartMap	��������������Ʒ���Ե���������
	 * @param addrId	��������ַ���
	 * @param userName	�������û�
	 * @return			���ɹ��򷵻�true�� ���򷵻�false��
	 */
	boolean addOrder(Map<String, List<Cart>> cartMap, String addrId, String userName);
	
	/**
	 * ���ݶ�������޸Ķ���״̬
	 * @param orderId		���������
	 * @param orderState	������״̬
	 * @return				���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean updateOrder(String orderId, String orderState);
	
	/**
	 * �����û��������������߶���״̬��ȡ������Ϣ����ҳ��ʾ
	 * @param userName		���û���
	 * @param storeName		��������
	 * @param orderState	������״̬
	 * @param currentPage	����ǰҳ
	 * @return				���ɹ��򷵻ص�ǰҳ�Ķ�����Ϣ�б����򷵻�null��
	 */
	Map<String, Object> getOrderInfo(String userName, String storeName, String orderState, String currentPage);
	
	/**
	 * ��ȡ��������ϸ��Ϣ������������������Ʒ��Ϣ�Լ������ջ���ַ
	 * ���У����ݶ�����Ż�ȡ����������Ʒ��Ϣ�����ݵ�ַ��Ż�ȡ�����ջ���ַ
	 * @param orderId	���������
	 * @param addrId	����ַ���
	 * @return			���ɹ��򷵻ض������飬���򷵻�null��
	 */
	Map<String, Object> getOrderDetail(String orderId, String addrId);
	
}
