package cn.itcast.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Dict {

	@Id
	@Column(name="t_did")
	private String did;
	
	@Column(name="t_dname")
	private String dname;
	
	@Column(name="t_dcode")
	private String dcode;
	
	@Column(name="t_ditemname")
	private String ditemname;
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDcode() {
		return dcode;
	}
	public void setDcode(String dcode) {
		this.dcode = dcode;
	}
	public String getDitemname() {
		return ditemname;
	}
	public void setDitemname(String ditemname) {
		this.ditemname = ditemname;
	}
}
