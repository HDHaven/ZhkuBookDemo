package com.haven.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.Address;

/**
 * ��Address.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("addressDao")
@Scope("prototype")
public interface AddressDAO {

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
	 * �޸ĵ�ַ��Ϣ�����ݶ�������޸�������Ϣ
	 */
	public int update(Address addr);
	
	/**
	 * �����û���Ż�ȡ��ַ��Ϣ
	 */
	public List<Address> getAddrInfo(int userId);
	
	/**
	 * �µ�ʱѡ���ַ
	 */
	public Address chooseAddr(int addrId);
	
}
