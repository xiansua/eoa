package com.situ.eoa.list1.service;

import java.util.List;

import com.situ.eoa.list1.domain.Lists;

public interface ListService {
	Long saveList(Lists lists);
	List<Lists> findAllList();
	Long deleteList(Long roeId);
	Long updateList(Lists lists);
	Lists findListById(Long roeId);
	Boolean checkListName(String listName);
}
