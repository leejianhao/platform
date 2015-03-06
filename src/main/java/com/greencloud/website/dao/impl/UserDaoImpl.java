package com.greencloud.website.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.greencloud.website.dao.IUserDao;
import com.greencloud.website.mapper.UserMapper;
import com.greencloud.website.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements IUserDao {
	
    @Resource
	private UserMapper userMapper;
	
	@Override
	public User findByName(String username) {
		return userMapper.selectByName(username);
	}

}
