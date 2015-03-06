package com.greencloud.website.freemarker;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.greencloud.website.model.Employee;
import com.greencloud.website.util.FreemarkerUtil;

public class TestFreemarkerUtil {
	
	private FreemarkerUtil util = FreemarkerUtil.getInstance("/ftl");
	private Map<String, Object> root = new HashMap<String, Object>();
	private String fpath = "D:/tmp/freemarker";
	
	@org.junit.Before
	public void setUp() {
		root.put("username", "一台笔记本闯天涯");
	}
	
	@Test
	public void test01() {
		util.sprint(root, "hello02.ftl");
	}
	
	@Test
	public void test02() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(1,"ljh",24));
		Employee emp = new Employee(1,"leejianhao", 24);
		root.put("emp", emp);
		root.put("emps", emps);
		util.sprint(root, "01.ftl");
	}
	
	@Test
	public void test03() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(1,"ljh",24));
		Employee emp = new Employee(1,"leejianhao", 24);
		root.put("emp", emp);
		root.put("emps", emps);
		util.sprint(root, "02.ftl");
	}
	
	@Test
	public void test04() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(1,"ljh",24));
		Employee emp = new Employee(1,"leejianhao", 24);
		root.put("emp", emp);
		root.put("emps", emps);
		root.put("username", "leejianhao");
		util.sprint(root, "03.ftl");
	}
	
	@Test
	public void test05() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(1,"ljh",24));
		Employee emp = new Employee(1,"leejianhao", 24);
		root.put("emp", emp);
		root.put("emps", emps);
		root.put("username", "leejianhao");
		util.sprint(root, "04.ftl");
	}
	
	@Test
	public void test06() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(1,"ljh",24));
		Employee emp = new Employee(1,"leejianhao", 24);
		root.put("emp", emp);
		root.put("emps", emps);
		root.put("username", "leejianhao");
		util.sprint(root, "05.ftl");
	}
	
}
