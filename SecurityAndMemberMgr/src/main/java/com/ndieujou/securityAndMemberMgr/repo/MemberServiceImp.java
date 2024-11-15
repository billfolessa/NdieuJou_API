package com.ndieujou.securityAndMemberMgr.repo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ndieujou.securityAndMemberMgr.model.Member;

@Service
public class MemberServiceImp implements MemberService {

	@Override
	public Member save(Member mbr) {
		if(mbr != null) {
			// TODO Auto-generated method stub
		}
		return null;
	}

	@Override
	public Member memberById(String memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Member> allMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(String memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
