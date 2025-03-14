package com.ndieujou.securityAndMemberMgr.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.ndieujou.securityAndMemberMgr.entity.Member;


public interface MemberRepository extends JpaRepository<Member, Long>{

	Member findByEmail( @Param("email") String emain);
}
