package com.ndieujou.securityAndMemberMgr.repo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationConverter;

import com.google.gson.Gson;
import com.ndieujou.securityAndMemberMgr.model.Member;
import com.ndieujou.securityAndMemberMgr.model.Role;

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
	
	
	private AuthenticationConverter authenticationConverter = new BasicAuthenticationConverter();

	@Override
	public Member save(Member mbr) { 
		if(mbr != null ) {
			mbr.setId(0);
			mbr.setRole(Role.USER);
			Member result = internalSave(mbr);
			return result;
		}
		return mbr;
	}
	
	@Override
	public Member update(Member mbr) {
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

}
