package com.haven.service.interfaces;

import java.util.List;
import java.util.Map;

import com.haven.model.Book;
import com.haven.model.Cart;

/**
 * ���ﳵ������
 */
public interface CartService {

	/**
	 * ��ͼ����빺�ﳵ�����ǰ�жϹ��ﳵ���Ƿ��Ѿ����ڣ����������Ӧ����Ʒ������1���ɡ�
	 * @param userName	���û���
	 * @param book		��ͼ����Ϣ
	 * @param bookCount	����������
	 * @return			���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean addInCart(String userName, Book book, int bookCount);
	
	/**
	 * �����û�����ȡ���ﳵ��Ϣ������keyΪ��������valueΪ���ﳵ��Ϣ�б��map����
	 * @param userName	���û���
	 * @return			���ɹ��򷵻ع��ﳵ��Ϣ�б����򷵻�null��
	 */
	Map<String, List<Cart>> getCartInfo(String userName);
	
	/**
	 * ���ݹ��ﳵ���ɾ�����ﳵ��Ϣ����������ɾ���Լ�����ɾ��
	 * @param ids	�����ﳵ�������
	 * @return		���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean deleteCart(String[] ids);
	
	/**
	 * ���ݹ��ﳵ����޸Ĺ��ﳵ��Ʒ�Ĺ�������
	 * @param cartId	�����ﳵ���
	 * @param bookCount	����Ʒ����
	 * @return			���ɹ��򷵻�true�����򷵻�false��
	 */
	boolean updateCart(String cartId, String bookCount);
	
}
