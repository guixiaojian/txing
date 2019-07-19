package com.tx.controller;

import com.tx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("login")
	public String login(Model model){
		boolean login = loginService.login("15111509329", "123456");
		System.out.println(login);
		model.addAttribute("name","桂某人");
		return "login";
	}

	@RequestMapping("hello")
	public String testFreemarker(Model model){
		model.addAttribute("name","tom");
		return "hello";
	}

}
