package com.haven.interfaces;

import java.util.List;

import com.haven.model.Store;

/**
 *  ��Store.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface StoreInterface {

	/**
	 * ����һ����¼
	 */
	public int insert(Store store);
	
	/**
	 * ɾ��һ����¼
	 */
	public int delete(int storeId);
	
	/**
	 * �޸ĵ�����Ϣ������״̬�������������۶��ȡ��������
	 */
	public int update(Store store);
	
	/**
	 * ��ȡ������Ϣ���ɸ����û������ߵ�������ȡ
	 */
	public List<Store> getStoreInfo(Store store);
	
}
