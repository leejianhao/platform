package com.greencloud.website.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.greencloud.website.dao.IUserDao;
import com.greencloud.website.model.User;
import com.greencloud.website.service.IUserService;

@Service("userService")
public class UserServiceImpl extends ServiceImpl implements IUserService {
	
	@Resource
	private IUserDao userDao;
	
	@Cacheable(value="testCache")
	@Override
	public User findByName(String username) {
		User user = load(1l);
		System.out.println(user.getUsername());
		return userDao.findByName(username);
	}
	
	public User load(Long id) {
		return userDao.load(id);
	}

}
