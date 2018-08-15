package com.offcn.service;

import com.offcn.po.ActiveUser;

public interface LoginService {

	public ActiveUser login(String username,String password);
}
