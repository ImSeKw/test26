package ksmart.project.test26.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(MemberDao.class);
	// 경로설정 중복처리
	private final String NAMESPACE = "ksmart.project.test26.mapper.MemberMapper.";
	
	// 로그인
	public Member loginMember(Member member) {
		logger.debug("{} : <member selectMember MemberDao.java", member);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectMember", member);
	}
	
	// 회원 가입
	public int insertMember(Member member) {
		logger.debug("{} : <member selectMember MemberDao.java", member);
		return sqlSessionTemplate.insert(NAMESPACE + "insertMember", member);
	}
	
	// 회원 수정 Form
	public Member selectMemberInfo(int memberNo) {
		logger.debug("{} : <memberNo selectMember MemberDao.java", memberNo);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectMemberInfo", memberNo);
	}
	
	// 회원 수정 Action
	public int updateMember(Member member) {
		logger.debug("{} : <member selectMember MemberDao.java", member);
		return sqlSessionTemplate.update(NAMESPACE + "updateMember",member);
	}
	
	// 회원 삭제
	public int deleteMember(Member member) {
		logger.debug("{} : <member selectMember MemberDao.java", member);
		return  sqlSessionTemplate.delete(NAMESPACE + "deleteMember", member);
	}
}
