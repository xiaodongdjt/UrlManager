package com.offcn.dao;

import org.apache.ibatis.annotations.Param;

import com.offcn.po.User;

public interface UserDao {

	//用户登录验证方法
	public User loginAuth(@Param("username")String username,@Param("password")String password);
}
