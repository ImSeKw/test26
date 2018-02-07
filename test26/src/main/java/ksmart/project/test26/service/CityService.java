package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CityService {
	@Autowired
	CityDao cityDao;
	
	// 도시 삭제 Action
	public void deleteCity(City city) {
		cityDao.deleteCity(city);
	}
	
	// 도시 수정 Action
	public void updateCity(City city) {
		cityDao.updateCity(city);
	}
	
	// 도시 수정 Form
	public City updateCity(int cityId) {
		return cityDao.updateCity(cityId);
	}
	
	// 도시 추가 Action
	public void insertCity(City city) {
		cityDao.insertCity(city);
	}
	
	// 도시 전체 조회
	public List<City> selectCityList() {
		return cityDao.selectCityList();
	}
}
