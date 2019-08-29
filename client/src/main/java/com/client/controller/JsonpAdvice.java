package com.client.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

@ControllerAdvice(basePackages = "com.client.controller.jsonp")
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {

	public JsonpAdvice(){
		super("callback","jsonp");
	}
}
