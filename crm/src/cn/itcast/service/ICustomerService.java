package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;
import cn.itcast.web.common.PageBean;


public interface ICustomerService {
	void saveCustomer(Customer customer);
	List<Dict> findCustomerLevels();
	List<Dict> findCustomerSources();
	void deleteCustomer(Customer customer);
	Customer findCustomerById(Integer cid);
	void updateCustomer(Customer customer);
	PageBean<Customer> findCustomerByCriteria(DetachedCriteria criteria,
			Integer pageindex);
}
