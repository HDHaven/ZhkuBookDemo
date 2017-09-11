package com.haven.service.implement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haven.bean.PageBean;
import com.haven.dao.AddressDAO;
import com.haven.dao.BookDAO;
import com.haven.dao.CartDAO;
import com.haven.dao.OrderDAO;
import com.haven.dao.OrderProductDAO;
import com.haven.dao.StoreDAO;
import com.haven.model.Address;
import com.haven.model.Book;
import com.haven.model.Cart;
import com.haven.model.Order;
import com.haven.model.OrderProduct;
import com.haven.model.Store;
import com.haven.service.interfaces.OrderService;

@Service("orderService")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class OrderServiceImpl implements OrderService {

	@Resource(name="orderDao")
	private OrderDAO orderDao;
	
	@Resource
	private CartDAO cartDao;
	
	@Resource
	private BookDAO bookDao;
	
	@Resource
	private StoreDAO storeDao;

	@Override
	public Map<String, List<Cart>> generateOrder(String[] ids) {
		if(ids == null || ids.length <= 0)
			return null;
		Map<String, List<Cart>> map = new HashMap<String, List<Cart>>();// ����������Ʒ��Ϣ�б��Ӧ
		int[] idss = new int[ids.length];
		for(int i = 0; i < ids.length; i++)
			idss[i] = Integer.parseInt(ids[i]);
		List<Cart> cartList = cartDao.getCartById(idss);
		// ������������
		// ����ȷ���ж��ٵ���
		Set<String> storeSet = new HashSet<String>();
		for(Cart c : cartList)
			storeSet.add(c.getStoreName());
		String[] storeArr = (String[]) storeSet.toArray();
		for(int i = 0; i < storeArr.length; i++) {
			// ��������
			String storeName = storeArr[i];
			List<Cart> storeList = new ArrayList<Cart>();
			for(int j = 0; j < cartList.size(); j++) {
				// ����������Ʒ���ҵ����ڸõ��̵���Ʒ�����빺���嵥
				Cart c = cartList.get(j);
				if(c.getStoreName().equals(storeName)) {
					// ���ڸõ��̣�����
					storeList.add(c);
				}
			}
			// ��Ϊһ����������
			map.put(storeName, storeList);
		}
		
		return map.size()>0 ? map : null;
	}

	@Override
	public boolean addOrder(Map<String, List<Cart>> cartMap, String addrId, String userName) {
		if(cartMap == null || cartMap.size() <= 0)
			return false;
		// ���ö������ڡ�״̬���ջ���ַ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String orderDate = sdf.format(new Date());
		String orderState = "������";
		int addressId = Integer.parseInt(addrId);
		// ������Ʒ�б��������µ�
		for(String storeName :cartMap.keySet()) {
			List<Cart> cartList = cartMap.get(storeName);
			// ��ӵ�����Ʒ��Ϣ
			double orderPrice = 0.0;
			int saleNum = 0;
			for (Cart cart : cartList) {
				// ͳ�ƶ����ܼۺ�����
				orderPrice += cart.getBookPrice()*cart.getBookCount();
				saleNum += cart.getBookCount();
			}
			Order o = new Order(storeName, orderDate, orderPrice, userName, orderState, addressId);
			if(orderDao.insert(o) <= 0)
				return false;
			// ��Ӷ����ɹ�����ȡ�������
			int orderId = o.getOrderId();
			// �����Ʒ��Ϣ��˳���ȡ���ﳵ���
			List<OrderProduct> productList = new ArrayList<OrderProduct>();
			int[] ids = new int[cartList.size()];
			for(int i = 0; i < cartList.size(); i++) {
				Cart c = cartList.get(i);
				ids[i] = c.getCartId();
				OrderProduct product = new OrderProduct(orderId, c.getBookId(), c.getBookName(), c.getBookPrice(), c.getBookCount(), c.getBookImage());
				productList.add(product);
			}
			if(productDao.insertBatch(productList) != productList.size())
				return false;
			// ��Ӷ�����Ʒ�ɹ���ɾ�����ﳵ��Ϣ
			if(cartDao.deleteBatch(ids) != ids.length)
				return false;
			// ɾ���ɹ����޸Ķ�Ӧͼ����������Ϳ����
			for(OrderProduct product : productList) {
				Book book = new Book();
				book.setBookId(product.getBookId());
				book.setBookSaleNum(product.getProductCount());
				book.setBookSumNum(product.getProductCount());
				if(bookDao.updateFromOrder(book) <= 0)
					return false;
				// �޸ĳɹ��� �޸Ķ�Ӧ���̵����۶��������
				Store s = new Store();
				s.setStoreName(storeName);
				s.setStoreSale(orderPrice);
				s.setStoreSaleNum(saleNum);
				if(storeDao.update(s) <= 0)
					return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean updateOrder(String orderId, String orderState) {
		Order o = new Order();
		o.setOrderId(Integer.parseInt(orderId));
		o.setOrderState(orderState);
		int retCount = orderDao.update(o);
		return retCount>0 ? true : false;
	}

	@Override
	public Map<String, Object> getOrderInfo(String userName, String storeName, String orderState, String currentPage) {
		Map<String, Object> parameter = new HashMap<String, Object>();
		PageBean pb = new PageBean();
		currentPage = currentPage == null ? "1" : currentPage;
		int curPage = Integer.parseInt(currentPage);
		pb.setCurrentPage(curPage);// ���õ�ǰҳ
		parameter.put("page", pb);
		Order o = new Order();
		// ���ò�ѯ����
		o.setUserName(userName);
		o.setOrderState(orderState);
		o.setStoreName(storeName);
		parameter.put("order", o);
		List<Order> orderList = orderDao.getOrderInfoByPage(parameter);
		if(orderList != null && orderList.size() > 0) {
			parameter.put("orderList", orderList);
			return parameter;
		}
		return null;
	}

	@Resource
	private OrderProductDAO productDao;

	@Resource
	private AddressDAO addressDao;
	
	@Override
	public Map<String, Object> getOrderDetail(String orderId, String addrId) {
		Map<String, Object> map = new HashMap<String, Object>();
		// ��ȡ������Ʒ��Ϣ
		List<OrderProduct> productList = productDao.getOrderProduct(Integer.parseInt(orderId));
		// ��ȡ�����ջ���ַ
		Address addr = addressDao.chooseAddr(Integer.parseInt(addrId));
		if(productList != null && !productList.isEmpty() && addr != null) {
			map.put("productList", productList);
			map.put("address", addr);
			return map;
		}
		
		return null;
	}

}
