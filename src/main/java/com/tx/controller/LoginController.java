package com.tx.controller;

import com.tx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("login")
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("toLogin")
	public String login(){
		boolean login = loginService.login("15111509329", "123456");
		System.out.println(login);
		return "login";
	}

}
