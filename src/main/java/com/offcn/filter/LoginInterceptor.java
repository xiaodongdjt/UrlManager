package com.offcn.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.offcn.po.ActiveUser;
import com.offcn.util.ResourceUtil;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1、获取访问地址
		String url=request.getRequestURI();
		//2、加载匿名地址
		List listNiMing = ResourceUtil.getResourceKeyList("niming");
		//3、判断访问地址是否是允许匿名访问
		for (Object object : listNiMing) {
			String NmUrl=(String)object;
			if(url.indexOf(NmUrl)>=0){
				return true;
			}
		}
		//4、判断主体是否已经登录过
		HttpSession session = request.getSession();
		ActiveUser auser=(ActiveUser) session.getAttribute("auser");
		if(auser!=null){
			return true;
		}
		//5、以上几种情况都不是，表示需要登录，跳转到登录页
		request.getRequestDispatcher("/login.jsp").forward(request, response);
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
