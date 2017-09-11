package com.haven.daotest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.haven.bean.PageBean;
import com.haven.dao.BookDAO;
import com.haven.dao.CartDAO;
import com.haven.dao.OrderDAO;
import com.haven.dao.OrderProductDAO;
import com.haven.model.Address;
import com.haven.model.Book;
import com.haven.model.Cart;
import com.haven.model.Order;
import com.haven.model.OrderProduct;
import com.haven.util.MyBatisUtil;

public class OrderTest {

	private SqlSession sqlSession = null;
	private OrderDAO oi = null;
	private OrderProductDAO pi = null;
	private CartDAO ci = null;
	private BookDAO bi = null;
	
	@Test
	public void testOrder_insert() {
		try {
			sqlSession = MyBatisUtil.openSession();
			oi = sqlSession.getMapper(OrderDAO.class);
			pi = sqlSession.getMapper(OrderProductDAO.class);
			ci = sqlSession.getMapper(CartDAO.class);
			bi = sqlSession.getMapper(BookDAO.class);
			// ���ɶ���
			int orderCount = 0;	// ͳ�ƶ�������
			Map<String, List<Cart>> cartMap = getFromCart(ci);
			for(String storeName : cartMap.keySet()) {
				Order o = new Order(storeName, "2017-07-19 21:37", 99.99, "Haven", "���ڳ���", 1, null, null);
				int count = oi.insert(o);
				orderCount += count;
				int orderId = o.getOrderId();
				List<Cart> cartList = cartMap.get(storeName);
				List<OrderProduct> proList = changeCartToProduct(cartMap.get(storeName), orderId);
				int proCount = pi.insertBatch(proList);
				// ����ɹ���ɾ�����ﳵ��Ϣ���޸�ͼ����������Լ������
				int[] ids = new int[cartList.size()];
				for(int i = 0; i < cartList.size(); i++) {
					Cart cc = cartList.get(i);
					ids[i] = cc.getCartId();
					Book book = new Book();
					book.setBookId(cc.getBookId());
					book.setBookSaleNum(cc.getBookCount());
					book.setBookSumNum(cc.getBookCount());
					System.out.println("�޸�ͼ��������"+ bi.updateFromOrder(book));
				}
				System.out.println("ɾ�����ﳵ��Ϣ��"+ ci.deleteBatch(ids));
				
				System.out.println("������ţ�"+ orderId +","+ "������Ʒ���ࣺ"+ proCount);
				System.out.println("��Ʒ��Ϣ���£�");
				for (OrderProduct pro : proList) {
					System.out.println("��Ʒ���ƣ�"+ pro.getProductName());
					System.out.println("��Ʒ���ۣ�"+ pro.getProductPrice());
					System.out.println("��Ʒ������"+ pro.getProductCount());
					System.out.println("-------------------------");
				}
				System.out.println("===========================");
			}
			System.out.println("���붩��������"+ orderCount);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testOrder_deleteOne() {
		try {
			sqlSession = MyBatisUtil.openSession();
			oi = sqlSession.getMapper(OrderDAO.class);
			pi = sqlSession.getMapper(OrderProductDAO.class);
			int orderCount;
			int proCount;
			// ����ɾ��
//			int orderId = 8;
//			orderCount = oi.deleteOne(orderId);
//			proCount = pi.deleteOne(orderId);
			// ����ɾ��
			int[] ids = { 5, 6, 7};
			orderCount = oi.deleteBatch(ids);
			proCount = pi.deleteBatch(ids);
			System.out.println("ɾ����������"+ orderCount);
			System.out.println("ɾ����Ʒ����"+ proCount);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testOrder_update() {
		try {
			sqlSession = MyBatisUtil.openSession();
			oi = sqlSession.getMapper(OrderDAO.class);
			Order o = new Order();
			o.setOrderId(1);
			o.setOrderState("������");
			System.out.println("�޸�������"+ oi.update(o));
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	@Test
	public void testOrder_getOrderInfoByPage() {
		try {
			sqlSession = MyBatisUtil.openSession();
			oi = sqlSession.getMapper(OrderDAO.class);
			pi = sqlSession.getMapper(OrderProductDAO.class);
			Order o = new Order();
			o.setUserName("Haven");
//			o.setStoreName("������");
			o.setOrderState("���ڳ���");
			PageBean pb = new PageBean();
			pb.setCurrentPage(1);
			Map<String, Object> parameter = new HashMap<String, Object>();
			parameter.put("order", o);
			parameter.put("page", pb);
			List<Order> orderList = oi.getOrderInfoByPage(parameter);
			// ѭ����ӡ����
			for (Order oo : orderList) {
				int orderId = oo.getOrderId();
				System.out.println("������Ϣ���£�");
				System.out.println("  ������ţ�"+ orderId);
				System.out.println("  �µ����ڣ�"+ oo.getOrderDate());
				System.out.println("  ����״̬��"+ oo.getOrderState());
				System.out.println("  �����ܼۣ�"+ oo.getOrderPrice());
				System.out.println("  �µ��û���"+ oo.getUserName());
				System.out.println("  �������̣�"+ oo.getStoreName());
				List<OrderProduct> proList = pi.getOrderProduct(orderId);
				System.out.println("��������Ʒ��Ϣ���£�");
				for (OrderProduct pro : proList) {
					System.out.println("  ��Ʒ���ƣ�"+ pro.getProductName());
					System.out.println("  ��Ʒ���ۣ�"+ pro.getProductPrice());
					System.out.println("  ����������"+ pro.getProductCount());
					System.out.println("-----------------------");
				}
				Address addr = oi.getOrderAddr(orderId);
				System.out.println("������ַ��Ϣ���£�");
				System.out.println("  ���͵�ַ��"+ addr.getAddrProvince() +" "+ addr.getAddrDetail() );
				System.out.println("  ���͵绰��"+ addr.getAddrPhone());
				System.out.println("  �ջ��ˣ�"+ addr.getAddrConsinee());
				System.out.println("=============================");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			if(sqlSession != null)
				sqlSession.close();
		}
	}
	
	// �ӹ����л�ȡҪ�������Ʒ��Ϣ
	private Map<String, List<Cart>> getFromCart(CartDAO ci) {
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
		
		return cartMap;
	}
	
	// �����ﳵת������Ʒ
	private List<OrderProduct> changeCartToProduct(List<Cart> cartList, int orderId) {
		List<OrderProduct> proList = new ArrayList<OrderProduct>();
		for(Cart c : cartList) {
			OrderProduct pro = new OrderProduct();
			pro.setBookId(c.getBookId());
			pro.setOrderId(orderId);
			pro.setProductCount(c.getBookCount());
			pro.setProductImage(c.getBookImage());
			pro.setProductName(c.getBookName());
			pro.setProductPrice(c.getBookPrice());
			proList.add(pro);
		}
		return proList;
	}
	
}
