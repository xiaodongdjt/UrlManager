package com.offcn.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.po.Permission;
import com.offcn.util.ResourceUtil;

public class PermissionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		//1、加载匿名访问地址
		List listnm = ResourceUtil.getResourceKeyList("niming");
		for (Object object : listnm) {
			String urlnm=(String)object;
			if(url.indexOf(urlnm)>=0){
				return true;
			}
		}
		//2、加载登陆后就可以直接访问的地址
		List listcommon = ResourceUtil.getResourceKeyList("common");
		for(Object obj:listcommon){
			String urlcomm=(String)obj;
			if(url.indexOf(urlcomm)>=0){
				return true;
			}
		}
		//3、加载权限列表
		HttpSession session = request.getSession();
		ActiveUser auser=(ActiveUser) session.getAttribute("auser");
		
		List<Permission> plist = auser.getPermissions();
		for (Permission p : plist) {
			if(url.indexOf(p.getUrl())>=0){
				return true;
			}
		}
		//4、以上情况都不是，表示无权限
		request.getRequestDispatcher("/refuse.jsp").forward(request, response);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
