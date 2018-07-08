package cn.itcast.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="t_cid")
	private Integer cid;
	
	@Column(name="t_custName")
	private String custName;
	
	@Column(name="t_custPhone")
	private String custPhone;
	
	@Column(name="t_custMobile")
	private String custMobile;
	
	@ManyToOne
	@JoinColumn(name="t_sourceId")
	private Dict custSource;
	
	public Dict getCustSource() {
		return custSource;
	}
	public void setCustSource(Dict custSource) {
		this.custSource = custSource;
	}
	//在客户实体类表示所属级别
	@ManyToOne
	@JoinColumn(name="t_levelId")
	private Dict dictCustLevel;
	
	public Dict getDictCustLevel() {
		return dictCustLevel;
	}
	public void setDictCustLevel(Dict dictCustLevel) {
		this.dictCustLevel = dictCustLevel;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}
}
