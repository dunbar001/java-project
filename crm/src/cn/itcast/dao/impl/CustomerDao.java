package cn.itcast.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.domain.Customer;

@Repository("customerDao")
public class CustomerDao implements ICustomerDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Customer> findAllByCriteria(DetachedCriteria criteria) {
		return (List<Customer>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void deleteByCid(Customer customer) {
		hibernateTemplate.delete(customer);
	}
}
