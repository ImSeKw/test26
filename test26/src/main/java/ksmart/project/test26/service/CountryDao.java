package ksmart.project.test26.service;

import java.util.List;

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
	
	// 나라 전체 조회
	public List<Country> selectCountryList(){
		System.out.println("01-02 CountryDao.java selectCountryList ");			
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCountryList");		
	}
	
	// 나라 입력
	public int insertCountry(Country country){
		return sqlSessionTemplate.insert(NAMESPACE + "insertCountry",country);
	}
	
	// 나라 삭제
    public int deleteCountry(int countryId) {    	
        return sqlSessionTemplate.delete(NAMESPACE + "deleteCountry",countryId);
    }
    
    // 나라 입력
    public Country selectCountryName(int countryId) {    	    	
    	System.out.println(countryId+" :CountryDao.java selectCountryName countryId");
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCountryName", countryId);
    }
    
    // 나라 수정
    public int updateCountry(Country country) {
		return sqlSessionTemplate.update(NAMESPACE + "updateCountry",country);
	}
}
