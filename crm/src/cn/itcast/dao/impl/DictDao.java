package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import cn.itcast.dao.IDictDao;
import cn.itcast.domain.Dict;

@Repository("dictDao")
public class DictDao implements IDictDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public List<Dict> findLevelsByCode(String code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Dict.class);
		criteria.add(Restrictions.eq("dcode", code));
		return (List<Dict>) hibernateTemplate.findByCriteria(criteria);
	}

	@Override
	public List<Dict> findSourcesByCode(String code) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Dict.class);
		criteria.add(Restrictions.eq("dcode", code));
		return (List<Dict>) hibernateTemplate.findByCriteria(criteria);
	}

}
