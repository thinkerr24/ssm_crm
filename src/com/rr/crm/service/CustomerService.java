package com.rr.crm.service;

import org.springframework.web.bind.annotation.ResponseBody;

import com.rr.common.utils.Page;
import com.rr.crm.pojo.Customer;
import com.rr.crm.pojo.QueryVo;

public interface CustomerService {

	// ͨ���ĸ�������ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	// ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	
	// �޸Ŀͻ���Ϣͨ��ID
	public void updateCustomerById(Customer customer);
	
	// ͨ��IDɾ���ͻ�
	public void deleteCustomerById(Integer id); 
}
