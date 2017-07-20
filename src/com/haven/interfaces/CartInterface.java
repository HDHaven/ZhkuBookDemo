package com.haven.interfaces;

import java.util.List;

import com.haven.model.Cart;

/**
 *  ��Cart.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface CartInterface {

	/**
	 * �����ﳵ�в���һ����¼
	 */
	public int insert(Cart cart);
	
	/**
	 * ɾ��һ����¼
	 */
	public int deleteOne(int id);
	
	/**
	 * ����ɾ��
	 */
	public int deleteBatch(int[] ids);
	
	/**
	 * �޸Ĺ����ͼ������
	 */
	public int update(Cart cart);
	
	/**
	 * ���ݲ�ͬ������ȡ���ﳵ�м�¼
	 * ���Ը����û���������������ͼ������ȡ
	 */
	public List<Cart> getCart(Cart cart);
	
}
