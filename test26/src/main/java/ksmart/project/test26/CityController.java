package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityDao;

@Controller
public class CityController {
	@Autowired
	CityDao cityDao;
	
	// 도시 삭제
	@RequestMapping(value = "/city/deleteCity", method = RequestMethod.POST)
	public String deleteCity(City city) {
		cityDao.deleteCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 수정
	@RequestMapping(value = "/city/updateCity", method = RequestMethod.POST)
	public String updateCity(City city) {
		cityDao.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 조회 (수정)
	@RequestMapping(value = "/city/selectCity", method = RequestMethod.GET)
	public String selectCityId(City city, Model model) {
		City reCity = cityDao.selectCityId(city);
		model.addAttribute("city", reCity);
		return "city/selectCity";
	}
	
	// 도시 입력
	@RequestMapping(value = "/city/insertCity", method = RequestMethod.POST)
	public String insertCity(City city) {
		cityDao.insertCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 전체 조회
	@RequestMapping(value = "/city/cityList", method = RequestMethod.GET)
	public String cityList(Model model) {
		List<City> list = cityDao.selectCityList();
		model.addAttribute("list", list);
		return "city/cityList";
	}
}
