package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	private static final Logger logger = LoggerFactory.getLogger(CityDao.class);
	// 경로설정 중복처리
	private final String NAMESPACE = "ksmart.project.test26.mapper.CityMapper.";
	
	// 도시 삭제 Action
	public void deleteCity(City city) {
		sqlSessionTemplate.delete(NAMESPACE + "deleteCity", city);
	}
	
	// 도시 수정 Action
	public void updateCity(City city) {
		sqlSessionTemplate.update(NAMESPACE + "updateCity", city);
	}
	
	// 도시 수정 Form
	public City updateCity(int cityId) {
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityId", cityId);
	}
	
	// 도시 추가 Action
	public void insertCity(City city) {
		sqlSessionTemplate.insert(NAMESPACE + "insertCity", city);
	}
	
	// 도시 전체 조회
	public List<City> selectCityList() {
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCityList");
	}
}
