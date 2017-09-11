package com.haven.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.haven.model.Address;
import com.haven.model.User;
import com.haven.service.interfaces.UserService;

@Controller
@Scope("request")
//@RequestMapping(value="user")
@SessionAttributes({"user", "addressList"})
public class UserController {

	@Resource
	private UserService userService;
	
	// ��ʾ��¼ҳ��
	@RequestMapping(value="login")
	public String login() {
		return "loginForm";
	}
	// ��ʾע��ҳ��
	@RequestMapping(value="register")
	public String register() {
		return "retister";
	}
	
	// �����û���¼
	@RequestMapping(value="doLogin")
	public String doLogin(String userName, String password, Model model) {
		// ��֤��¼
		User user = userService.login(userName, password);
		if(user == null) {
			// ��¼ʧ�ܣ���ʾ������Ϣ�㣬���ص�¼ҳ��
			model.addAttribute("loginError", "�û������������");
			return "loginForm";
		}
		// ��¼ �ɹ��������û�
		model.addAttribute("user", user);// ����ҳ��ǰ�Ὣuser����session��
		if(user.getUserType().equals("2"))
			return "redirect:/admin/index";	// ����ǹ���Ա������ת��������ҳ
		return "redirect:/index";
	}
	
	// �����û�ע��
	@RequestMapping(value="doRegister")
	public String doRegister(String userName, String password, String confirmPassword, Model model) {
		User user = userService.register(userName, password, confirmPassword);
		if(user == null) {
			// ע��ʧ�ܣ���ʾ������Ϣ������ע��ҳ��
			model.addAttribute("registerError", "ע��ʧ�ܣ��û����ѱ�ռ�ã�");
			return "register";
		}
		// ע��ɹ��������û���Ϣ����ת����ҳ
		model.addAttribute("user", user);
		return "redirect:/index";
	}
	
	// �����޸�����ҳ��
	@RequestMapping(value="user/updatePassword")
	public String updatePassword() {
		return "user/updatePassword";
	}
	
	// �����û��޸�����
	@RequestMapping(value="user/doUpdatePassword")
	public String doUpdatePassword(String oldPassword, String newPassword, String confirmNewPassword, 
			HttpSession session, Model model) {
		User user = (User) session.getAttribute("user");
		if(user == null)	// �û�û�е�¼����ת����¼ҳ��
			return "loginForm";
		if(userService.updatePassword(user.getUserId(), user.getUserName(), oldPassword, newPassword, confirmNewPassword)) {
			// �޸�����ɹ�����ʾ�ɹ���Ϣ
			user.setPassword(newPassword);
			session.setAttribute("user", user);// ��������
			model.addAttribute("updateSusccess", "�ɹ��޸�����");
		} else {
			// �޸�ʧ�ܣ���ʾ������Ϣ
			model.addAttribute("updateError", "ҵ���쳣���޸�����ʧ��");
		}
		
		return "user/updatePassword";
	}
	
	// ��ȡ�û���ַ
	@RequestMapping(value="user/address/getAddress")
	public String addressList(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user == null)
			return "loginForm";// ��¼ʧЧ�����ص�¼����
		// ��ȡ��ַ��Ϣ
		session.setAttribute("addressList", userService.getAddrInfo(user.getUserId()));
		return "user/address/addressList";
	}
	
	// ��ʾ��ӵ�ַҳ��
	@RequestMapping(value="user/address/addressInput")
	public String addressInput() {
		return "user/address/addressInput";
	}
	
	// �����û���ӵ�ַ
	@RequestMapping(value="user/address/addAddress")
	public String addAddress(Address address, Model model, HttpSession session) {
		if(userService.addAddr(address) != null) {
			// ��ӳɹ������ص�ַ�б�ҳ��
			model.addAttribute("addAddressSuccess", "��ӵ�ַ�ɹ�");
			@SuppressWarnings("unchecked")
			List<Address> addrList = (List<Address>) session.getAttribute("addressList");
			addrList.add(address);
			session.setAttribute("addressList", addrList);
			return "user/address/addressList";
		} else {
			// ���ʧ�ܣ�������ӵ�ַҳ��
			model.addAttribute("addAddressError", "��ӵ�ַʧ��");
			return "user/address/addressInput";
		}
	}
	
	// �޸ĵ�ַ׼��
	@RequestMapping(value="user/address/editAddress")
	public String editAddress(int index, Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<Address> addrList = (List<Address>) session.getAttribute("addressList");
		model.addAttribute("index", index);
		model.addAttribute("address", addrList.get(index));
		return "user/address/addressInput";
	}
	
	// �޸ĵ�ַ
	@RequestMapping(value="user/address/doEditAddress")
	public String doEditAddress(Address address, int index, HttpSession session, Model model) {
		if(userService.updateAddr(address)) {
			// �޸ĳɹ������ص�ַ�б�ҳ��
			@SuppressWarnings("unchecked")
			List<Address> addrList = (List<Address>) session.getAttribute("addressList");
			addrList.set(index, address);
			session.setAttribute("addressList", addrList);
			model.addAttribute("updateAddressSuccess", "�޸ĵ�ַ�ɹ�");
			return "user/address/addressList";
		} else {
			// �޸�ʧ�ܣ���ʾ������Ϣ�������޸ĵ�ַҳ��
			model.addAttribute("updateAddressError", "�޸ĵ�ַʧ��");
			return "user/address/addressInput";
		}
	}
	
	// ɾ����ַ
	@RequestMapping(value="user/address/deleteAddress")
	public String deleteAddress(String[] ids, HttpSession session, Model model) {
		if(userService.deleteAddr(ids)) {
			// ɾ���ɹ������µ�ַ�б�
			User user = (User) session.getAttribute("user");
			session.setAttribute("addressList", userService.getAddrInfo(user.getUserId()));
		} else {
			// �޸�ʧ��
			model.addAttribute("deleteError", "ɾ��ʧ��");
		}
		return "user/address/addressList";
	}
	
}
