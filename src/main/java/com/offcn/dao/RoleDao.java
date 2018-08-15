package com.offcn.dao;

import java.util.List;

import com.offcn.po.Role;

public interface RoleDao {

	//查询指定用户名的全部角色信息
	public List<Role> findRoleByUsername(String username);
}
