package com.seleniumautomation.mavenproject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jTest {
	public static void logs()
	{
		log.trace("This is trace log");
		log.debug("This is debug Log");
		log.info("This is Info Log");
		log.fatal("This is fatal Log");
		log.error("This is error log");
	}

	private static Logger log = LogManager.getLogger(Log4jTest.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.trace("This is trace log");
		log.debug("This is debug Log");
		log.info("This is Info Log");
		log.fatal("This is fatal Log");
		log.error("This is error log");
		//Log4jTest.logs();
	}

}
