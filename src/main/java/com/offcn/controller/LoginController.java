package com.offcn.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.offcn.po.ActiveUser;
import com.offcn.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,HttpSession session){
		ActiveUser auser = loginService.login(username, password);
		
		if(auser!=null){
			session.setAttribute("auser", auser);
			return "index";
		}else{
			session.setAttribute("msg", "用户名或者密码错误，登录失败!");
			return "redirect:/";
		}
		
		
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.removeAttribute("auser");
		session.removeAttribute("msg");
		return "redirect:/";
	}
}
