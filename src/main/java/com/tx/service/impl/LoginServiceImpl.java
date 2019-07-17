package com.tx.service.impl;

import com.tx.dao.LoginMapper;
import com.tx.model.pojo.Login;
import com.tx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public boolean login(String account, String passWord) {
		Login login = loginMapper.selectByPrimaryKey(1);
		System.out.println(login.toString());
		return true;
	}
}
