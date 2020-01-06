package com.situ.eoa.list1.domain;

import java.io.Serializable;

import com.situ.eoa.base.domain.BaseClass;

public class Lists extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private String listName;
	private Long parentListId;
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public Long getParentListId() {
		return parentListId;
	}
	public void setParentListId(Long parentListId) {
		this.parentListId = parentListId;
	}
	@Override
	public String toString() {
		return "lists [listName=" + listName + ", parentListId=" + parentListId + "]";
	}
	
}
