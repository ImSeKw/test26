package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CountryDao.class);
	// 경로설정 중복처리
	private final String NAMESPACE = "ksmart.project.test26.mapper.CountryMapper.";
	
	// 전체 도시 수(페이징)
	public int selectCountryCountByPage(Map map) {
		logger.debug("{} : CountryDao selectCountryDaoCountByPage word", map.get("word"));
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCountryCountByPage", map);
	}
	
	// 도시 조회(페이징)
	public List<Country> selectCountryListByPage(Map map) {
		logger.debug("{} : CountryDao selectCountryDaoListByPage startPage", map.get("startPage"));
		logger.debug("{} : CountryDao selectCountryDaoListByPage pagePerRow", map.get("pagePerRow"));
		logger.debug("{} : CountryDao selectCountryDaoListByPage word", map.get("word"));
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCountryListByPage", map);
	}
	
	// 도시 삭제 Action
	public void deleteCountry(int countryId) {
		logger.debug("{} : CountryDao deleteCountry countryId", countryId);
		sqlSessionTemplate.delete(NAMESPACE + "deleteCountry", countryId);
	}
	
	// 도시 수정 Action
	public void updateCountry(Country country) {
		logger.debug("{} : CountryDao deleteCountry country", country);
		sqlSessionTemplate.update(NAMESPACE + "updateCountry", country);
	}
	
	// 도시 수정 Form
	public Country updateCountry(int countryId) {
		logger.debug("{} : CountryDao updateCountry countryId", countryId);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCountryId", countryId);
	}
	
	
	// 도시 추가 Action
	public int insertCountry(Country country) {
		logger.debug("{} : CountryDao insertCountry country", country);
		sqlSessionTemplate.insert(NAMESPACE + "insertCountry", country);
		return 0;
	}
	
	// 파일 업로드 Action 
	public void insertCountryFile(CountryFile countryFile) {
		logger.debug("{} : CountryDao insertCountry countryFile", countryFile);
		sqlSessionTemplate.insert(NAMESPACE + "insertCountryFileUpload", countryFile);
	}
	// 도시 전체 조회
	public List<Country> selectCountryList() {
		logger.debug("CountryDao selectCountryList");
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCountryList");
	}
}
