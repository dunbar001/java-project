package cn.itcast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LinkMan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="t_lkmid")
	private Integer linkid;
	@Column(name="t_lkmname")
	private String lkmName;
	@Column(name="lkmgender")
	private String lkmGender;
	@Column(name="lkmphone")
	private String lkmPhone;
	@Column(name="lkmmobile")
	private String lkmMobile;
	
	//所属客户
	@ManyToOne
	@JoinColumn(name="t_custId")
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Integer getLinkid() {
		return linkid;
	}
	public void setLinkid(Integer linkid) {
		this.linkid = linkid;
	}
	public String getLkmName() {
		return lkmName;
	}
	public void setLkmName(String lkmName) {
		this.lkmName = lkmName;
	}
	public String getLkmGender() {
		return lkmGender;
	}
	public void setLkmGender(String lkmGender) {
		this.lkmGender = lkmGender;
	}
	public String getLkmPhone() {
		return lkmPhone;
	}
	public void setLkmPhone(String lkmPhone) {
		this.lkmPhone = lkmPhone;
	}
	public String getLkmMobile() {
		return lkmMobile;
	}
	public void setLkmMobile(String lkmMobile) {
		this.lkmMobile = lkmMobile;
	}
}
