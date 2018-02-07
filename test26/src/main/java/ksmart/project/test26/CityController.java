package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.City;
import ksmart.project.test26.service.CityService;

@Controller
public class CityController {
	@Autowired
	CityService cityService;
	private static final Logger logger = LoggerFactory.getLogger(CityController.class);
	
	// 도시 삭제
	@RequestMapping(value = "/city/deleteCity", method = RequestMethod.GET)
	public String deleteCity(HttpSession httpSession, City city) {
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") != null) {
			logger.debug("Yes deleteCity CityController.java");
			cityService.deleteCity(city);
		} else {
			logger.debug("No deleteCity CityController.java");
		}
		return "redirect:/city/cityList";
	}
	
	// 도시 수정 Action
	@RequestMapping(value = "/city/updateCity", method = RequestMethod.POST)
	public String updateCity(City city) {
		cityService.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 수정 Form
	@RequestMapping(value = "/city/updateCity", method = RequestMethod.GET)
	public String updateCity(HttpSession httpSession, Model model, @RequestParam(value = "cityId") int cityId) {
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/city/cityList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			City reCity = cityService.updateCity(cityId);
			model.addAttribute("city", reCity);
			view = "city/updateCity";
		}
		logger.debug("{} : view updateCity CityController.java", view);
		return view;
	}
	
	// 도시 추가 Action
	@RequestMapping(value = "/city/insertCity", method = RequestMethod.POST)
	public String insertCity(City city) {
		cityService.insertCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 추가 Form
	@RequestMapping(value = "/city/insertCity", method = RequestMethod.GET)
	public String insertCity(HttpSession httpSession) {
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/city/cityList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "city/insertCity";
		}
		logger.debug("{} : view insertCity CityController.java", view);
		return view;
	}
	
	// 도시 전체 조회
	@RequestMapping(value = "/city/cityList", method = RequestMethod.GET)
	public String cityList(Model model) {
		List<City> list = cityService.selectCityList();
		model.addAttribute("list", list);
		return "city/cityList";
	}
}
