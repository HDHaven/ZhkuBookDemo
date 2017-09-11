package com.haven.daotest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.dao.CartDAO;
import com.haven.model.Cart;
import com.haven.util.MyBatisUtil;

public class CartTest {

	private SqlSession sqlSession = null;
	private CartDAO ci = null;
	
	@Test
	public void testCart_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(CartDAO.class);
			// �����ﳵ���в���һ����¼������ǰ�жϸ�ͼ���Ƿ���ڣ������ڣ�������+1����
			Cart cart = new Cart(9, "Haven", "��������", "���������", 39.99, 1, "/daodeqingcaolun.jpg");
			List<Cart> cartList = ci.getCart(cart);
			if(cartList != null && !cartList.isEmpty()) {
				// ���ڣ�����+1
				Cart c = cartList.get(0);
				int bookCount = c.getBookCount();
				System.out.println(bookCount);
				c.setBookCount(bookCount+1);
				int count = ci.update(c);
				System.out.println("�޸�������"+ count);
				System.out.println("�޸�id��"+ c.getCartId());
			} else {
				int count = ci.insert(cart);
				System.out.println("����������"+ count);
				System.out.println("���ص�id��"+ cart.getCartId());
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
	public void testCart_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(CartDAO.class);
			int count = ci.deleteOne(4);
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
	public void testCart_deleteBatch() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(CartDAO.class);
			int count = ci.deleteBatch(new int[]{5,6,7,8,9,10,11});
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
	public void testCart_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(CartDAO.class);
			Cart cart = new Cart();
			cart.setCartId(1);
			cart.setBookCount(3);
			int count = ci.update(cart);
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
	public void testCart_getCart() {
		try {
			sqlSession = MyBatisUtil.openSession();
			ci = sqlSession.getMapper(CartDAO.class);
			Cart cart = new Cart();
			// �����û�����ȡ���ﳵ��Ϣ
			String userName = "Haven";
			cart.setUserName(userName);
			List<Cart> cartList = ci.getCart(cart);
			Map<String, List<Cart>> cartMap = new HashMap<String, List<Cart>>();
			for (Cart c : cartList) {
				// �����̷���
				String storeName = c.getStoreName();
				if(!cartMap.containsKey(storeName)) {
					Cart sCart = new Cart();
					sCart.setStoreName(storeName);
					sCart.setUserName(userName);
					List<Cart> cList = ci.getCart(sCart);
					cartMap.put(storeName, cList);
				}
			}
			// �����֤
			for(String key : cartMap.keySet()) {
				System.out.println("��������"+ key);
				System.out.println("��Ʒ��Ϣ���£�");
				for(Cart cc : cartMap.get(key)) {
					System.out.println("������"+ cc.getBookName());
					System.out.println("���ۣ�"+ cc.getBookPrice());
					System.out.println("������"+ cc.getBookCount());
					System.out.println("-------------------------");
				}
				System.out.println("==============================");
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
