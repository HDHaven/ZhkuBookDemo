package com.haven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.Store;

/**
 *  ��Store.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("storeDao")
@Scope("prototype")
public interface StoreDAO {

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
	
	/**
	 * ���ڹ���Ա��ȡ���е�����Ϣ����ҳ��ʾ
	 */
	public List<Store> getStoreByPage(Map<String, Object> parameter);
	
}
