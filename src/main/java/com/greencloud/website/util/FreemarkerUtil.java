package com.greencloud.website.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Utility Class - Freemarker Util
 * @author leejianhao
 *
 */
public class FreemarkerUtil {
	private static FreemarkerUtil util;
	private static Configuration cfg;
	
	//不可实例化
	private FreemarkerUtil() {
		cfg = new Configuration();
	}
	
	
	
	public static FreemarkerUtil getInstance(String pname) {
		if(util == null) {
			util = new FreemarkerUtil();
			cfg.setDefaultEncoding("utf-8");
			cfg.setClassForTemplateLoading(FreemarkerUtil.class, pname);
		}
		return util;
	}
	
	private Template getTemplate(String fname) {
		try {
			return cfg.getTemplate(fname);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 给予标准流的输出
	 * @param root
	 * @param fname
	 */
	public void sprint(Map<String, Object> root, String fname) {
		try {
			Template template = getTemplate(fname);
			template.setEncoding("utf-8");
			template.process(root, new PrintWriter(System.out));		
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 基于文件的输出
	 * @param root
	 * @param fname
	 */
	public void fprint(Map<String, Object> root, String fname, String outpath) {
		try {
			Template template = getTemplate(fname);
			template.setEncoding("utf-8");
			template.process(root, new FileWriterWithEncoding(outpath, "utf-8"));	
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
