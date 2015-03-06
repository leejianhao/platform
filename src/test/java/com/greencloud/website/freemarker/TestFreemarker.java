package com.greencloud.website.freemarker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.junit.Test;

import com.greencloud.website.util.FreemarkerUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TestFreemarker {
	
	@Test
	public void testHello() throws IOException, TemplateException {
		//1.创建Configuration
		Configuration cfg = new Configuration();
		//2.设置config中加载模版的路径
		//设置基于classpath加载路径，并且所有的模版文件放在/ftl中
		cfg.setClassForTemplateLoading(TestFreemarker.class, "/ftl");
		//3.获取模版文件,由于已经设置了默认路径为/ftl,此时hello.ftl就是ftl下的文件
		Template template = cfg.getTemplate("hello.ftl");
		//4.创建数据文件，非常类似于OGNL,使用map来进行设置
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("username", "一台笔记本闯天涯");
		//5.通过模版和数据进行输出
		template.process(root, new PrintWriter(System.out));
	}
	
	@Test
	public void testHello2() throws IOException, TemplateException {
		//1.创建Configuration
		Configuration cfg = new Configuration();
		//2.设置config中加载模版的路径
		//设置基于classpath加载路径，并且所有的模版文件放在/ftl中
		cfg.setClassForTemplateLoading(TestFreemarker.class, "/ftl");
		//3.获取模版文件,由于已经设置了默认路径为/ftl,此时hello.ftl就是ftl下的文件
		Template template = cfg.getTemplate("hello.ftl");
		template.setEncoding("utf-8");
		//4.创建数据文件，非常类似于OGNL,使用map来进行设置
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("username", "一台笔记本闯天涯");
		//5.通过模版和数据进行输出
		template.process(root, new FileWriterWithEncoding("D:\\tmp\\freemarker\\hello.html","utf-8"));
	}
	
}
