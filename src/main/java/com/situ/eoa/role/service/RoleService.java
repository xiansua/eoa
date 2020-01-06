package com.situ.eoa.role.service;

import java.util.List;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.role.domain.Role;

public interface RoleService {
	Long saveRole(Role role);

	List<Role> find();

	List<Role> findByPage(Integer pageNo, Role searchRole);

	Role findRoleById(Long rowId);

	Long doUpdate(Role role);

	Long doDeleteRole(Long rowId);

	Boolean checkRoleName(String roleName);

	PageData buildPageData(Integer pageNo,Role searchRole);
}
