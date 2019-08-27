package com.tx.service;

import com.tx.model.pojo.Permission;

import java.util.List;

public interface PermissionService {

	/**
	 * 根据用户名查找其他权限
	 *
	 * @param username
	 * @return
	 */
	List<Permission> findPermissions(String username);
}
