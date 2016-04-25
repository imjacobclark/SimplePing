package com.uk.jacob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uk.jacob.model.Website;
import com.uk.jacob.service.PingerService;

@RestController
@RequestMapping("api/v1/")
public class PingController {
	
	@Autowired
	PingerService pingerService;

	@RequestMapping(value = "ping", method = RequestMethod.GET)
	public Website getPing(@RequestParam String url){
		return pingerService.ping(url);
	}
	
}
