package com.haven.daotest;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.dao.StoreDAO;
import com.haven.dao.TempStoreDAO;
import com.haven.model.Store;
import com.haven.model.TempStore;
import com.haven.util.MyBatisUtil;

public class StoreTest {

	private SqlSession sqlSession = null;
	private TempStoreDAO ti = null;
	private StoreDAO si = null;
	
	@Test
	public void testTempStore_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			TempStore ts = new TempStore("Haven", "�������", "�����", "/dangdangshucheng.jpg", "�������");
			int count = ti.insert(ts);
			System.out.println("����������"+ count);
			System.out.println("���ر�ţ�"+ ts.getTempStoreId());
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testTempStore_delete() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			// ����ɾ��
//			int count = ti.deleteOne(4);
//			System.out.println("ɾ��������"+ count);
			// ����ɾ��
			int count = ti.deleteBatch(new int[]{2,3,5});
			System.out.println("ɾ��������"+ count);
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTempStore_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			TempStore ts = new TempStore();
			ts.setTempStoreId(6);
			ts.setTempStoreState("ʧ��");
			int count = ti.update(ts);
			System.out.println("�޸�������"+ count);
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testTempStore_getTempStoreInfo() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			// ��ȡ������ʱ����
//			List<TempStore> tsList = ti.getTempStoreInfo(null);
			// ���������˻������״̬��ȡ
			TempStore tStore = new TempStore();
//			tStore.setUserName("Haven");
			tStore.setTempStoreState("�������");
			List<TempStore> tsList = ti.getTempStoreInfo(tStore);
			for (TempStore ts : tsList) {
				System.out.println("��������"+ ts.getTempStoreName());
				System.out.println("�����ˣ�"+ ts.getUserName());
				System.out.println("���״̬��"+ ts.getTempStoreState());
				System.out.println("------------------");
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	@Test
	public void testStore_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			si = sqlSession.getMapper(StoreDAO.class);
			// ��ȡ��ʱ���������״̬Ϊ��ͨ��������ʱ���̣�������̱���
			TempStore ts = new TempStore();
			ts.setTempStoreState("ͨ��");
			List<TempStore> tsList = ti.getTempStoreInfo(ts);
			for (TempStore tStore : tsList) {
				Store s = new Store(tStore.getTempStoreName(), tStore.getUserName(), 0, 0, 0, 0, 0, 
						tStore.getTempStoreDescript(), tStore.getTempStoreLicense(), "Ӫҵ��", "2017-07-20 16:09");
				int count = si.insert(s);
				System.out.println("����������"+ count);
				System.out.println("���ر�ţ�"+ s.getStoreId());
				System.out.println("---------------------");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testStore_delete() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ti = sqlSession.getMapper(TempStoreDAO.class);
			si = sqlSession.getMapper(StoreDAO.class);
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testStore_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			si = sqlSession.getMapper(StoreDAO.class);
			Store s = new Store();
			// �޸ĵ���״̬
			s.setStoreName("�������");
//			s.setStoreState("��Ϣ��");
			// �޸������������۶�
//			s.setStoreSaleNum(1);
//			s.setStoreSale(49.99);
			// �޸ĵ�������
			s.setStoreScore(4);
			System.out.println("�޸�������"+ si.update(s));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testStore_getStoreInfo() {
		try {
			sqlSession = MyBatisUtil.openSession();
			si = sqlSession.getMapper(StoreDAO.class);
			Store s = new Store();
			// �����û�����ȡ������Ϣ
//			s.setUserName("Haven");
			// ���ݵ�������ȡ
//			s.setStoreName("������");
			List<Store> sList = si.getStoreInfo(s);
			for (Store ss : sList) {
				System.out.println("��������"+ ss.getStoreName());
				System.out.println("������"+ ss.getUserName());
				System.out.println("����������"+ ss.getStoreDescript());
				System.out.println("---------------");
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
