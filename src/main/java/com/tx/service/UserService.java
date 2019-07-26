package com.tx.service;

import com.tx.model.pojo.User;

public interface UserService {

	User queryUserByUserName(String userName);
}
