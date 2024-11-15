package com.ndieujou.securityAndMemberMgr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {
	
	@GetMapping(path = "/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping(path = "/admin/")
	public String helloAdmin() {
		return "helloAdmin";
	}

}
