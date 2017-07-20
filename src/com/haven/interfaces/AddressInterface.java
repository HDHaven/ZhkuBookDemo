package com.haven.interfaces;

import java.util.List;

import com.haven.model.Address;

/**
 * ��Address.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface AddressInterface {

	/**
	 * ����һ����ַ��¼
	 */
	public int insert(Address addr);
	
	/**
	 * ɾ��һ����ַ��¼
	 */
	public int deleteOne(int addrId);
	
	/**
	 * ����ɾ��
	 */
	public int deleteBatch(int[] ids);
	
	/**
	 * �޸ĵ�ַ��Ϣ
	 */
	public int update(Address addr);
	
	/**
	 * �����û���Ż�ȡ��ַ��Ϣ
	 */
	public List<Address> getAddrInfo(int userId);
	
}
