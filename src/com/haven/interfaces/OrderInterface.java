package com.haven.interfaces;

import java.util.List;

import com.haven.model.Address;
import com.haven.model.Order;

/**
 *  ��Order.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface OrderInterface {

	/**
	 * ����һ��������Ϣ
	 */
	public int insert(Order o);
	
	/**
	 * ɾ��һ��������Ϣ
	 */
	public int deleteOne(int orderId);
	
	/**
	 * ����ɾ������
	 */
	public int deleteBatch(int[] ids);
	
	/**
	 * �޸Ķ���״̬
	 */
	public int update(Order o);
	
	/**
	 * ��ȡ������Ϣ�����Ը����û��������������߶���״̬��ȡ
	 */
	public List<Order> getOrderInfo(Order o);
	
	/**
	 * ��ȡ�����ͻ���ַ
	 */
	public Address getOrderAddr(int orderId);
	
}
