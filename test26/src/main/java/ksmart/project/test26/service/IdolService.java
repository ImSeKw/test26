package ksmart.project.test26.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class IdolService {
	@Autowired
	IdolDao idolDao;
	private static final Logger logger = LoggerFactory.getLogger(IdolService.class);
	
	// 아이돌 조회(페이징)
	public Map<String, Object> selectIdolListAndCountByPage(int currentPage, int pagePerRow, String word) {
		logger.debug("{} : <currentPage selectIdolListAndCountByPage IdolService", currentPage);
		logger.debug("{} : <pagePerRow selectIdolListAndCountByPage IdolService", pagePerRow);
		logger.debug("{} : <word selectIdolListAndCountByPage IdolService", word);
		// 쿼리문의 시작 페이지
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Object> map = new HashMap();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		map.put("word", word);
		List<Idol> list = idolDao.selectIdolListByPage(map);
		logger.debug("{} : >list selectIdolListAndCountByPage IdolService", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = idolDao.selectIdolCountByPage(map);
		logger.debug("{} : >count selectIdolListAndCountByPage IdolService", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : >countPage selectIdolListAndCountByPage IdolService", countPage);
		String category = "idol";
		// list와 페이지 수를 리턴하기
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		returnMap.put("word", word);
		returnMap.put("category", category);
		return returnMap;
	}
	
	//아이돌 추가 및 File추가 Action
	public void insertIdol(IdolCommand idolCommand) {
		Idol idol = new Idol();
		idol.setIdolName(idolCommand.getIdolName());
		int idolID = idolDao.insertIdol(idol);
		logger.debug("{} : <--idolID insertidol IdolService", idolID);
		for(MultipartFile file : idolCommand.getFile()) {
			// 1. DB에 입력
			IdolFile idolFile = new IdolFile();
			// 중복되지 않는 이름
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();
			logger.debug("{} : <--fileName insertIdol IdolService", fileName);
			// 확장자 추출
			String originalName = file.getOriginalFilename();
			int fileExtNumber = originalName.indexOf(".");
			String fileExt = originalName.substring(fileExtNumber + 1);
			logger.debug("{} : <--fileExt insertIdol IdolService", fileExt);
			logger.debug("{} : <--file.getSize() insertIdol IdolService", file.getSize());
			// 셋팅
			idolFile.setIdolID(idolID);
			idolFile.setFileName(fileName);
			idolFile.setFileExt(fileExt);
			idolFile.setFileSize(file.getSize());
			// 저장
			idolDao.insertIdolFile(idolFile);
			File temp = new File("c:\\upload\\" + fileName);
			try { file.transferTo(temp); } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		}
		
	}
	
	//아이돌 조회
	public List<Idol> selectIdolList(){
		return idolDao.selectIdolList();
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
