package com.haven.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.OrderProduct;

/**
 *  ��OrderProduct.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("productDao")
@Scope("prototype")
public interface OrderProductDAO {

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
