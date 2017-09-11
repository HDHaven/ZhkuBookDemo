package com.haven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.Address;
import com.haven.model.Order;

/**
 *  ��Order.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("orderDao")
@Scope("prototype")
public interface OrderDAO {

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
	 * �޸Ķ���״̬������Ĳ����Ƕ����ı�ź��µ�״̬
	 */
	public int update(Order o);
	
	/**
	 * ��ȡ������Ϣ�����Ը����û��������������߶���״̬��ȡ
	 */
	public List<Order> getOrderInfoByPage(Map<String, Object> parameter);
	
	/**
	 * ��ȡ�����ͻ���ַ
	 */
	public Address getOrderAddr(int orderId);
	
}
