package com.greencloud.website.dao;

/**
 * 
 * @author leejianhao
 *
 */
public interface IBaseDao<T> {
	
	/**
	 * 单表插入
	 * @param obj
	 */
	public void add(T obj);
	
	/**
	 * 单表更新
	 * @param obj
	 */
	public void update(T obj);
	
	/**
	 * 单表删除
	 * @param obj
	 */
	public void delete(T obj);
	
	/**
	 * 单表查询
	 * @param clzz
	 * @param id
	 * @return
	 */
	public T load(Long id);
}
