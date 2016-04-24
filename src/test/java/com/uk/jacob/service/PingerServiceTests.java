package com.uk.jacob.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uk.jacob.SimplePingApplication;
import com.uk.jacob.model.Website;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SimplePingApplication.class)
@WebAppConfiguration
public class PingerServiceTests {
	
	@Autowired
	PingerService pingerService;
	
	@Test
	public void testPingerServiceReturnsOkWhenServiceIsUp(){
		Website website = pingerService.ping("http://devnews.today");
		
		assertEquals(true, website.ok);
	}
	
	@Test
	public void testPingerServiceReturnsOkWhenServiceIsDown(){
		Website website = pingerService.ping("https://jacob.uk.comz");

		assertEquals(false, website.ok);
	}

}
