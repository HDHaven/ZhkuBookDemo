package com.haven.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;

import com.haven.service.interfaces.AdminService;
import com.haven.service.interfaces.OrderService;

@Controller
@Scope("request")
@RequestMapping(value = "admin")
//@SessionAttributes({ "userList", "tempStoreList", "userPage", "tempStorePage", "storeList", "storePage",
//		"userOrderList", "userOrderPage", "storeOrderList", "storeOrderPage", "userOrderProduct", "userOrderAddress",
//		"storeOrderProduct", "storeOrderAddress" })
public class AdminController {

	@Resource
	private AdminService adminService;

	@Resource
	private OrderService orderService;

	// ���������ҳ
	@RequestMapping(value = "index")
	public String index() {
		return "admin/index";
	}
	
	// �鿴�û�������Ϣ
	@RequestMapping(value = "userInfo")
	public String getUserInfo(String userName, String currentPage, Model model) {
		Map<String, Object> resultMap = adminService.getUser(userName, currentPage);
		if (resultMap != null) {
			model.addAttribute("userList", resultMap.get("userList"));
			model.addAttribute("userPage", resultMap.get("page"));
		}
		if(userName != null && !"".equals(userName))
			model.addAttribute("keyword", userName);// �����ѯ����
		return "admin/user/userInfo";
	}

	// ɾ���û�
	@RequestMapping(value = "deleteUser")
	public String deleteUser(String[] id, String currentPage, String userName, Model model) {
		Map<String, Object> resultMap = adminService.deleteUser(id, userName, currentPage);
		if (resultMap == null) {
			// ɾ��ʧ�ܣ���ʾ������Ϣ
			model.addAttribute("deleteError", "ɾ���û�ʧ��");
		} else {
			// ɾ���ɹ������»�ȡ�û���Ϣ
			model.addAttribute("userList", resultMap.get("userList"));
			model.addAttribute("userPage", resultMap.get("page"));
		}

		return "admin/user/userInfo";
	}

	// �޸��û�����
	@RequestMapping(value = "updateUser")
	public String udpateUser(String userId, String userType, String currentPage, String userName, Model model) {
		Map<String, Object> resultMap = adminService.updateUserType(userId, userType, userName, currentPage);
		if (resultMap == null) {
			// �޸�ʧ��
			model.addAttribute("updateError", "�޸��û�ʧ��");
		} else {
			// �޸ĳɹ������»�ȡ�û���Ϣ
			model.addAttribute("userList", resultMap.get("userList"));
			model.addAttribute("userPage", resultMap.get("page"));
		}
		return "admin/user/userInfo";
	}

	// �鿴�û�����
	@RequestMapping(value = "userOrderInfo")
	public String getUserOrder(String userName, String currentPage, Model model) {
		Map<String, Object> resultMap = orderService.getOrderInfo(userName, null, null, currentPage);
		if (resultMap != null) {
			model.addAttribute("userOrderList", resultMap.get("orderList"));
			model.addAttribute("userOrderPage", resultMap.get("page"));
		}
		// �����û�����
		model.addAttribute("userName", userName);
		return "admin/user/order/orderInfo";
	}

	// �鿴�û���������
	@RequestMapping(value = "userOrderDetail")
	public String getUserOrderDetail(String orderId, String addrId, Model model) {
		Map<String, Object> resultMap = orderService.getOrderDetail(orderId, addrId);
		if (resultMap != null) {
			model.addAttribute("userOrderProduct", resultMap.get("productList"));
			model.addAttribute("userOrderAddress", resultMap.get("address"));
		}
		return "admin/user/order/orderDetail";
	}

	// ��ȡ��ʱ������Ϣ
	@RequestMapping(value = "tempStoreInfo")
	public String getTempStoreInfo(String tempStoreState, String currentPage, Model model) {
		Map<String, Object> resultMap = adminService.getTempStore(tempStoreState, currentPage);
		if (resultMap != null) {
			model.addAttribute("tempStoreList", resultMap.get("tempStoreList"));
			model.addAttribute("tempStorePage", resultMap.get("page"));
		}
		return "admin/tempStore/tempStoreInfo";
	}

	// ɾ����ʱ������Ϣ
	@RequestMapping(value = "deleteTempStore")
	public String deleteTempStore(String[] id, String tempStoreState, String currentPage, Model model) {
		Map<String, Object> resultMap = adminService.deleteTempStore(id, tempStoreState, currentPage);
		if (resultMap == null) {
			// ɾ��ʧ��
			model.addAttribute("deleteError", "ɾ����ʱ����ʧ��");
		} else {
			// ɾ���ɹ��������б�
			model.addAttribute("tempStoreList", resultMap.get("tempStoreList"));
			model.addAttribute("tempStorePage", resultMap.get("page"));
		}
		return "admin/tempStore/tempStoreInfo";
	}

	// �޸���ʱ������˽��ȣ�״̬��
	@RequestMapping(value = "updateTempStore")
	public String updateTempStore(String tempStoreId, String newState, String tempStoreState, String currentPage,
			Model model) {
		Map<String, Object> resultMap = adminService.updateTempStore(tempStoreId, newState, tempStoreState,
				currentPage);
		if (resultMap == null) {
			// �޸�ʧ��
			model.addAttribute("upateError", "�޸���ʱ����ʧ��");
		} else {
			// �޸ĳɹ�
			model.addAttribute("tempStoreList", resultMap.get("tempStoreList"));
			model.addAttribute("tempStorePage", resultMap.get("page"));
		}
		return "admin/tempStore/tempStoreInfo";
	}

	// �޸ĵ���״̬
	@RequestMapping(value = "updateStoreState")
	public String updateStoreState(String storeName, String storeState, String currentPage, Model model) {
		Map<String, Object> resultMap = adminService.updateStoreState(storeName, storeState, currentPage);
		if (resultMap == null) {
			// �޸�ʧ��
			model.addAttribute("updateError", "�޸ĵ���״̬ʧ��");
		} else {
			// �޸ĳɹ�
			model.addAttribute("storeList", resultMap.get("storeList"));
			model.addAttribute("storePage", resultMap.get("page"));
		}
		return "admin/store/storeInfo";
	}

	// ��ȡ������Ϣ
	@RequestMapping(value = "StoreInfo")
	public String getStore(String storeName, String currentPage, Model model) {
		Map<String, Object> resultMap = adminService.getAllStore(storeName, currentPage);
		if (resultMap != null) {
			model.addAttribute("storeList", resultMap.get("storeList"));
			model.addAttribute("storePage", resultMap.get("page"));
		}
		return "admin/store/storeInfo";
	}

	// �鿴���̶���
	@RequestMapping(value = "storeOrder")
	public String getStoreOrder(String storeName, String currentPage, Model model) {
		Map<String, Object> resultMap = orderService.getOrderInfo(null, storeName, null, currentPage);
		if (resultMap != null) {
			model.addAttribute("storeOrderList", resultMap.get("orderList"));
			model.addAttribute("storeOrderPage", resultMap.get("page"));
		}
		return "admin/store/order/orderInfo";
	}

	// �鿴���̶�������
	@RequestMapping(value = "storeOrderDetail")
	public String getStoreOrderDetail(String orderId, String addrId, Model model) {
		Map<String, Object> resultMap = orderService.getOrderDetail(orderId, addrId);
		if (resultMap != null) {
			model.addAttribute("storeOrderProduct", resultMap.get("productList"));
			model.addAttribute("storeOrderAddress", resultMap.get("address"));
		}
		return "admin/store/order/orderDetail";
	}

}
