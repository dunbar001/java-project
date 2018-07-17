package cn.itcast.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.CountProjection;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.web.common.PageBean;

@Repository("customerDao")
public class CustomerDao implements ICustomerDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public PageBean<Customer> findAllByCriteria(DetachedCriteria criteria,int pageindex,int totalrecords) {
		PageBean<Customer> page = new PageBean<Customer>(pageindex, totalrecords);
		List<Customer> customers = (List<Customer>) hibernateTemplate.findByCriteria(criteria,page.getPageindex(),page.getPagesize());
		page.setPageList(customers);
		return page;
	}

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	public void deleteByCid(Customer customer) {
		hibernateTemplate.delete(customer);
	}

	@Override
	public Customer findById(Integer cid) {
		return hibernateTemplate.get(Customer.class, cid);
	}

	@Override
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
	}
	
	@Override
	public int getTotalRecords(DetachedCriteria criteria){
		criteria.setProjection(Projections.rowCount());
		Long totalRecords = (Long) hibernateTemplate.findByCriteria(criteria).get(0);
		criteria.setProjection(null);
		return totalRecords.intValue();
	}

	@Override
	public List<Customer> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		return (List<Customer>) hibernateTemplate.findByCriteria(criteria);
	}
}
