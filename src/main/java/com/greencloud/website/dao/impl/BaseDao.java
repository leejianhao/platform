package com.greencloud.website.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.greencloud.website.dao.IBaseDao;
import com.greencloud.website.model.Pager;
import com.greencloud.website.model.SystemContext;

public class BaseDao<T> implements IBaseDao<T>{
	
	@Resource
	private SqlSession sqlSession;
	
	private final String path = "com.greencloud.website.mapper.";
	private Class<?> clz;
	
	public BaseDao() {
		this.clz = getClz();
	}
	
	/**
	 * 创建一个Class的对象来获取泛型的class 
	 */
	public Class<?> getClz() {
		if(clz==null) {
			//获取泛型的Class对象
			clz=(Class<?>)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
		}
		return clz;
	}
	
	private String getMethodPath(String methodName){
        return path + clz.getSimpleName() + "Mapper." + methodName;
    }
	
	@Override
	public void add(T obj) {
		sqlSession.insert(getMethodPath("save"), obj);
	}

	@Override
	public void update(T obj) {
		sqlSession.update(getMethodPath("update"), obj);
	}

	@Override
	public void delete(T obj) {
		sqlSession.delete(getMethodPath("delete"), obj);
	}

	@Override
	public T load(Long id) {
		return sqlSession.selectOne(getMethodPath("load"), id);
	}

	public T loadBySqlId(String sqlId, Map<String, Object> params) {
		return sqlSession.selectOne(sqlId, params);
	}

	public T loadBySqlId(String sqlId, Object obj) {
		return sqlSession.selectOne(sqlId, obj);
	}

	public List<T> list(Map<String, Object> params) {
		return list(clz.getName()+".list", params);
	}

	public List<T> list(String sqlId, Map<String, Object> params) {
		return sqlSession.selectList(sqlId,params);
	}

	public Pager<T> find(Map<String, Object> params) {
		return find(clz.getName()+".find", params);
	}

	public Pager<T> find(String sqlId, Map<String, Object> params) {
		int pageSize = SystemContext.getPageSize();
		int pageOffset = SystemContext.getPageOffset();
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		Pager<T> pages = new Pager<T>();
		if(params==null) params = new HashMap<String, Object>();
		params.put("pageSize", pageSize);
		params.put("pageOffset", pageOffset);
		params.put("sort", sort);
		params.put("order", order);
		List<T> datas = sqlSession.selectList(sqlId, params);
		pages.setDatas(datas);
		pages.setPageOffset(pageOffset);
		pages.setPageSize(pageSize);
		int totalRecord = (Integer)sqlSession.selectOne(sqlId+"_count",params);
		pages.setTotalRecord(totalRecord);
		return pages;
	}	
	
}
