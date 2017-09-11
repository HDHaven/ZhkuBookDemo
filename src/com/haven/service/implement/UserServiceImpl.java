package com.haven.service.implement;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.haven.dao.AddressDAO;
import com.haven.dao.StoreDAO;
import com.haven.dao.TempStoreDAO;
import com.haven.dao.UserDAO;
import com.haven.model.Address;
import com.haven.model.Store;
import com.haven.model.TempStore;
import com.haven.model.User;
import com.haven.service.interfaces.UserService;

@Service("userService")
@Scope("prototype")
@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class UserServiceImpl implements UserService {

	// ���û���Ĳ���
	
	@Resource(name="userDao")
	private UserDAO userDao;
//	public void setUserDao(UserDAO userDao) {
//		this.userDao = userDao;
//	}

	@Override
	public User login(String userName, String password) {
		if(userName != null && !"".equals(userName) && password != null && !"".equals(password))
			return isExisted(userName, password);
		return null;
	}

	@Override
	public User register(String userName, String password, String confirmPassword) {
		if(!password.equals(confirmPassword))
			return null;	// �������벻һ�£�ֱ�ӷ���null
		// ����һ�£��ж��û����Ƿ��ѱ�ռ��
		if(isExisted(userName, password) == null) {
			// û��ռ�ã���ע���û�
			User user = new User(userName, password, "1", null);
			if(userDao.register(user) > 0)
				return user;	// ע��ɹ��������û�����
		}
		
		return null;
	}

	@Override
	public boolean updatePassword(int userId, String userName, String oldPassword, String newPassword,
			String confirmNewPassword) {
		boolean flag = false;
		if(!newPassword.equals(confirmNewPassword)) {
			// 1.�ж������������Ƿ�һ��
			flag = false;
		} else if(isExisted(userName, oldPassword) == null) {
			// 2.�жϾ������Ƿ���ȷ
			flag = false;
		} else {
			// 3.�ж������޸�����
			User user = new User();
			user.setUserId(userId);
			user.setPassword(newPassword);
			if(userDao.update(user) > 0)
				flag = true;	// �޸�����ɹ�
		}
		return flag;
	}
	
	// �ж��û��Ƿ����
	private User isExisted(String userName, String password) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		List<User> userList = userDao.getUserInfo(user);
		if(userList != null && !userList.isEmpty())
			return userList.get(0);
		return null;
	}

	// �Ե�ַ��Ĳ���
	
	@Resource(name="addressDao")
	private AddressDAO addrDao;
//	public void setAddrDao(AddressDAO addrDao) {
//		this.addrDao = addrDao;
//	}
	
	@Override
	public Address addAddr(Address a) {
		return addrDao.insert(a) > 0 ? a : null;
	}

	@Override
	public boolean deleteAddr(String[] ids) {
		// 1.�ж���ɾ��һ����¼��������ɾ��
		if(ids != null && ids.length == 1) {
			// ����ɾ��
			if(addrDao.deleteOne(Integer.parseInt(ids[0])) > 0)
				return true;
		} else if(ids.length > 1) {
			// ����ɾ��
			int[] idss = new int[ids.length];
			for(int i = 0; i < ids.length; i++)
				idss[i] = Integer.parseInt(ids[i]);
			if(addrDao.deleteBatch(idss) == ids.length)
				return true;
		}
		
		return false;
	}

	@Override
	public boolean updateAddr(Address a) {
		if(addrDao.update(a) > 0)
			return true;
		return false; 
	}

	@Override
	public List<Address> getAddrInfo(int userId) {
		return addrDao.getAddrInfo(userId);
	}

	@Override
	public Address chooseAddr(String addrId) {
		return addrDao.chooseAddr(Integer.parseInt(addrId));
	}

	// �Ե��̱�Ĳ���
	
	@Resource(name="tempStoreDao")
	private TempStoreDAO tsDao;
	@Resource(name="storeDao")
	private StoreDAO storeDao;
	
//	public void setTsDao(TempStoreDAO tsDao) {
//		this.tsDao = tsDao;
//	}
//
//	public void setStoreDao(StoreDAO storeDao) {
//		this.storeDao = storeDao;
//	}

	@Override
	public TempStore addStore(TempStore ts) {
		// 1.�жϵ������Ƿ����
		Store store = new Store();
		store.setStoreName(ts.getTempStoreName());	// ���ò���
		List<Store> storeList = storeDao.getStoreInfo(store);
		if(storeList != null && !storeList.isEmpty()) {
			// ��������ռ�ã�����null
			return null;
		} else {
			// û��ռ�ã����
			int retCount = tsDao.insert(ts);
			if(retCount > 0) {
				// ��ӳɹ�������ts��
				return ts;
			}
		}
		
		return null;
	}

	@Override
	public Store enterStore(String storeId, String userName) {
		Store store = new Store();
		store.setStoreId(Integer.parseInt(storeId));
		store.setUserName(userName);
		List<Store> storeList = storeDao.getStoreInfo(store);
		if(storeList != null && !storeList.isEmpty())
			return storeList.get(0);
		return null;
	}

	@Override
	public TempStore checkState(String userName) {
		TempStore ts = new TempStore();
		ts.setUserName(userName);
		List<TempStore> tsList = tsDao.getTempStoreInfo(ts);
		if(tsList != null && !tsList.isEmpty())
			return tsList.get(0);
		return null;
	}

}
