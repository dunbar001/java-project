package cn.itcast.web.common;

import java.util.List;

import cn.itcast.domain.Customer;

public class PageBean<T> {

	private int pagesize=5;
	private int pageindex;
	private int totalpages;
	private int totalrecords;
	private int prepage;
	private int nextpage;
	private int firstpage;
	private int lastpage;
	private List<T> pageList;
	private int begin;
	private int end;
	
	public PageBean(int page, int totalrecords) {
		this.pageindex = (page-1)*pagesize;
		this.totalrecords = totalrecords;
		this.totalpages = totalrecords%pagesize==0?totalrecords/pagesize:totalrecords/pagesize+1;
		this.prepage = page-1;
		if(this.prepage<1){
			this.prepage=1;
		}
		this.nextpage = page+1;
		if(this.nextpage>this.totalpages){
			this.nextpage = this.totalpages;
		}
		this.firstpage = 1;
		this.lastpage = totalpages;
		
		if(totalpages>10){
			begin = page-4;
			end = page+5;
			if(begin<1){
				begin = 1;
				end = begin + 9;
			}
			if(end>totalpages){
				end = totalpages;
				begin = end - 9;
			}
		}else{
			begin = 1;
			end = totalpages;
		}
	}
	
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public int getTotalrecords() {
		return totalrecords;
	}
	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}
	public int getPrepage() {
		return prepage;
	}
	public void setPrepage(int prepage) {
		this.prepage = prepage;
	}
	public int getNextpage() {
		return nextpage;
	}
	public void setNextpage(int nextpage) {
		this.nextpage = nextpage;
	}
	
	public List<T> getPageList() {
		return pageList;
	}

	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}

	public int getFirstpage() {
		return firstpage;
	}

	public void setFirstpage(int firstpage) {
		this.firstpage = firstpage;
	}

	public int getLastpage() {
		return lastpage;
	}

	public void setLastpage(int lastpage) {
		this.lastpage = lastpage;
	}

	public int getBegin() {
		return begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	
}
