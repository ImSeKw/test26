package ksmart.project.test26;

import java.util.List;
import java.util.Map;

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
	
	// 도시 조회(페이징)
	@RequestMapping(value = "/City/CityList", method = RequestMethod.GET)
	public String selectCityListAndCountByPage(Model model, HttpSession httpSession
										, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										, @RequestParam(value = "pagePerRow", required = false, defaultValue = "5") int pagePerRow
										, @RequestParam(value = "word", required = false) String word) {
		logger.debug("{} : <currentPage selectCityListAndCountByPage CityController", currentPage);
		logger.debug("{} : <pagePerRow selectCityListAndCountByPage CityController", pagePerRow);
		logger.debug("{} : <word selectCityListAndCountByPage CityController", word);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Map<String, Object> map = cityService.selectCityListAndCountByPage(currentPage, pagePerRow, word);
			List<City> list = (List<City>)map.get("list");
			int countPage = (Integer)map.get("countPage");
			word = (String)map.get("word");
			logger.debug("{} : >list selectCityListAndCountByPage CityController", list);
			logger.debug("{} : >countPage selectCityListAndCountByPage CityController", countPage);
			logger.debug("{} : >word selectCityListAndCountByPage CityController", word);
			model.addAttribute("list", list);
			model.addAttribute("countPage", countPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("word", word);
			view = "city/cityList";
		}
		logger.debug("{} : >view cityList CityController", view);
		return view;
	}
	
	// 도시 삭제
	@RequestMapping(value = "/City/deleteCity", method = RequestMethod.GET)
	public String deleteCity(HttpSession httpSession, City city) {
		logger.debug("{} : <httpSession deleteCity CityController", httpSession);
		logger.debug("{} : <city deleteCity CityController", city);
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") != null) {
			cityService.deleteCity(city);
		}
		return "redirect:/city/cityList";
	}
	
	// 도시 수정 Action
	@RequestMapping(value = "/City/updateCity", method = RequestMethod.POST)
	public String updateCity(City city) {
		logger.debug("{} : <city updateCity CityController", city);
		cityService.updateCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 수정 Form
	@RequestMapping(value = "/City/updateCity", method = RequestMethod.GET)
	public String updateCity(HttpSession httpSession, Model model, @RequestParam(value = "cityId") int cityId) {
		logger.debug("{} : <httpSession updateCity CityController", httpSession);
		logger.debug("{} : <model updateCity CityController", model);
		logger.debug("{} : <cityId updateCity CityController", cityId);
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/city/cityList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			City reCity = cityService.updateCity(cityId);
			logger.debug("{} : >reCity updateCity CityController", reCity);
			model.addAttribute("city", reCity);
			view = "city/updateCity";
		}
		logger.debug("{} : >view updateCity CityController", view);
		return view;
	}
	
	// 도시 추가 Action
	@RequestMapping(value = "/City/insertCity", method = RequestMethod.POST)
	public String insertCity(City city) {
		logger.debug("{} : <city insertCity CityController", city);
		cityService.insertCity(city);
		return "redirect:/city/cityList";
	}
	
	// 도시 추가 Form
	@RequestMapping(value = "/City/insertCity", method = RequestMethod.GET)
	public String insertCity(HttpSession httpSession) {
		logger.debug("{} : <httpSession insertCity CityController", httpSession);
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/city/cityList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "city/insertCity";
		}
		logger.debug("{} : >view insertCity CityController", view);
		return view;
	}
	
	// 도시 전체 조회
	@RequestMapping(value = "/City/cityListAll", method = RequestMethod.GET)
	public String cityList(HttpSession httpSession, Model model) {
		logger.debug("{} : <httpSession cityList CityController", httpSession);
		logger.debug("{} : <model cityList CityController", model);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			List<City> list = cityService.selectCityList();
			logger.debug("{} : >list cityList CityController", list);
			model.addAttribute("list", list);
			view = "city/cityList";
		}
		logger.debug("{} : >view cityList CityController", view);
		return view;
	}
}
