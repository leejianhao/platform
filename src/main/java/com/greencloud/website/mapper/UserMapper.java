package com.greencloud.website.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.greencloud.website.model.User;

public interface UserMapper {
	User selectByName(@Param("username") String username);
	
	@Select("select * from t_user where id = #{id}")
	User load(@Param("id") Long id);
}
