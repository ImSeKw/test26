package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CountryDao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	public List<Country> selectCountryList(){
		System.out.println("01-02CountryDao.java selectCountryList 메서드 호출");	
		
		return sqlSessionTemplate.selectList("ksmart.project.test26.service.CountryMapper.selectCountryList");
		
	}	
}
