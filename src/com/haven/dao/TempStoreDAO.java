package com.haven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.TempStore;

/**
 *  ��TempStore.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("tempStoreDao")
@Scope("prototype")
public interface TempStoreDAO {

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

	/**
	 * ��ȡ������ʱ������Ϣ����ҳ��ʾ
	 */
	public List<TempStore> getTempStoreByPage(Map<String, Object> parameter);
	
}
