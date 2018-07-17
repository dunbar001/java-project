package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Customer;
import cn.itcast.web.common.PageBean;

public interface ICustomerDao {
	void save(Customer customer);
	void deleteByCid(Customer customer);
	Customer findById(Integer cid);
	void update(Customer customer);
	PageBean<Customer> findAllByCriteria(DetachedCriteria criteria,
			int pageindex, int totalrecords);
	int getTotalRecords(DetachedCriteria criteria);
	List<Customer> findAll();
}
