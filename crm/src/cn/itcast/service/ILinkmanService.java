package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.LinkMan;
import cn.itcast.web.common.PageBean;

public interface ILinkmanService {

	void saveLinkman(LinkMan linkMan);

	PageBean<LinkMan> findByCriteria(DetachedCriteria criteria,
			Integer pageIndex);

	void deleteLinkman(LinkMan linkMan);

	LinkMan findById(Integer linkid);

	void update(LinkMan linkMan);

}
