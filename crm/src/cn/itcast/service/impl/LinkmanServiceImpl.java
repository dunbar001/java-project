package cn.itcast.service.impl;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.ILinkmanDao;
import cn.itcast.domain.LinkMan;
import cn.itcast.service.ILinkmanService;
import cn.itcast.web.common.PageBean;

@Service("linkmanService")
@Transactional
public class LinkmanServiceImpl implements ILinkmanService {

	@Resource(name="linkmanDao")
	private ILinkmanDao linkmanDao;

	@Override
	public void saveLinkman(LinkMan linkMan) {
		linkmanDao.save(linkMan);
	}

	@Override
	public PageBean<LinkMan> findByCriteria(DetachedCriteria criteria,
			Integer pageIndex) {
		int totalRecords = getTotalRecords(criteria);
		int page = pageIndex==null?1:pageIndex.intValue();
		PageBean<LinkMan> pList = new PageBean<LinkMan>(page, totalRecords);
		pList.setPageList(linkmanDao.findByCriteria(criteria,pList.getPageindex(),pList.getPagesize()));
		return pList;
	}
	
	public int getTotalRecords(DetachedCriteria criteria){
		return linkmanDao.getTotalByCriteria(criteria);
	}

	@Override
	public void deleteLinkman(LinkMan linkMan) {
		linkmanDao.delete(linkMan);
	}

	@Override
	public LinkMan findById(Integer linkid) {
		return linkmanDao.findById(linkid);
	}

	@Override
	public void update(LinkMan linkMan) {
		linkmanDao.update(linkMan);
	}
}
