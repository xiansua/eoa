package com.situ.eoa.list1.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.situ.eoa.list1.domain.Lists;
@Repository
public interface ListDao {
	Long save(Lists lists);
	List<Lists> find();
	void delete(Long rowId);
	void update(Lists lists);
	Lists get(Long rowId);
	Lists getByName(String listName);
}	
