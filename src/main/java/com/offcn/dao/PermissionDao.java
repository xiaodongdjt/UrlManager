package com.offcn.dao;

import java.util.List;

import com.offcn.po.Permission;

public interface PermissionDao {

	//查询指定用户名的全部权限信息
	public List<Permission> findPermissionByUserName(String username);
}
