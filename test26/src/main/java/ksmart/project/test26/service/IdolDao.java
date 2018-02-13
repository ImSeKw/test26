package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class IdolDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(IdolDao.class);
	// 경로설정 중복처리
	private final String Route = "ksmart.project.test26.mapper.IdolMapper.";
	
	// 전체 아이돌 수(페이징)
	public int selectIdolCountByPage() {
		logger.debug("<selectIdolCountByPage IdolDao");
		return sqlSessionTemplate.selectOne(Route + "selectIdolCountByPage");
	}
	
	// 아이돌 조회(페이징)
	public List<Idol> selectIdolListByPage(Map map) {
		logger.debug("{} : <startPage selectIdolListByPage IdolDao", map.get("startPage"));
		logger.debug("{} : <pagePerRow selectIdolListByPage IdolDao", map.get("pagePerRow"));
		return sqlSessionTemplate.selectList(Route + "selectIdolListByPage", map);
	}
	
	// idolList 조회
	public List<Idol> selectIdolList() {
		return sqlSessionTemplate.selectList(Route + "selectIdolList"); 
	}
	
	// idol추가입력
	public int insertIdol(Idol idol) {
		return sqlSessionTemplate.insert(Route + "insertIdol", idol);
	}
	
	// idol수정처리
	public int updateIdol(Idol idol) {
		return sqlSessionTemplate.update(Route + "updateIdol", idol);
	}
	
	// idol 수정처리 id값조회
	public Idol rselectAndupdateIdol(int idolId) {
		return sqlSessionTemplate.selectOne(Route + "selectAndupdateIdol", idolId);
	}
	
	// idol삭제처리
	public int deleteIdol(Idol idol) {
		return sqlSessionTemplate.delete(Route + "deleteIdol", idol);
	}
}