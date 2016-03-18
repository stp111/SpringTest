/**
 * 
 */
package com.example.service.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.service.HomeService;

/**
 * @author shentianping
 *
 */
public class HomeServiceTest {

	private final Logger logger = LoggerFactory.getLogger(HomeServiceTest.class);
	
	private HomeService homeService;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		homeService = new HomeService();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		homeService = null;
	}

	@Test
	public void homeTest() {
		logger.info("test home service test");
//		fail("Not yet implemented");
		
		assertNotNull(homeService.home());
		
		//
		String strExpect = "come from home";
		assertEquals(strExpect, homeService.home());
		
	}
	
	@Test
	public void homeTest2() {
		logger.info("test home service test");
		//
		String strExpect = "come from home";
		assertEquals(strExpect, homeService.home());
	}

}
