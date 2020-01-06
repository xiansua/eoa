package com.situ.eoa.role.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.eoa.role.domain.Role;
import com.situ.eoa.role.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_INDEX_ROLE = "role/role_index";
	private static final String PAGE_LIST_ROLE = "role/role_list";
	@Autowired
	private RoleService roleService;

	/**
	 * @ 完成新增
	 * 
	 * @param role
	 * @return
	 */
	/*
	 * 如果页面提交过来的数据是个数组，可以使用数组接受 String[] userLike。
	 * 
	 * 如果想使用集合去接受数据，则需要将集合定义到domain类中。
	 * 
	 * 
	 */
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddRole(Role role) {
		// System.out.println(userLike);

		// System.out.println(role.getUserLike());
		// String[] userLikes = request.getParameterValues("userLike");

		return roleService.saveRole(role);
	}

	/**
	 * @进首页
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX_ROLE);
		return modelAndView;
	}

	/**
	 * @查询所有的记录
	 * @param pageNo       分页的页号
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllRole(@PathVariable Integer pageNo, Role searchRole, ModelAndView modelAndView) {
		System.out.println(searchRole);
		// 要展示的列表数据
		modelAndView.addObject("roleList", roleService.findByPage(pageNo,searchRole));
		// 分页信息
		modelAndView.addObject("pageData", roleService.buildPageData(pageNo,searchRole));
		modelAndView.setViewName(PAGE_LIST_ROLE);
		return modelAndView;
	}

	// role/goupdate?rowId=1
	// role/goupdate/1
	@ResponseBody
	@RequestMapping("/goupdate/{rowId}")
	public Role goUpdate(@PathVariable("rowId") Long rowId) {
		return this.roleService.findRoleById(rowId);
	}

	@ResponseBody
	@RequestMapping("/doupdate")
	public Long doUpdateRolwr(Role role) {
		return this.roleService.doUpdate(role);
	}

	@ResponseBody
	@RequestMapping("/doelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.roleService.doDeleteRole(rowId);
	}

	// fieldId=roleName&fieldValue=admin&_=1576483347425
	@ResponseBody
	@RequestMapping("/checkRoleName")
	public String checkRoleName(String fieldId, String fieldValue) {
		// 通过服务层判断此名称是否可以使用。true：可以使用，false：不可以使用
		Boolean bool = roleService.checkRoleName(fieldValue);
		// [String,Boolean] ["roleName",true]
		// 通过使用ObjectMapper开始封装需要返回的校验结果
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bool);
		try {
			// 将封装好的校验结果转换成json格式的字符串并响应回去
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value="/checkAdmin",method = RequestMethod.POST)
	//接受来自表单的数据进行校验
	public ModelAndView doCheckAdmin(ModelAndView modelAndView,@RequestParam String userName,@RequestParam String userPass) {
		List<Role> roleList = roleService.find();
		for(Role role:roleList) {
			String name = (String)(role.getRoleName());
			String pass = (String)(role.getRolePass());
			System.out.println(name.equals(userName));
		}
		return modelAndView;
	}
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/checkRoleName") public String checkRoleName(String fieldId,
	 * String fieldValue) { System.out.println("fieldId = " + fieldId);
	 * System.out.println("fieldValue = " + fieldValue); ObjectMapper objectMapper =
	 * new ObjectMapper(); List<Object>objectList = new ArrayList<Object>();
	 * objectList.add(fieldId); objectList.add(false); try { return
	 * objectMapper.writeValueAsString(objectList); } catch (JsonProcessingException
	 * e) { e.printStackTrace(); } return null; }
	 */
}
