package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Dict;

public interface IDictDao {

	List<Dict> findLevelsByCode(String code);

	List<Dict> findSourcesByCode(String code);

}
