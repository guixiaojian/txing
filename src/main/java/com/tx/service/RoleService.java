package com.tx.service;

import com.tx.model.pojo.Role;

import java.util.List;

public interface RoleService {

	List<Role> findRoleByUsername(String username);
}
