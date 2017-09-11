package com.haven.daotest;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.dao.UserDAO;
import com.haven.model.User;
import com.haven.util.MyBatisUtil;

public class UserInterfaceTest {

	private SqlSession sqlSession = null;

	@Test
	public void testUser_register() {
		try {
			sqlSession = MyBatisUtil.openSession();
			UserDAO ui = sqlSession.getMapper(UserDAO.class);
			User user = new User("Haven", "asdfasdfasdf", "2", null);
			// ע��ǰ�ж��û����Ƿ��Ѵ���
			List<User> userList = ui.getUserInfo(user);
			if (userList != null && !userList.isEmpty()) {
				System.out.println("�û����Ѵ��ڣ�");
			} else {
				int count = ui.register(user);
				System.out.println("�����������" + count);
				System.out.println("�û���ţ�" + user.getUserId());
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void testUser_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			UserDAO ui = sqlSession.getMapper(UserDAO.class);
			int count = ui.deleteOne(4);
			System.out.println("ɾ��������" + count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void testUser_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			UserDAO ui = sqlSession.getMapper(UserDAO.class);
			int[] ids = {2,3};
			int count = ui.deleteBatch(ids);
			System.out.println("ɾ����������" + count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void testUser_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			UserDAO ui = sqlSession.getMapper(UserDAO.class);
			User user = new User();
			user.setUserId(1);
			user.setUserName("Jayin");
			user.setPassword("asdfasdf");
			user.setUserType("1");
			int count = ui.update(user);
			System.out.println("�޸ĵ�������" + count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
	}

	@Test
	public void testUser_getUserInfo() {
		try {
			sqlSession = MyBatisUtil.openSession();
			UserDAO ui = sqlSession.getMapper(UserDAO.class);
			User user = new User();
			List<User> userList = null;
			// ��ѯ�����û�
			user.setUserName("Jayin");
			user.setPassword("asdfasdf");
			userList = ui.getUserInfo(user);
			if (userList.size() == 1) {
				user = userList.get(0);
				System.out.println("�û�����" + user.getUserName());
				System.out.println("���룺" + user.getPassword());
				System.out.println("�û����ͣ�" + user.getUserType());
			} else {
				System.out.println("��ѯ���Ϊ��!");
			}
			// ��ѯ����û�
//			userList = ui.getUserInfo(null);
//			if(userList != null && !userList.isEmpty()) {
//				for (User u : userList) {
//					System.out.println("�û���ţ�"+ u.getUserId());
//					System.out.println("�û�����"+ u.getUserName());
//					System.out.println("���룺"+ u.getPassword());
//					System.out.println("�û����ͣ�"+ u.getUserType());
//					System.out.println("=================================");
//				}
//			} else {
//				System.out.println("��ѯ���Ϊ�գ�");
//			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
	}

}
