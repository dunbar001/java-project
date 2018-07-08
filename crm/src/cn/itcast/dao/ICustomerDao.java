package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;

public interface ICustomerDao {
	List<Customer> findAllByCriteria(DetachedCriteria criteria);
	void save(Customer customer);
	void deleteByCid(Customer customer);
}
