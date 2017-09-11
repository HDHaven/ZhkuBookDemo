package com.haven.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.Cart;

/**
 *  ��Cart.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("cartDao")
@Scope("prototype")
public interface CartDAO {

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
	
	/**
	 * �����û�����ȡ���ﳵ�еĵ�����
	 */
	public List<Cart> getStoreName(String userName);
	
	/**
	 * ���ݹ��ﳵ��Ż�ȡ���ﳵ��Ϣ�б�
	 */
	public List<Cart> getCartById(int[] ids);
	
}
