package com.haven.daotest;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.dao.AddressDAO;
import com.haven.model.Address;
import com.haven.util.MyBatisUtil;

public class AddressTest {

	private SqlSession sqlSession = null;
	private AddressDAO ai = null;
	
	@Test
	public void testAddress_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			 ai = sqlSession.getMapper(AddressDAO.class);
			 Address addr = new Address(1, "�㶫ʡ������", "����������·500��", "18814142805", "�ƻ���");
			 int count = ai.insert(addr);
			 System.out.println("����������"+ count);
			 System.out.println("���صı�ţ�"+ addr.getAddrId());
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testAddress_delete() {
		try {
			sqlSession = MyBatisUtil.openSession();
			 ai = sqlSession.getMapper(AddressDAO.class);
			 int count = ai.deleteOne(2);
			 System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testAddress_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			 ai = sqlSession.getMapper(AddressDAO.class);
			 int count = ai.deleteBatch(new int[]{3});
			 System.out.println("ɾ��������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testAddress_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			 ai = sqlSession.getMapper(AddressDAO.class);
			 Address addr = new Address();
			 addr.setAddrId(1);
			 addr.setAddrProvince("�㶫ʡï���л�����");
			 addr.setAddrDetail("�����е�һ��ѧ");
			 addr.setAddrPhone("15800000000");
			 addr.setAddrConsinee("�����");
			 int count = ai.update(addr);
			 System.out.println("�޸�������"+ count);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testAddress_getAddrInfo() {
		try {
			sqlSession = MyBatisUtil.openSession();
			 ai = sqlSession.getMapper(AddressDAO.class);
			 List<Address> addrList = ai.getAddrInfo(1);
			 if(addrList != null && !addrList.isEmpty()) {
				 for (Address a : addrList) {
					System.out.println("�ջ���ַ��"+ a.getAddrProvince() +" "+ a.getAddrDetail());
					System.out.println("�ջ��绰��"+ a.getAddrPhone());
					System.out.println("�ջ��ˣ�"+ a.getAddrConsinee());
					System.out.println("------------------------");
				}
			 }
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
}
