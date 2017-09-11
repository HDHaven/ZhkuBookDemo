package com.haven.service.implement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haven.dao.CartDAO;
import com.haven.model.Book;
import com.haven.model.Cart;
import com.haven.service.interfaces.CartService;

@Service("cartService")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class CartServiceImpl implements CartService {

	@Resource(name="cartDao")
	private CartDAO cartDao;
//	public void setCartDao(CartDAO cartDao) {
//		this.cartDao = cartDao;
//	}
	
	@Override
	public boolean addInCart(String userName, Book book, int bookCount) {
		// 1.�����û�����ͼ�����жϹ��ﳵ�Ƿ��Ѿ�����
		List<Cart> cartList = cartDao.getCart(new Cart(book.getBookId(), userName, null, null, 0.0, 0, null)); 
		Cart cart = null;
		if(cartList != null && !cartList.isEmpty()) {
			// ���ﳵ�Ѵ��ڣ�����+1
			cart = cartList.get(0);
			cart.setBookCount(cart.getBookCount() + 1);
			if(cartDao.update(cart) > 0)
				return true;
		} else {
			// �����ڣ�����ӽ����ﳵ
			cart = new Cart(0, userName, book.getStoreName(), book.getBookName(), book.getBookPrice(), bookCount, book.getBookImage());
			if(cartDao.insert(cart) > 0)
				return true;
		}
		
		return false;
	}

	@Override
	public Map<String, List<Cart>> getCartInfo(String userName) {
		// �����û�����ȡ������
		List<Cart> storeList = cartDao.getStoreName(userName);
		if(storeList == null || !storeList.isEmpty())
			return null;	// ���ﳵΪ�գ�����null��
		Map<String, List<Cart>> map = new HashMap<String, List<Cart>>();
		for (Cart c : storeList) {
			String storeName = c.getStoreName();
			Cart cart = new Cart();
			cart.setUserName(userName);
			cart.setStoreName(storeName);
			// �����û����͵�������ȡ���ﳵ��Ϣ
			List<Cart> cartList = cartDao.getCart(cart);
			// �����������Ӧ�Ĺ��ﳵ��Ʒ
			map.put(storeName, cartList);
		}
		
		return map;
	}

	@Override
	public boolean deleteCart(String[] ids) {
		// 1.�ж��ǵ���ɾ����������ɾ��
		if(ids != null && ids.length == 1) {
			// ����ɾ��
			int id = Integer.parseInt(ids[0]);
			if(cartDao.deleteOne(id) > 0)
				return true;
		} else {
			// ����ɾ��
			int[] idss = new int[ids.length];
			for(int i = 0; i < ids.length; i++)
				idss[i] = Integer.parseInt(ids[i]);
			if(cartDao.deleteBatch(idss) == ids.length)
				return true;
		}
		
		return false;
	}

	@Override
	public boolean updateCart(String cartId, String bookCount) {
		Cart cart = new Cart();
		cart.setCartId(Integer.parseInt(cartId));
		cart.setBookCount(Integer.parseInt(bookCount));
		if(cartDao.update(cart) > 0)
			return true;
		return false;
	}

}
