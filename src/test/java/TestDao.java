import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.offcn.dao.PermissionDao;
import com.offcn.dao.RoleDao;
import com.offcn.dao.UserDao;
import com.offcn.po.Permission;
import com.offcn.po.Role;
import com.offcn.po.User;

public class TestDao {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");

		//UserDao userDao = context.getBean(UserDao.class);
		
	///	User u = userDao.loginAuth("admin", "1234567");
		//System.out.println("用户名:"+u.getUsername()+" 密码:"+u.getPassword());
		/*
		RoleDao roleDao = context.getBean(RoleDao.class);
		List<Role> listrole = roleDao.findRoleByUsername("admin");
		for (Role role : listrole) {
			System.out.println(role.getRoleName()+" "+role.getRoleSign());
		}*/
		
		PermissionDao pdao = context.getBean(PermissionDao.class);
		List<Permission> listp = pdao.findPermissionByUserName("admin");
		for (Permission p : listp) {
			System.out.println(p.getPermissionName()+" "+p.getUrl());
		}
		
	}

}
