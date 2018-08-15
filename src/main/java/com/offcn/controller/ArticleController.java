package com.offcn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {

	@RequestMapping(value="/articel/list")
	public String list(){	
		return "article-list";
	}
}
