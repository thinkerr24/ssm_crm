package com.rr.crm.service;

import org.springframework.web.bind.annotation.ResponseBody;

import com.rr.common.utils.Page;
import com.rr.crm.pojo.Customer;
import com.rr.crm.pojo.QueryVo;

public interface CustomerService {

	// 通过四个条件查询分页对象
	public Page<Customer> selectPageByQueryVo(QueryVo vo);

	// 通过ID查询客户
	public Customer selectCustomerById(Integer id);
	
	// 修改客户信息通过ID
	public void updateCustomerById(Customer customer);
	
	// 通过ID删除客户
	public void deleteCustomerById(Integer id); 
}
