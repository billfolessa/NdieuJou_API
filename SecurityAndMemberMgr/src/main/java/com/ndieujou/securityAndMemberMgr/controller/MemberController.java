package com.ndieujou.securityAndMemberMgr.controller;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.service.MemberService;


@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	 private MemberService memberService;
	
	@GetMapping(path = "/")
	public String hello() {
		return "hello";
	}
	
	@GetMapping(path = "/save")
	public String hello1() {
		return "save";
	}
	
	@GetMapping(path = "/admin/")
	public String helloAdmin() {
		return "helloAdmin";
	}
	
	@PostMapping("/create")
	public ResponseEntity<Member> createMember(@RequestBody Member mbr){
		if(mbr != null) {
			Member result = memberService.createMember(mbr);
			if(result != null) {
				return new ResponseEntity<Member>(result, null, HttpStatus.SC_OK);
			}
		}
		return new ResponseEntity<Member>(mbr, null, HttpStatus.SC_BAD_REQUEST);
		
	}
	

}
