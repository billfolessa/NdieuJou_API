package com.ndieujou.securityAndMemberMgr.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.entity.NdieuJouIllegalArgumentException;
import com.ndieujou.securityAndMemberMgr.exception.NotFoundException;
import com.ndieujou.securityAndMemberMgr.repositoty.MemberRepository;
import com.ndieujou.securityAndMemberMgr.service.MemberServiceImp;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
	
	@Mock
	private MemberRepository memberRepository;
	
	@InjectMocks
	private MemberServiceImp memberService;
	
	@Test
	public void testCreateMember() throws NdieuJouIllegalArgumentException {
		
		Member member = new Member();
		member.setAboutMe("data about member item");
		member.setEmail("member@gmail.com");
		member.setAddress("longieuil, QC");
		member.setPassword("pass");

		Mockito.when(memberRepository.save(member)).thenReturn(member);
		Optional<Member> resultOp = memberService.createMember(member);
		
		NdieuJouIllegalArgumentException ex =assertThrows(NdieuJouIllegalArgumentException.class, ()->memberService.createMember(null));
		
		assertEquals(member, resultOp.get());
		assertEquals(ex.getMessage(), "member cannot be null");
		Mockito.verify(memberRepository,times(1)).save(member);
		
		
	}

}
