package cn.itcast.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;

import cn.itcast.domain.Customer;
import cn.itcast.domain.Dict;
import cn.itcast.service.ICustomerService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@Results({
	@Result(name="customerList",location="/jsp/customer/list.jsp"),
	@Result(name="addCustomer",location="/jsp/customer/add.jsp"),
	@Result(name="findAllCustomer",type="redirect",location="findAllCustomer.action"),
	@Result(name="editUI",location="/jsp/customer/edit.jsp"),
	@Result(name="success",type="redirect",location="findAllCustomer.action")
})
public class CustomerAction extends ActionSupport implements
		ModelDriven<Customer> {

	@Resource(name="customerService")
	private ICustomerService service;
	private Customer customer = new Customer();
	private List<Customer> custList;
	private List<Dict> levelList;
	private List<Dict> sourceList;
	
	@Override
	public Customer getModel() {
		return customer;
	}
	
	@Action("editUICustomer")
	public String editUICustomer(){
		levelList = service.findCustomerLevels();
		sourceList = service.findCustomerSources();
		Customer c = service.findCustomerById(customer.getCid());
		ActionContext.getContext().getValueStack().push(c);
		return "editUI";
	}
	
	@Action("editCustomer")
	public String editCustomer(){
		service.updateCustomer(customer);
		return SUCCESS;
	}

	@Action("findAllCustomer")
	public String findAllCustomer()	{
		levelList = service.findCustomerLevels();
		sourceList = service.findCustomerSources();
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		if(StringUtils.isNotBlank(customer.getCustName())){
			criteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		if(customer.getDictCustLevel()!=null && StringUtils.isNotBlank(customer.getDictCustLevel().getDid())){
			criteria.add(Restrictions.eq("dictCustLevel.did", customer.getDictCustLevel().getDid()));
		}
		if(customer.getCustSource()!=null && StringUtils.isNotBlank(customer.getCustSource().getDid())){
			criteria.add(Restrictions.eq("custSource.did", customer.getCustSource().getDid()));
		}
		custList = service.findCustomerByCriteria(criteria);
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
	
	public List<Customer> getCustList() {
		return custList;
	}
	public List<Dict> getLevelList() {
		return levelList;
	}
	public List<Dict> getSourceList() {
		return sourceList;
	}
}
