package com.tx.service.impl;

import com.tx.dao.PermissionMapper;
import com.tx.model.pojo.Permission;
import com.tx.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;

	@Override
	public List<Permission> findPermissions(String username) {
		return null;
	}
}
