package com.uk.jacob.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Website {
	public String url;
	public boolean response;
	public int responseCode = 0;
}
