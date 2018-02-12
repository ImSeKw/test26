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
	//나라 전체 조회
	//public List<Country>selectCountryList(int page, String word){	
	public Map<String, Object>selectCountryListAndCountByPage(int currentPage,int pagePerRow ){	
		logger.debug("{} : CountryService.java selectCountryListAndCountByPage currentPage", currentPage);
		logger.debug("{} : CountryService.java selectCountryListAndCountByPage pagePerRow", pagePerRow);
		// 쿼리문의 시작 페이지
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("startPage", startPage);
		map.put("pagePerRow",pagePerRow);
		//map.put("word", word);
		// CountryDao에 startPage,pagePerRow보내기
		List<Country> list = countryDao.selectCountryListByPage(map);
		logger.debug("{} : CountryService.java selectCountryListAndCountByPage list", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = countryDao.selectCountryCountByPage();
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : CountryService.java selectCountryListAndCountByPage countPage", countPage);
		//list와 page 수를 리턴
		Map<String,Object> reMap = new HashMap<String, Object>();
		reMap.put("list", list);
		reMap.put("counyPage", countPage);
		return reMap;		
	}
	//나라 입력 Action
	public void insertCountry(Country country) {
		countryDao.insertCountry(country);
	}
	//나라 수정 Form
	public Country selectCountryName(int countryId) {
		return countryDao.selectCountryName(countryId);
	}
	//나라 수정 Action
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
	//나라 삭제 Action
	public void deleteCountry(int countryId) {
		countryDao.deleteCountry(countryId);
	}

}
