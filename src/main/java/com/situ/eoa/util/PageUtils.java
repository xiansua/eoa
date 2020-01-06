package com.situ.eoa.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.situ.eoa.base.domain.PageData;

/**
 * @Page 工具类
 */
public class PageUtils implements Serializable {
	private static final long serialVersionUID = 1L;
	// 默认的每页显示的条数
	public static final int PAGE_ROWS = 10;

	private PageUtils() {
	}

	/**
	 * @编译生成分页数据
	 * @param dataCount 数据总量
	 * @param pageNo    分页页号
	 * @return
	 */
	public static PageData buildPageData(Integer dataCount, Integer pageNo) {
		// countIndex = 61
		// 计算出可以分的总页数
		Integer pageCount = dataCount % PAGE_ROWS == 0 ? dataCount / PAGE_ROWS : dataCount / PAGE_ROWS + 1;

		Integer beginIndex = (pageNo - 1) * PAGE_ROWS + 1;// 开始的记录
		Integer endIndex = beginIndex + PAGE_ROWS - 1;/// 结束的记录
		if (endIndex > dataCount) {
			endIndex = dataCount;
		}
		List<Integer> pageList = new ArrayList<Integer>();// 分页集合
		for (int i = 1; i <= pageCount; i++) {
			pageList.add(i);
		}
		return new PageData(beginIndex, endIndex, dataCount, pageNo, pageCount, pageList);
	}
}
