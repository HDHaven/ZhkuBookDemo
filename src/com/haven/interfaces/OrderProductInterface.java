package com.haven.interfaces;

import java.util.List;

import com.haven.model.OrderProduct;

/**
 *  ��OrderProduct.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface OrderProductInterface {

	/**
	 * �������붩����Ʒ
	 */
	public int insertBatch(List<OrderProduct> productList);
	
	/**
	 * ���ݶ������ɾ����Ӧ����Ʒ��Ϣ��ɾ������ʱ˳��ɾ��
	 */
	public int deleteOne(int orderId);
	
	/**
	 * ����ɾ��
	 */
	public int deleteBatch(int[] ids);
	
	/**
	 * ���ݶ�����Ż�ȡ������Ʒ��Ϣ
	 */
	public List<OrderProduct> getOrderProduct(int orderId);
	
}
