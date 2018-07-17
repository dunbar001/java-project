package cn.itcast.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.ILinkmanDao;
import cn.itcast.domain.LinkMan;

@Repository("linkmanDao")
public class LinkmanDaoImpl implements ILinkmanDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(LinkMan linkMan) {
		hibernateTemplate.save(linkMan);
	}

	@Override
	public List<LinkMan> findByCriteria(DetachedCriteria criteria,
			int pageindex, int pagesize) {
		return (List<LinkMan>) hibernateTemplate.findByCriteria(criteria, pageindex, pagesize);
	}

	@Override
	public int getTotalByCriteria(DetachedCriteria criteria) {
		criteria.setProjection(Projections.rowCount());
		List<Object> list = (List<Object>) hibernateTemplate.findByCriteria(criteria);
		Long total = null;
		if(list!=null && list.size() > 0){
			total = (Long) list.get(0);
		}else{
			total = (long) 0;
		}
		criteria.setProjection(null);
		return total.intValue();
	}

	@Override
	public void delete(LinkMan linkMan) {
		hibernateTemplate.delete(linkMan);
	}

	@Override
	public LinkMan findById(Integer linkid) {
		return hibernateTemplate.get(LinkMan.class, linkid);
	}

	@Override
	public void update(LinkMan linkMan) {
		hibernateTemplate.update(linkMan);
	}
}
