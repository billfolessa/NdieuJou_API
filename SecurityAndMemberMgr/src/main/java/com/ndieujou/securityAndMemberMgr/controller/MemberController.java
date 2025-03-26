package com.ndieujou.securityAndMemberMgr.controller;

import java.util.Optional;

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
import com.ndieujou.securityAndMemberMgr.entity.NdieuJouIllegalArgumentException;
import com.ndieujou.securityAndMemberMgr.exception.NotFoundException;
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
	public ResponseEntity<?> createMember(@RequestBody Member mbr){
		if(mbr != null) {
			try {
				Optional<Member> resultOp = memberService.createMember(mbr);
				if(resultOp.isPresent()) {
					return new ResponseEntity<Member>(resultOp.get(), null, HttpStatus.SC_OK);
				}
			} catch (NdieuJouIllegalArgumentException e) {
				return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.SC_BAD_REQUEST);
			}
			
		}
		return new ResponseEntity<Member>(mbr, null, HttpStatus.SC_BAD_REQUEST);
		
	}
	

}
