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
public class CityService {
	@Autowired
	CityDao cityDao;
	private static final Logger logger = LoggerFactory.getLogger(CityService.class);
	
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
	
	// 도시 추가 Action
	public void insertCity(City city) {
		logger.debug("{} : <city insertCity CityService", city);
		cityDao.insertCity(city);
	}
	
	// 도시 전체 조회
	public List<City> selectCityList() {
		logger.debug(">selectCityList CityService");
		return cityDao.selectCityList();
	}
}
