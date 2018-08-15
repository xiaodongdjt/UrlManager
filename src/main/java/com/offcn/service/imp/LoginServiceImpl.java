package com.offcn.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.dao.PermissionDao;
import com.offcn.dao.RoleDao;
import com.offcn.dao.UserDao;
import com.offcn.po.ActiveUser;
import com.offcn.po.Permission;
import com.offcn.po.Role;
import com.offcn.po.User;
import com.offcn.service.LoginService;
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserDao userDao;
	@Autowired
	PermissionDao pDao;
	@Autowired
	RoleDao rDao;
	@Override
	public ActiveUser login(String username, String password) {
		ActiveUser auser = new ActiveUser();
		User user = userDao.loginAuth(username, password);
		if(user!=null){
		List<Permission> listp = pDao.findPermissionByUserName(user.getUsername());
		List<Role> listr = rDao.findRoleByUsername(user.getUsername());
		
		auser.setUsername(user.getUsername());
		auser.setRoles(listr);
		auser.setPermissions(listp);
		}else{
			return null;
		}
		
		return auser;
	}

}
