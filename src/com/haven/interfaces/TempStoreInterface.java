package com.haven.interfaces;

import java.util.List;

import com.haven.model.TempStore;

/**
 *  ��TempStore.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface TempStoreInterface {

	/**
	 * ����һ����¼
	 */
	public int insert(TempStore ts);
	
	/**
	 * ɾ��һ����¼
	 */
	public int deleteOne(int tempStoreId);
	
	/**
	 * ����ɾ��
	 */
	public int deleteBatch(int[] ids);
	
	/**
	 * �޸ĵ���״̬
	 */
	public int update(TempStore ts);
	
	/**
	 * ��ȡ��ʱ������Ϣ���ɸ����û������ߵ���״̬��ȡ
	 */
	public List<TempStore> getTempStoreInfo(TempStore ts);
	
}
