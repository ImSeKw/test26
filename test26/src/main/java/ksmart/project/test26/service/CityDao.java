package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
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
	
	// 도시 및 파일 수정 Form
	public CityAndCityFile selectCityJoinFile(int cityId) {
		logger.debug("{} : <cityId selectCityJoinFile CityDao", cityId);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityJoinFile", cityId);
	}
	
	// 도시 파일 추가 Action
	public void insertCityFile(CityFile cityFile) {
		logger.debug("{} : <cityFile insertCityFile CityDao", cityFile);
		sqlSessionTemplate.insert(NAMESPACE + "insertCityFile", cityFile);
	}
	
	// 전체 도시 수(페이징)
	public int selectCityCountByPage(Map map) {
		logger.debug("{} : <word selectCityCountByPage CityDao", map.get("word"));
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityCountByPage", map);
	}
	
	// 도시 조회(페이징)
	public List<City> selectCityListByPage(Map map) {
		logger.debug("{} : <startPage selectCityListByPage CityDao", map.get("startPage"));
		logger.debug("{} : <pagePerRow selectCityListByPage CityDao", map.get("pagePerRow"));
		logger.debug("{} : <word selectCityListByPage CityDao", map.get("word"));
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCityListByPage", map);
	}
	
	// 도시 삭제 Action
	public void deleteCity(City city) {
		logger.debug("{} : <city deleteCity CityDao", city);
		sqlSessionTemplate.delete(NAMESPACE + "deleteCity", city);
	}
	
	// 도시 수정 Action
	public void updateCity(City city) {
		logger.debug("{} : <city updateCity CityDao", city);
		sqlSessionTemplate.update(NAMESPACE + "updateCity", city);
	}
	
	// 도시 수정 Form
	public City updateCity(int cityId) {
		logger.debug("{} : <cityId updateCity CityDao", cityId);
		return sqlSessionTemplate.selectOne(NAMESPACE + "selectCityId", cityId);
	}
	
	// 도시 추가 Action
	@Insert("INSERT INTO city (city_name) VALUES (#{cityName})")
	@Options(useGeneratedKeys = true, keyProperty = "cityId")
	public int insertCity(City city) {
		logger.debug("{} : <city insertCity CityDao", city);
		sqlSessionTemplate.insert(NAMESPACE + "insertCity", city);
		int cityId = city.getCityId();
		return cityId;
	}
	
	// 도시 전체 조회
	public List<City> selectCityList() {
		logger.debug("<selectCityList CityDao");
		return sqlSessionTemplate.selectList(NAMESPACE + "selectCityList");
	}
}
