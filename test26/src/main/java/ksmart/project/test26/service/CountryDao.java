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
	private SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CountryDao.class);
	// 경로설정 중복처리
	private final String NAMESPACE = "ksmart.project.test26.mapper.CountryMapper.";
	// country 전체  개수
	public int selectCountryCountByPage() {
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityCountByPage");
	}
	// country 페이징 작업 조회
	public List<Country> selectCountryListByPage(Map<String,Object> map){
		logger.debug("{} : CountryDao.java selectCityListByPage startPage", map.get("startPage"));
		logger.debug("{} : CountryDao.java selectCityListByPage pagePerRow", map.get("pagePerRow"));
		logger.debug("{} : CountryDao.java selectCityListByPage word", map.get("word"));
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCityListByPage", map);
	}
	// 나라 전체 조회
	public List<Country> selectCountryList(){ 
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCountryList");		
	}
	// 나라 입력
	public void insertCountry(Country country){
		logger.debug("{} : CountryDao.java insertCountry country", country);
		sqlSessionTemplate.insert(NAMESPACE + "insertCountry",country);
	}
	// 나라 삭제
    public int deleteCountry(int countryId) {    	
        return sqlSessionTemplate.delete(NAMESPACE + "deleteCountry",countryId);
    }
    // 나라 이름 조회
    public Country selectCountryName(int countryId) {    	
		logger.debug("{} : CountryDao.java selectCountryName countryId", countryId);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCountryName", countryId);
    }
    // 나라 수정
    public void updateCountry(Country country) {
		sqlSessionTemplate.update(NAMESPACE + "updateCountry",country);
	}
}
