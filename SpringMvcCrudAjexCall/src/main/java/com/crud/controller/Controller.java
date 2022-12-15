package com.crud.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/")
	public String prilogin() {
		return "home";
	}
	
	
}
