package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	// namespace (중복 처리)
	private final String NAMESPACE = "ksmart.project.test26.service.CityMapper.";
	
	// 전체 도시 목록
	public List<City> selectCityList() {
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCityList");
	}
	
	// 도시 추가
	public void insertCity(City city) {
		sqlSessionTemplate.insert(NAMESPACE + "insertCity", city);
	}
	
	// 도시 조회 (수정)
	public City selectCityName(City city) {
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityName", city);
	}
	
	// 도시 수정
	public void updateCity(City city) {
		sqlSessionTemplate.update(NAMESPACE + "updateCity", city);
	}
	
	// 도시 삭제
	public void deleteCity(City city) {
		sqlSessionTemplate.delete(NAMESPACE + "deleteCity", city);
	}
}
