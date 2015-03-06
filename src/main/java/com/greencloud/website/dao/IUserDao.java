package com.greencloud.website.dao;

import com.greencloud.website.model.User;

public interface IUserDao extends IBaseDao<User> {
	User findByName(String username);
}
