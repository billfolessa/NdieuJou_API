package com.ndieujou.securityAndMemberMgr.repo;

import java.util.List;

import com.ndieujou.securityAndMemberMgr.model.Member;

public interface MemberService {
	
	public Member save(Member mbr);
	
	public Member memberById(String memberId);
	
	public List<Member> allMember();
	
	public int deleteMember(String memberId);

}
