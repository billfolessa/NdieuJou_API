package com.ndieujou.securityAndMemberMgr.service;

import java.util.List;

import com.ndieujou.securityAndMemberMgr.entity.Member;

public interface MemberService {
	
	public Member createMember(Member mbr);
	
	public Member memberById(String memberId);
	
	public Member memberByEmail(String email);
	
	public List<Member> allMember();
	
	public int deleteMember(String memberId);
	
	public Member update(Member mbr) ;

}
