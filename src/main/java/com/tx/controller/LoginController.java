package com.tx.controller;

import com.tx.model.pojo.User;
import com.tx.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("")
@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 登录
	 *
	 * @RequestParam 将请求参数绑定到方法的参数，required 为 false 表示为非必传 ，defaultValue表示默认值
	 *
	 * @param username
	 * @param password
	 * @param remember
	 * @param model
	 * @return
	 */
	@RequestMapping("toLogin")
	public String login(String username , String password , Model model){

		System.out.println("登陆用户输入的用户名：" + username + "，密码：" + password);

		String error = "";
		if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
			error = "用户名或密码不能为空";
		}else{
			//初始化
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
				//登录，即身份校验，由通过Spring注入的UserRealm会自动校验输入的用户名和密码在数据库中是否有对应的值
				subject.login(token);
				System.out.println("用户是否登录：" + subject.isAuthenticated());
				return "redirect:hello";
			} catch (UnknownAccountException e) {
				e.printStackTrace();
				error = "用户账户不存在，错误信息：" + e.getMessage();
			} catch (IncorrectCredentialsException e) {
				e.printStackTrace();
				error = "用户名或密码错误，错误信息：" + e.getMessage();
			} catch (LockedAccountException e) {
				e.printStackTrace();
				error = "该账号已锁定，错误信息：" + e.getMessage();
			} catch (DisabledAccountException e) {
				e.printStackTrace();
				error = "该账号已禁用，错误信息：" + e.getMessage();
			} catch (ExcessiveAttemptsException e) {
				e.printStackTrace();
				error = "该账号登录失败次数过多，错误信息：" + e.getMessage();
			} catch (Exception e){
				e.printStackTrace();
				error = "未知错误，错误信息：" + e.getMessage();
			}
		}
		model.addAttribute("message",error);
		return "hello";
	}

	@RequestMapping("hello")
	public String testFreemarker(Model model){
		model.addAttribute("name","tom");
		return "hello";
	}

	/**
	 * 登录成功，跳转到首页
	 *
	 * @return
	 */
	@RequestMapping("/login")
	public String index() {
		return "login";
	}

}
