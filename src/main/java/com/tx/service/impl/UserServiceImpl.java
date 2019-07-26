package com.tx.service.impl;

import com.tx.dao.UserMapper;
import com.tx.model.pojo.User;
import com.tx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User queryUserByUserName(String userName) {
		return userMapper.selectUserByUserName(userName);
	}
}
