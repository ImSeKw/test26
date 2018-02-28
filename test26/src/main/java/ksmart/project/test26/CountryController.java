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

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryCommand;
import ksmart.project.test26.service.CountryService;

@Controller
public class CountryController {
	@Autowired
	CountryService countryService;
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);
	
	

	// 도시 조회(페이징)
	@RequestMapping(value = "/country/countryList", method = RequestMethod.GET)
	public String selectCountryListAndCountByPage(Model model, HttpSession httpSession
										, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										, @RequestParam(value = "pagePerRow", required = false, defaultValue = "5") int pagePerRow
										, @RequestParam(value = "word", required = false) String word) {
		logger.debug("{} : CountryController selectCountryListAndCountByPage currentPage", currentPage);
		logger.debug("{} : CountryController selectCountryListAndCountByPage pagePerRow", pagePerRow);
		logger.debug("{} : CountryController selectCountryListAndCountByPage word", word);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Map<String, Object> map = countryService.selectCountryListAndCountByPage(currentPage, pagePerRow, word);
			List<Country> list = (List<Country>)map.get("list");
			int countPage = (Integer)map.get("countPage");
			word = (String)map.get("word");
			String category = (String)map.get("category");
			logger.debug("{} : CountryController selectCountryListAndCountByPage list", list);
			logger.debug("{} : CountryController selectCountryListAndCountByPage countPage", countPage);
			logger.debug("{} : CountryController selectCountryListAndCountByPage word", word);
			logger.debug("{} : CountryController selectCountryListAndCountByPage category", category);
			model.addAttribute("list", list);
			model.addAttribute("countPage", countPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("word", word);
			model.addAttribute("category", category);
			view = "country/countryList";
		}
		logger.debug("{} : CountryController view", view);
		return view;
	}
	
	// 도시 삭제
	@RequestMapping(value = "/country/deleteCountry", method = RequestMethod.GET)
	public String deleteCountry(HttpSession httpSession, int countryId) {
		logger.debug("{} : CountryController deleteCountry httpSession", httpSession);
		logger.debug("{} : CountryController deleteCountry countryId", countryId);
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") != null) {
			countryService.deleteCountry(countryId);
		}
		return "redirect:/country/countryList";
	}
	
	// 도시 수정 Action
	@RequestMapping(value = "/country/updateCountry", method = RequestMethod.POST)
	public String updateCountry(Country country) {
		logger.debug("{} : CountryController updateCountry country", country);
		countryService.updateCountry(country);
		return "redirect:/country/countryList";
	}
	// 도시 수정 Form
	@RequestMapping(value = "/country/updateCountry", method = RequestMethod.GET)
	public String updateCountry(HttpSession httpSession, Model model, @RequestParam(value = "countryId") int countryId) {
		logger.debug("{} : CountryController updateCountry httpSession", httpSession);
		logger.debug("{} : CountryController updateCountry model", model);
		logger.debug("{} : CountryController updateCountry countryId", countryId);
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/country/countryList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Country reCountry = countryService.updateCountry(countryId);
			logger.debug("{} : CountryController updateCountry reCountry", reCountry);
			model.addAttribute("country", reCountry);
			view = "country/updateCountry";
		}
		logger.debug("{} : CountryController updateCountry view", view);
		return view;
	}
	
	// 도시 추가 Action
	@RequestMapping(value = "/country/insertCountry", method = RequestMethod.POST)
	public String insertCountry(CountryCommand countryCommand) {
		logger.debug("{} : CountryController insertCountry countryCommand", countryCommand);
		countryService.insertCountry(countryCommand);
		return "redirect:/country/countryList";
	}
	
	// 도시 추가 Form
	@RequestMapping(value = "/country/insertCountry", method = RequestMethod.GET)
	public String insertCountry(HttpSession httpSession) {
		logger.debug("{} : CountryController insertCountry httpSession", httpSession);
		String view = null;
		// 로그인 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/country/countryList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "country/insertCountry";
		}
		logger.debug("{} : CountryController insertCountry view", view);
		return view;
	}
	
	// 도시 전체 조회
	@RequestMapping(value = "/country/countryListAll", method = RequestMethod.GET)
	public String countryList(HttpSession httpSession, Model model) {
		logger.debug("{} : CountryController countryList httpSession", httpSession);
		logger.debug("{} : CountryController countryList model", model);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			List<Country> list = countryService.selectCountryList();
			logger.debug("{} : CountryController countryList list", list);
			model.addAttribute("list", list);
			view = "country/countryList";
		}
		logger.debug("{} : CountryController countryList view", view);
		return view;
	}
}
