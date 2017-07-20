package com.haven.interfaces;

import java.util.List;

import com.haven.model.User;

/**
 *  ��User.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
public interface UserInterface {

	/**
	 * �û�ע��
	 */
	public int register(User user);
	
	/**
	 * ɾ�������û�
	 */
	public int deleteOne(int userId);
	
	/**
	 * ����ɾ���û�
	 */
	public int deleteBatch(List<Integer> ids);
	
	/**
	 * �޸��û���Ϣ
	 */
	public int update(User user);
	
	/**
	 * ��ȡ�û���Ϣ
	 */
	public List<User> getUserInfo(User user);
	
}
