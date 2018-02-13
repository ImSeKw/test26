package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IdolService {
	@Autowired
	IdolDao idolDao;
	private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	
	// 도시 조회(페이징)
	public Map<String, Object> selectIdolListAndCountByPage(int currentPage, int pagePerRow) {
		logger.debug("{} : <currentPage selectIdolListAndCountByPage IdolService", currentPage);
		logger.debug("{} : <pagePerRow selectIdolListAndCountByPage IdolService", pagePerRow);
		// 쿼리문의 시작 페이지
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Integer> map = new HashMap();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		List<Idol> list = idolDao.selectIdolListByPage(map);
		logger.debug("{} : >list selectIdolListAndCountByPage IdolService", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = idolDao.selectIdolCountByPage();
		logger.debug("{} : >count selectIdolListAndCountByPage IdolService", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : >countPage selectIdolListAndCountByPage IdolService", countPage);
		// list와 페이지 수를 리턴하기
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		return returnMap;
	}
	
	//아이돌 조회
	public List<Idol> selectIdolList(){
		return idolDao.selectIdolList();
	}
	
	//아이돌 추가 Action
	public int insertIdol(Idol idol) {
		return idolDao.insertIdol(idol);
	}
	
	//아이돌 수정을 위한 아이디 select
	public Idol selectAndupdateIdol(int idolId) {
		return idolDao.rselectAndupdateIdol(idolId);
	}
	
	//아이돌 수정
	public int updateIdol(Idol idol) {
		return idolDao.updateIdol(idol);
	}
	
	//아이돌 삭제
	public int deleteIdol(Idol idol) {
		return idolDao.deleteIdol(idol);
	}

}
