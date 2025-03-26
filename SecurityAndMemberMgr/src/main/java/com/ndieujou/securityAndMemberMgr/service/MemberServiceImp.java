package com.ndieujou.securityAndMemberMgr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;

import com.google.gson.Gson;
import com.ndieujou.securityAndMemberMgr.entity.Member;
import com.ndieujou.securityAndMemberMgr.entity.NdieuJouIllegalArgumentException;
import com.ndieujou.securityAndMemberMgr.exception.NotFoundException;
import com.ndieujou.securityAndMemberMgr.model.Role;
import com.ndieujou.securityAndMemberMgr.repositoty.MemberRepository;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${spring.security-and-member-mgr.dao-service}")
	private String daoService;
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private MemberRepository memberRepository; 
	
	
	private AuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

	@Override
	public Optional<Member> createMember(Member mbr) throws NdieuJouIllegalArgumentException { 
		
			try {
				Objects.requireNonNull(mbr, "member cannot be null");
				mbr.setId(0);
				mbr.setRole(Role.USER);
				Member result = memberRepository.save(mbr);
				return Optional.of(result);
			}catch(IllegalArgumentException ex) {
				throw new NdieuJouIllegalArgumentException(ex.getMessage());
			}catch(Exception ex) {
				throw new NdieuJouIllegalArgumentException(ex.getMessage());
			}
	}
	
	@Override
	public Member updateMember(Member mbr) {
		if(mbr != null) {
			// TODO Auto-generated method stub
		}
		return null;
	}


	@Override
	public Member findMemberById(String memberId) {
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
	
	
	@Deprecated
	private Member internalSave(Member mbr) {
		if(mbr != null ) {
			try {
				Map<String,String> infosUser = getCredential();
				String pass = infosUser.get("pass");
				String username = infosUser.get("username");
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				headers.setBasicAuth(username, pass);
				HttpEntity<Member> entity = new HttpEntity<Member>(mbr, headers);
				String serviceUrl = daoService+"/daoUsers";
				String response = restTemplate.postForObject(serviceUrl, entity, String.class);
				Member mrbResult = gson.fromJson(response, Member.class);
				return mrbResult;
			}catch(Exception e) {
				log.error("MemberServiceImp ==> save()", e);
			}
		}
		return null;
	}
	

	private Map<String,String> getCredential(){
		Map<String,String> credential = new HashMap<String,String>();
		try {
			Authentication authRequest = this.authenticationConverter.convert(request);
			UsernamePasswordAuthenticationToken infosCurrentUser =(UsernamePasswordAuthenticationToken)authRequest;
			String password = (String)infosCurrentUser.getCredentials();
			String username = infosCurrentUser.getName();
			credential.put("pass", password);
			credential.put("username", username);
		}catch(Exception e) {
			log.error("MemberServiceImp ==> getCredential()", e);
		}
		return credential;
	}

	@Override
	public Member findMemberByEmail(String email) {
		Member member = memberRepository.findByEmail(email);
		return member;
	}

}
