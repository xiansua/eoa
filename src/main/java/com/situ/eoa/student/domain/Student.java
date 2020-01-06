package com.situ.eoa.student.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.situ.eoa.base.domain.BaseClass;

/**
 * 学生类
 *
 */
public class Student extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long clazzId;// 班级主键
	private String stuCode;// 学生编号
	private String stuName;// 学生名称
	private Integer stuSex;// 学生性别
	//告诉SpringMVC按照 指定的格式将字符串转换成Date。
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date stuBirthday;// 学生生日

	public Long getClazzId() {
		return clazzId;
	}

	public void setClazzId(Long clazzId) {
		this.clazzId = clazzId;
	}

	public String getStuCode() {
		return stuCode;
	}

	public void setStuCode(String stuCode) {
		this.stuCode = stuCode;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getStuSex() {
		return stuSex;
	}

	public void setStuSex(Integer stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuBirthday() {
		return stuBirthday;
	}

	public void setStuBirthday(Date stuBirthday) {
		this.stuBirthday = stuBirthday;
	}
}
