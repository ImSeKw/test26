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
public class CountryService {
	@Autowired
	CountryDao countryDao;
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	// 도시 조회(페이징)
	public Map<String, Object> selectCountryListAndCountByPage(int currentPage, int pagePerRow, String word) {
		logger.debug("{} : CountryService selectCountryListAndCountByPage currentPage", currentPage);
		logger.debug("{} : CountryService selectCountryListAndCountByPage pagePerRow", pagePerRow);
		logger.debug("{} : CountryService selectCountryListAndCountByPage word", word);
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
		List<Country> list = countryDao.selectCountryListByPage(map);
		logger.debug("{} : CountryService selectCountryListAndCountByPage list", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = countryDao.selectCountryCountByPage(map);
		logger.debug("{} : CountryService selectCountryCountByPage count", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : CountryService selectCountryCountByPage countPage", countPage);
		// 자신의 카테고리 셋팅
		String category = "country";			
		// list와 페이지 수를 리턴하기
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		returnMap.put("word", word);
		returnMap.put("category", category);
		return returnMap;
	}
	
	// 도시 삭제 Action
	public void deleteCountry(Country country) {
		logger.debug("{} : CountryService deleteCountry country", country);
		countryDao.deleteCountry(country);
	}
	
	// 도시 수정 Action
	public void updateCountry(Country country) {
		logger.debug("{} : CountryService updateCountry country", country);
		countryDao.updateCountry(country);
	}
	
	// 도시 수정 Form
	public Country updateCountry(int countryId) {
		logger.debug("{} : CountryService updateCountry countryId", countryId);
		return countryDao.updateCountry(countryId);
	}
	
	// 도시 추가 Action
	public void insertCountry(Country country) {
		logger.debug("{} : CountryService updateCountry country", country);
		countryDao.insertCountry(country);
	}
	
	// 도시 전체 조회
	public List<Country> selectCountryList() {
		logger.debug("CountryService selectCountryList ");
		return countryDao.selectCountryList();
	}
}
