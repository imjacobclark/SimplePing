package com.uk.jacob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uk.jacob.model.PingRequest;
import com.uk.jacob.model.PingResponse;
import com.uk.jacob.repository.AccountRepository;
import com.uk.jacob.service.PingerService;

@RestController
@RequestMapping("api/v1/pings")
public class PingController {
	
	@Autowired
	private PingerService pingerService;

	@RequestMapping(method = RequestMethod.POST)
	public PingResponse getPing(final @RequestBody PingRequest ping){
		return pingerService.ping(ping.getHost());
	}
}
