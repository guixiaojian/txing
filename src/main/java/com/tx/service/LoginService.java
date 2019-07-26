package com.tx.service;

import com.tx.model.pojo.User;

public interface LoginService {
	User login(String account , String passWord);
}
