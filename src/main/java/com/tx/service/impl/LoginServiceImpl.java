package com.tx.service.impl;

import com.tx.dao.UserMapper;
import com.tx.model.pojo.User;
import com.tx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(String userName, String passWord) {
		return userMapper.selectUserByUserName(userName);
	}
}
