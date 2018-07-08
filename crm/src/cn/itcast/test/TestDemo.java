package cn.itcast.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.domain.Customer;
import cn.itcast.service.ICustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class TestDemo {

	@Resource(name="customerService")
	private ICustomerService customerService;
	
	@Test
	public void fun1(){
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		List<Customer> list = customerService.findCustomerByCriteria(criteria);
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}
	
//	public void fun2(){
//		Customer c1 = new Customer();
//		c1.setCname("网易");
//		customerService.saveCustomer(c1);
//	}
}
