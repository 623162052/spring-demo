package com.jdbc;

import com.jdbc.dao.CfgCodeDao;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertNotSame;

public class AppConfigTest {
	
	private Logger logger = Logger.getLogger(AppConfigTest.class);
	
	private ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	public void testGetCfgCodeCount() {
		CfgCodeDao cfgCodeDao = ctx.getBean(CfgCodeDao.class);
		logger.debug("cfgCodeCount: " + cfgCodeDao.getCfgCodeCount());
		assertNotSame(0, cfgCodeDao.getCfgCodeCount());
	}

}
