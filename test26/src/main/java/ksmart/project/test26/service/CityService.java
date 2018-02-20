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
public class CityService {
	@Autowired
	CityDao cityDao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
	// 도시 및 파일 수정 Form
	public CityAndCityFile selectCityJoinFile(int cityId) {
		logger.debug("{} : <cityId selectCityJoinFile CityService", cityId);
		return cityDao.selectCityJoinFile(cityId);
	}
	
	// 도시 조회(페이징)
	public Map<String, Object> selectCityListAndCountByPage(int currentPage, int pagePerRow, String word) {
		logger.debug("{} : <currentPage selectCityListAndCountByPage CityService", currentPage);
		logger.debug("{} : <pagePerRow selectCityListAndCountByPage CityService", pagePerRow);
		logger.debug("{} : <word selectCityListAndCountByPage CityService", word);
		// 쿼리문의 시작 페이지
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// word가 ""일 때 null 처리
		/*if(word.equals("")) {
			word = null;
		}*/
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Object> map = new HashMap();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		map.put("word", word);
		List<City> list = cityDao.selectCityListByPage(map);
		logger.debug("{} : >list selectCityListAndCountByPage CityService", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = cityDao.selectCityCountByPage(map);
		logger.debug("{} : >count selectCityListAndCountByPage CityService", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : >countPage selectCityListAndCountByPage CityService", countPage);
		// 자신의 카테고리 셋팅
		String category = "city";
		// list와 페이지 수를 리턴하기
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		returnMap.put("word", word);
		returnMap.put("category", category);
		return returnMap;
	}
	
	// 도시 삭제 Action
	public void deleteCity(City city) {
		logger.debug("{} : <city deleteCity CityService", city);
		cityDao.deleteCity(city);
	}
	
	// 도시 수정 Action
	public void updateCity(City city) {
		logger.debug("{} : <city updateCity CityService", city);
		cityDao.updateCity(city);
	}
	
	// 도시 수정 Form
	public City updateCity(int cityId) {
		logger.debug("{} : <cityId updateCity CityService", cityId);
		return cityDao.updateCity(cityId);
	}
	
	// 도시 추가 및 도시 파일 추가 Action
	public void insertCity(CityCommand cityCommand, String path) {
		logger.debug("{} : <city.getCityName() insertCity CityService", cityCommand.getCityName());
		logger.debug("{} : <cityCommand.getFile().size() insertCity CityService", cityCommand.getFile().size());
		// 도시명 셋팅 후 Id값 받기
		City city = new City();
		city.setCityName(cityCommand.getCityName());
		int cityId = cityDao.insertCity(city);
		logger.debug("{} : ^cityId insertCity CityService", cityId);
		// 1 : N개의 파일 insert
		for(MultipartFile file : cityCommand.getFile()) {
			// 파일 하나당 한번의 DTO
			CityFile cityFile = new CityFile();
			// 중복되지 않는 파일 이름 만들기
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();
			logger.debug("{} : ^fileName insertCity CityService", fileName);
			// 원래 이릅에서 확장자만 추출
			String originalName = file.getOriginalFilename();
			int fileExtNumber = originalName.indexOf(".");
			String fileExt = originalName.substring(fileExtNumber + 1);
			logger.debug("{} : ^fileExt insertCity CityService", fileExt);
			logger.debug("{} : ^file.getSize() insertCity CityService", file.getSize());
			// 셋팅
			cityFile.setCityId(cityId);
			cityFile.setFileName(fileName);
			cityFile.setFileExt(fileExt);
			cityFile.setFileSize(file.getSize());
			// 저장
			cityDao.insertCityFile(cityFile);
			File temp = new File(path + "\\" + fileName + "." + fileExt); // resource로 변경하기
			logger.debug("{} : ^temp insertCity CityService", temp);
			try { file.transferTo(temp); } catch (IllegalStateException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		}
	}
	
	// 도시 전체 조회
	public List<City> selectCityList() {
		logger.debug(">selectCityList CityService");
		return cityDao.selectCityList();
	}
}
