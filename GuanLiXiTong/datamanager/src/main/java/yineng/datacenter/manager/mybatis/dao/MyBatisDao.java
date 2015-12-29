package yineng.datacenter.manager.mybatis.dao;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import yineng.datacenter.manager.model.PageModel;

/**
 * MyBatis的Dao基类
 * 
 * @author art-d
 */
public class MyBatisDao extends SqlSessionDaoSupport {

	public Integer save(String key, Object object) {
		return getSqlSession().insert(key, object);
	}

	public Integer delete(String key, Serializable id) {
		return getSqlSession().delete(key, id);
	}

	public Integer delete(String key, Object object) {
		return getSqlSession().delete(key, object);
	}

	public <T> T get(String key, Object params) {
		return (T) getSqlSession().selectOne(key, params);
	}

	public <T> List<T> getList(String key) {
		return getSqlSession().selectList(key);
	}

	public <T> List<T> getList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}

	public Integer update(String key, Object params) {
		return getSqlSession().update(key, params);
	}

	public <T> List<T> queryPageList(String key, Object params, PageModel page) {
		List list = null;
		if (page != null) {
			list = getSqlSession().selectList(key, params, page);
		} else {
			list = getSqlSession().selectList(key, params);
		}
		return list;
	}

	public PageModel queryPage(String key, Object params, PageModel page) {
		List list = queryPageList(key, params, page);
		if (page != null) {
			page.setResult(list);
		}
		return page;
	}

}
