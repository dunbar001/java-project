package cn.itcast.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;

public interface ILinkmanDao {

	void save(LinkMan linkMan);

	List<LinkMan> findByCriteria(DetachedCriteria criteria, int pageindex,
			int pagesize);

	int getTotalByCriteria(DetachedCriteria criteria);

	void delete(LinkMan linkMan);

	LinkMan findById(Integer linkid);

	void update(LinkMan linkMan);

}
