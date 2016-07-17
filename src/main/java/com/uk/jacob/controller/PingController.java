package com.uk.jacob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uk.jacob.model.Ping;
import com.uk.jacob.model.Website;
import com.uk.jacob.service.PingerService;

@RestController
@RequestMapping("api/v1/")
public class PingController {
	
	@Autowired
	PingerService pingerService;

	@RequestMapping(value = "ping", method = RequestMethod.POST)
	public Website getPing(@RequestBody Ping ping){
		return pingerService.ping(ping.getHost());
	}
}
