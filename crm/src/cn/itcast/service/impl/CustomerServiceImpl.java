package cn.itcast.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ICustomerDao;
import cn.itcast.dao.IDictDao;
import cn.itcast.dao.impl.CustomerDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;
import cn.itcast.service.ICustomerService;
import cn.itcast.web.common.PageBean;

@Service("customerService")
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class CustomerServiceImpl implements ICustomerService {

	@Resource(name="customerDao")
	private ICustomerDao customerDao;
	
	@Resource(name="dictDao")
	private IDictDao dictDao;
	
	@Override
	public PageBean<Customer> findCustomerByCriteria(DetachedCriteria criteria,Integer pageindex) {
		int totalRecords = customerDao.getTotalRecords(criteria);
		if(pageindex==null) pageindex=1;
		return customerDao.findAllByCriteria(criteria,pageindex,totalRecords);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Dict> findCustomerLevels() {
		return dictDao.findLevelsByCode("001");
	}

	@Override
	public List<Dict> findCustomerSources() {
		return dictDao.findSourcesByCode("002");
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void deleteCustomer(Customer customer) {
		customerDao.deleteByCid(customer);
	}

	@Override
	public Customer findCustomerById(Integer cid) {
		return customerDao.findById(cid);
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	@Override
	public void updateCustomer(Customer customer) {
		customerDao.update(customer);
	}

}
