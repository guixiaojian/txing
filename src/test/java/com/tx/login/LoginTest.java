package com.tx.login;

import com.tx.model.pojo.User;
import com.tx.service.LoginService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" })
public class LoginTest extends AbstractJUnit4SpringContextTests {


	@Autowired
	private LoginService loginService;

	@Test
	public void loginTest2(){
		User login = loginService.login("15111509331", "123456");
		if(login != null){
			System.out.println("wosho nibabab");
		}
	}

}
