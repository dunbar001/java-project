package cn.itcast.test;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.impl.DictDao;
import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;
import cn.itcast.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class TestDemo {

	@Resource(name="customerService")
	private ICustomerService customerService;
	
//	@Test
//	public void fun1(){
//		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
//		List<Customer> list = customerService.findCustomerByCriteria(criteria);
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
//	}
	
//	public void fun2(){
//		Customer c1 = new Customer();
//		c1.setCname("网易");
//		customerService.saveCustomer(c1);
//	}
	
	@Test
	public void fun3(){
		for (int i = 0; i < 300; i++) {
			Customer c1 = new Customer();
			c1.setCustMobile("138"+(int)(new Random().nextDouble()*1000000)+i);
			c1.setCustName("cust_"+i);
			c1.setCustPhone("02788145944");
			Dict source = new DictDao().findLevelsByCode("002").get(0);
			Dict level =  new DictDao().findLevelsByCode("001").get(0);
			c1.setCustSource(source);
			c1.setDictCustLevel(level);
			customerService.saveCustomer(c1);
		}
	}
}
