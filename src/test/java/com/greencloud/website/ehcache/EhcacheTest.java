package com.greencloud.website.ehcache;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.greencloud.website.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = {"classpath:beans.xml"})  
public class EhcacheTest {
	@Resource  
	private ApplicationContext ctx; 
	
	@Test
	public void testEhcache() {
		System.out.println(ctx.containsBean("userService"));
		IUserService userService = ctx.getBean("userService", IUserService.class);
		System.out.println(userService.findByName("leejianhao"));
		System.out.println(userService.findByName("leejianhao"));
	}
	 
	
}
