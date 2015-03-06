package com.greencloud.website.service;

import com.greencloud.website.model.User;

public interface IUserService extends IService {
	User findByName(String username);
}
