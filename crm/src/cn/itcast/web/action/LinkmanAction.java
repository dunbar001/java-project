package cn.itcast.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.aspectj.bridge.ILifecycleAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;

import sun.awt.util.IdentityLinkedList;

import cn.itcast.domain.Customer;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.ICustomerService;
import cn.itcast.service.ILinkmanService;
import cn.itcast.web.common.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

@ParentPackage("struts-default")
@Namespace("/")
@Scope("prototype")
@Results({
	@Result(name="addUI",type="dispatcher",location="/jsp/linkman/add.jsp"),
	@Result(name="add",type="redirectAction",location="listUI.action"),
	@Result(name="delete",type="redirectAction",location="listUI.action"),
	@Result(name="update",type="redirectAction",location="listUI.action"),
	@Result(name="listUI",type="dispatcher",location="/jsp/linkman/list.jsp"),
	@Result(name="editUI",type="dispatcher",location="/jsp/linkman/edit.jsp")
})
public class LinkmanAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	@Resource(name="customerService")
	private ICustomerService customerService;
	@Resource(name="linkmanService")
	private ILinkmanService linkmanService;
	private List<Customer> custList;
	private PageBean<LinkMan> pList;
	private Integer page = 1;
	
	public void setPage(Integer page) {
		this.page = page;
	}
	public PageBean<LinkMan> getpList() {
		return pList;
	}
	public List<Customer> getCustList() {
		return custList;
	}
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	@Action("addUI")
	public String addUI(){
		custList = customerService.findAllCustomers();
		return "addUI";
	}
	
	@Action("saveLinkman")
	public String saveLinkman(){
		linkmanService.saveLinkman(linkMan);
		return "add";
	}
	
	@Action("listUI")
	public String listUI(){
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		if(!StringUtils.isBlank(linkMan.getLkmName())){
			criteria.add(Restrictions.like("lkmName", "%"+linkMan.getLkmName()+"%"));
		}
		if(!StringUtils.isBlank(linkMan.getLkmGender())){
			criteria.add(Restrictions.eq("lkmGender", linkMan.getLkmGender()));
		}
		pList = linkmanService.findByCriteria(criteria,page);
		return "listUI";
	}
	
	@Action("deleteLinkman")
	public String deleteLinkman(){
		linkmanService.deleteLinkman(linkMan);
		return "delete";
	}
	
	@Action("editUI")
	public String editUI(){
		custList = customerService.findAllCustomers();
		LinkMan lkm = linkmanService.findById(linkMan.getLinkid());
		ActionContext.getContext().getValueStack().push(lkm);
		return "editUI";
	}
	
	@Action("updateLinkman")
	public String updateLinkman(){
		linkmanService.update(linkMan);
		return "update";
	}
}
