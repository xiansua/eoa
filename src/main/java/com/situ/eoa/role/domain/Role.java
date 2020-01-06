package com.situ.eoa.role.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import com.situ.eoa.base.domain.BaseClass;

@Alias("Role")
public class Role extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String roleName;
	private Integer roleKind;
	private String roleInfo;
	private String rolePass;
	
	public String getRolePass() {
		return rolePass;
	}

	public void setRolePass(String rolePass) {
		this.rolePass = rolePass;
	}

	//private List<String> userLike;
	//private String[]userLike;
	/*
	 * public List<String> getUserLike() { return userLike; }
	 * 
	 * public void setUserLike(List<String> userLike) { this.userLike = userLike; }
	 */
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleKind() {
		return roleKind;
	}

	public void setRoleKind(Integer roleKind) {
		this.roleKind = roleKind;
	}

	public String getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(String roleInfo) {
		this.roleInfo = roleInfo;
	}
}
