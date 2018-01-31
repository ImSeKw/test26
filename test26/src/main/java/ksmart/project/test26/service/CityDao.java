package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public List<City> selectCityList() {
		return sqlSessionTemplate.selectList("ksmart.project.test26.service.CityMapper.selectCityList");
	}
}
