package com.tx.dao;

import com.tx.model.pojo.Login;
import com.tx.model.pojo.LoginExample;
import org.springframework.stereotype.Repository;

/**
 * LoginMapper继承基类
 */
@Repository
public interface LoginMapper {
	Login selectByPrimaryKey(int id);
}