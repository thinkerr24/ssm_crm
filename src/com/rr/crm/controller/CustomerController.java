package com.rr.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rr.common.utils.Page;
import com.rr.crm.pojo.BaseDict;
import com.rr.crm.pojo.Customer;
import com.rr.crm.pojo.QueryVo;
import com.rr.crm.service.BaseDictService;
import com.rr.crm.service.CustomerService;


/**
 * �ͻ�����
 */
@Controller
public class CustomerController {
	
	@Autowired
	private BaseDictService baseDictService;
	
	@Autowired
	private CustomerService customerService;
	

	
	// ע���ڳ�Ա������
	@Value("${fromType.code}")
	private String fromTypeCode;
	// ���
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo, Model model) {
		
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		// ͨ���ĸ�������ѯ��ҳ����
		Page<Customer> page = customerService.selectPageByQueryVo(vo);
		model.addAttribute("page", page);
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		return "customer";
	}
	
	// ȥ�޸�ҳ��
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody
	Customer  edit(Integer id) {
		return customerService.selectCustomerById(id);
	}
	
	// �޸ı���
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody
	String  update(Customer customer) {
		customerService.updateCustomerById(customer);
		return "OK";
	}
	
	// ɾ��
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody
	String delete(Integer id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}
}
