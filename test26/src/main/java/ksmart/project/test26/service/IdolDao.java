package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	// 경로설정 중복처리
	private final String Route = "ksmart.project.test26.service.IdolMapper.";
	
	// idolList 조회
	public List<Idol> selectIdolList() {
		return sqlSessionTemplate.selectList(Route + "selectIdolListDAO"); 
	}
	
	// idol추가입력
	public void insertIdol(Idol idol) {
		sqlSessionTemplate.insert(Route + "insertIdolDAO");
	}
	
	// idol수정처리
	public void updateIdol(Idol idol) {
		sqlSessionTemplate.update(Route + "updateIdolDAO");
	}
	
	// idol삭제처리
	public void deleteIdol(Idol idol) {
		sqlSessionTemplate.delete(Route + "deleteIdolDAO");
	}
}