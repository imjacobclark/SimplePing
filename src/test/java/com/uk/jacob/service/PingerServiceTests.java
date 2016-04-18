package com.uk.jacob.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uk.jacob.model.Ping;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PingerService.class)
@WebAppConfiguration
public class PingerServiceTests {
	
	@Test
	public void testPingerServiceReturnsOkWhenServiceIsUp(){
		PingerService pingerService = new PingerService();
		Ping ping = pingerService.ping("http://devnews.today");
		
		assertEquals(true, ping.ok);
	}
	
	@Test
	public void testPingerServiceReturnsOkWhenServiceIsDown(){
		PingerService pingerService = new PingerService();
		Ping ping = pingerService.ping("https://jacob.uk.comz");
		
		assertEquals(false, ping.ok);
	}

}
