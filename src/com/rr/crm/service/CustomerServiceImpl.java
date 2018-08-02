package com.rr.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rr.common.utils.Page;
import com.rr.crm.mapper.CustomerMapper;
import com.rr.crm.pojo.Customer;
import com.rr.crm.pojo.QueryVo;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;
	// ͨ���ĸ����� ��ѯ��ҳ����
	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
		Page<Customer> page = new Page<Customer>();
		// ÿҳ��
		page.setSize(5);
		vo.setSize(5);
		if (vo != null) {
			// �жϵ�ǰҳ
			 if (vo.getPage() != null) {
				page.setPage(vo.getPage());
				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
			  }
			 
			  if (vo.getCustName() != null && !"".equals(vo.getCustName().trim())) {
				vo.setCustName(vo.getCustName().trim());
			  }
			  if (vo.getCustSource() != null && !"".equals(vo.getCustSource().trim())) {
					vo.setCustSource(vo.getCustSource().trim());
			  }
			  if (vo.getCustIndustry() != null && !"".equals(vo.getCustIndustry().trim())) {
					vo.setCustIndustry(vo.getCustIndustry().trim());
			  }
			  if (vo.getCustLevel() != null && !"".equals(vo.getCustLevel().trim())) {
					vo.setCustLevel(vo.getCustLevel().trim());
			  }
			  // ������
			  page.setTotal(customerMapper.customerCountByQueryVo(vo));
			  
			  // �����
			  page.setRows(customerMapper.selectCustomerListByQueryVo(vo));
		}
		
		return page;
	}
	
	public Customer selectCustomerById(Integer id) {
		return customerMapper.selectCustomerById(id);
	}
	
	// �޸��û���Ϣͨ��ID
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
	}
	
	// ͨ��IDɾ���ͻ�
	public void deleteCustomerById(Integer id) {
		customerMapper.deleteCustomerById(id);
	}
}
