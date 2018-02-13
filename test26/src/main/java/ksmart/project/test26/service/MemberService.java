package ksmart.project.test26.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberService.class);
	
	// 로그인
	public Member loginMember(Member member) {
		logger.debug("{} : <member selectMember MemberService", member);
		return memberDao.loginMember(member);
	}
	
	// 회원 가입
	public int insertMember(Member member) {
		logger.debug("{} : <member selectMember MemberService", member);
		return memberDao.insertMember(member);
	}
	
	// 회원 수정 Form
	public Member selectMemberInfo(int memberNo) {
		logger.debug("{} : <memberNo selectMember MemberService", memberNo);
		return memberDao.selectMemberInfo(memberNo);
	}
	
	// 회원 수정 Action
	public int updateMember(Member member) {
		logger.debug("{} : <member selectMember MemberService", member);
		return memberDao.updateMember(member);
	}
	
	// 회원 삭제
	public int deleteMember(Member member) {
		logger.debug("{} : <member selectMember MemberService", member);
		return  memberDao.deleteMember(member);
	}
}
