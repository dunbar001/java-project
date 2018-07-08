package cn.itcast.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.annotation.Scope;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;
import cn.itcast.service.ICustomerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@Results({
	@Result(name="customerList",location="/jsp/customer/list.jsp"),
	@Result(name="addCustomer",location="/jsp/customer/add.jsp"),
	@Result(name="findAllCustomer",type="redirect",location="findAllCustomer.action"),
})
public class CustomerAction extends ActionSupport implements
		ModelDriven<Customer> {

	@Resource(name="customerService")
	private ICustomerService service;
	
	private Customer customer = new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}
	
	private List<Customer> custList;
	public List<Customer> getCustList() {
		return custList;
	}
	
	private List<Dict> levelList;
	public List<Dict> getLevelList() {
		return levelList;
	}
	
	private List<Dict> sourceList;
	public List<Dict> getSourceList() {
		return sourceList;
	}

	@Action("findAllCustomer")
	public String findAllCustomer()	{
		custList = service.findCustomerByCriteria(DetachedCriteria.forClass(Customer.class));
		return "customerList";
	}
	
	@Action("addCustomer")
	public String addCustomer(){
		levelList = service.findCustomerLevels();
		sourceList = service.findCustomerSources();
		return "addCustomer";
	}
	
	@Action("saveCustomer")
	public String saveCustomer(){
		service.saveCustomer(customer);
		return "findAllCustomer";
	}
	
	@Action("deleteCustomer")
	public String deleteCustomer(){
		service.deleteCustomer(customer);
		return "findAllCustomer";
	}
}
