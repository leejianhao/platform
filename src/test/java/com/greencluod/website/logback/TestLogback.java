package com.greencluod.website.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

public class TestLogback {
	final static Logger logger = LoggerFactory.getLogger(TestLogback.class);
	
	@Test
	public void test01() {
		logger.info("Entering application.");
		System.out.println("do something..");
		logger.info("Exiting application.");
		// assume SLF4J is bound to logback in the current environment
	    LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
	    // print logback's internal status
	    StatusPrinter.print(lc);

	}
	
	@Test
	public void test02() {
		logger.trace("======trace");  
		logger.debug("======debug");  
		logger.info("======info");  
		logger.warn("======warn");  
		logger.error("======error");  
	}
}
