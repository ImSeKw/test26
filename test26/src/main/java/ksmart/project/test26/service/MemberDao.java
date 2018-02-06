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
	private final String NAMESPACE = "ksmart.project.test26.service.MemberMapper.";
	//로그인 처리
	public Member loginMember(Member member) {
		logger.debug("{} : member selectMember MemberDao.java", member); 
		Member reMember = sqlSessionTemplate.selectOne(NAMESPACE + "selectMember", member);
		logger.debug("{} : reMember selectMember MemberDao.java", reMember);
		return reMember;
	}
	//회원가입
	public int insertMember(Member member) {
		return sqlSessionTemplate.insert(NAMESPACE + "insertMember", member);
	}
	
	//개인회원정보검색
	public Member selectMemberInfo(int memberNo) {
		return sqlSessionTemplate.selectOne(NAMESPACE +"selectMemberInfo", memberNo);
	}
	
	//회원수정
	public int updateMember(int memberNo) {
		return sqlSessionTemplate.update(NAMESPACE +"updateMember",memberNo);
	}
	
	
}
