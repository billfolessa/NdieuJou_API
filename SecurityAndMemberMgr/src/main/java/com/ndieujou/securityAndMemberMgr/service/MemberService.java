package com.ndieujou.securityAndMemberMgr.service;

import java.util.List;
import java.util.Optional;

import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.entity.NdieuJouIllegalArgumentException;
import com.ndieujou.securityAndMemberMgr.exception.NotFoundException;

public interface MemberService {
	
	public Optional<Member>  createMember(Member mbr) throws NdieuJouIllegalArgumentException;
	
	public Member findMemberById(String memberId);
	
	public Member findMemberByEmail(String email);
	
	public List<Member> allMember();
	
	public int deleteMember(String memberId);
	
	public Member updateMember(Member mbr) ;

}
