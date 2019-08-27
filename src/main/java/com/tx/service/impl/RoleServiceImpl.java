package com.tx.service.impl;

import com.tx.dao.RoleMapper;
import com.tx.model.pojo.Role;
import com.tx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> findRoleByUsername(String username) {
		return roleMapper.selectRoleByUsername(username);
	}
}
