package com.situ.eoa.role.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.eoa.base.domain.PageData;
import com.situ.eoa.role.dao.RoleDao;
import com.situ.eoa.role.domain.Role;
import com.situ.eoa.role.service.RoleService;
import com.situ.eoa.util.PageUtils;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public Long saveRole(Role role) {
		role.setActiveFlag(1);
		role.setCreateBy("admin");
		role.setCreateDate(new Date());
		return roleDao.save(role);
	}

	@Override
	public List<Role> find() {
		return roleDao.find();
	}

	@Override
	public List<Role> findByPage(Integer pageNo, Role searchRole) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * 3;
		// limit查询数据 要显示的条数
		Integer maxResults = 3;
		return roleDao.findByPage(searchRole, firstResult, maxResults);
	}

	@Override
	public Role findRoleById(Long rowId) {
		return roleDao.get(rowId);
	}

	@Override
	public Long doUpdate(Role role) {
		role.setUpdateBy("admin");
		role.setUpdateDate(new Date());
		roleDao.update(role);
		return role.getRowId();
	}

	@Override
	public Long doDeleteRole(Long rowId) {
		roleDao.delete(rowId);
		return rowId;
	}

	@Override
	public Boolean checkRoleName(String roleName) {
		// 根据角色名称查询实例
		Role role = roleDao.getByName(roleName);
		// 三元表达式，如果有返回false，如果没有返回true
		Boolean bool = role != null ? false : true;
		return bool;
	}

	@Override
	public PageData buildPageData(Integer pageNo, Role searchRole) {
		// 查询出数据总数
		Integer dataCount = roleDao.getCount(searchRole);
		return PageUtils.buildPageData(dataCount, pageNo);
	}
}
