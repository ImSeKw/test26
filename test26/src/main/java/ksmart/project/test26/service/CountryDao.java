package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	String namespace = "ksmart.project.test26.service.CountryMapper.";
	
	public List<Country> selectCountryList(){
		System.out.println("01-02 CountryDao.java selectCountryList 메서드 호출");			
		return sqlSessionTemplate.selectList(namespace+"selectCountryList");		
	}
	//insertCountry
	public int insertCountry(Country country){
		return sqlSessionTemplate.insert(namespace+"insertCountry",country);
	}
	//deleteCountry
    public int deleteCountry(int countryId) {    	
        return sqlSessionTemplate.delete(namespace+"deleteCountry",countryId);
    }
    //updateForm(selectName)
    public Country selectCountryName(int countryId) {    	    	
    	System.out.println(countryId+" :CountryDao.java selectCountryName countryId");
		return sqlSessionTemplate.selectOne(namespace+"selectCountryName", countryId);
    }
}
