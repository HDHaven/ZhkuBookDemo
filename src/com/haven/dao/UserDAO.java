package com.haven.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.haven.model.User;

/**
 *  ��User.xml�ļ���Ӧ�Ľӿڣ�������ӦXML�ļ��е���ɾ�Ĳ����
 */
@Repository("userDao")
@Scope("prototype")
public interface UserDAO {

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
	public int deleteBatch(int[] ids);
	
	/**
	 * �޸��û���Ϣ
	 */
	public int update(User user);
	
	/**
	 * ��ȡ�û���Ϣ
	 */
	public List<User> getUserInfo(User user);
	
	/**
	 * ���ڹ���Ա�鿴�û���Ϣ����ҳ��ʾ
	 */
	public List<User> getUserByPage(Map<String, Object> parameter);
	
}
