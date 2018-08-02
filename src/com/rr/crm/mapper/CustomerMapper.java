package com.rr.crm.mapper;

import java.util.List;

import com.rr.crm.pojo.Customer;
import com.rr.crm.pojo.QueryVo;

public interface CustomerMapper {
	// ������
	public Integer customerCountByQueryVo(QueryVo vo);
	// �����
	public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
	// ͨ��ID��ѯ�ͻ�
	public Customer selectCustomerById(Integer id);
	// �޸Ŀͻ�ͨ��ID
	public void updateCustomerById(Customer customer);
	
	// ͨ��IDɾ���ͻ�
	public void deleteCustomerById(Integer id);
}
