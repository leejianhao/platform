package com.greencloud.website.freemarker;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.Test;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.greencloud.website.model.Employee;
import com.greencloud.website.model.Field;
import com.greencloud.website.model.FilterField;
import com.greencloud.website.model.Student;
import com.greencloud.website.util.FreemarkerUtil;

import freemarker.ext.dom.NodeModel;

public class TestFreemarkerUtil {
	
	private FreemarkerUtil util = FreemarkerUtil.getInstance("/ftl");
	private Map<String, Object> root = new HashMap<String, Object>();
	private String fpath = "D:/tmp/freemarker/";
	
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
	
	@Test
	public void test07() {
		root.put("test", "你好<br/>大家好");
		util.sprint(root, "06.ftl");
	}
	
	@Test
	public void test08() {
		root.put("username", "leejianhao");
		util.sprint(root, "07.ftl");
	}
	
	@Test
	public void test09() {
		List<Employee> emps = Arrays.asList(new Employee(1,"leejianhao",24),new Employee(2,"ljh",24));
		root.put("emps",emps);
		util.fprint(root, "08.ftl",fpath+"select.html");
	}
	
	@Test
	public void test10() {
		try {
			root.put("doc", NodeModel.parse(new InputSource(
					this.getClass().getResourceAsStream("/field.xml"))));
			util.sprint(root, "09.ftl");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test11() {
		try {
			root.put("fielddoc", NodeModel.parse(new InputSource(
					this.getClass().getResourceAsStream("/field.xml"))));
			root.put("filterdoc", NodeModel.parse(new InputSource(
					this.getClass().getResourceAsStream("/objFilter.xml"))));
			root.put("obj", "student");
			util.sprint(root, "10.ftl");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test12() {
		try {
			
			List<Field> fs = new ArrayList<Field>();
			Method[] ms = Student.class.getDeclaredMethods();
			for(Method m:ms) {
				if(m.isAnnotationPresent(FilterField.class)) {
					FilterField fa = m.getAnnotation(FilterField.class);
					fs.add(new Field(fa.cid(),fa.id()));
				}
			}
			root.put("fs", fs);
			root.put("fielddoc", NodeModel.parse(new InputSource(
					this.getClass().getResourceAsStream("/field.xml"))));
			root.put("filterdoc", NodeModel.parse(new InputSource(
					this.getClass().getResourceAsStream("/objFilter.xml"))));
			root.put("obj", "student");
			util.sprint(root, "11.ftl");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void test13() {
		util.sprint(root, "12.ftl");
		util.fprint(root, "12.ftl", fpath+"pager.html");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
