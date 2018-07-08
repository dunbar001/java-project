package cn.itcast.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;


public interface ICustomerService {
	List<Customer> findCustomerByCriteria(DetachedCriteria criteria);
	void saveCustomer(Customer customer);
	List<Dict> findCustomerLevels();
	List<Dict> findCustomerSources();
}
