package ksmart.project.test26;


import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryService;

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

@Controller
public class CountryController {
	@Autowired
	private CountryService countryService;
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	//나라 전체 조회
	@RequestMapping(value="/country/countryList")		
	public String CountryList(HttpSession httpSession
			, Model model 
			,@RequestParam(value="currentPage",defaultValue="1",required=false) int currentPage
			,@RequestParam(value="pagePerRow",defaultValue="5",required=false) int pagePerRow
			//,@RequestParam(value="word",required=false)String word
			) {	
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember")==null) { //세션에 로그인정보가 없다면
			view = "redirect:/";
		}else if(httpSession.getAttribute("loginMember")!=null) { //세션에 로그인정보가 있다면
			//List<Country> list = countryService.selectCountryList(page,word); 	
			logger.debug("01_01 CountryController.java CountryList model");
			Map<String, Object> map = countryService.selectCountryListAndCountByPage(currentPage, pagePerRow);
			List<Country> list = (List<Country>)map.get("list");
			//int countPage = (Integer)map.get("countPage");
			model.addAttribute("list", list);
			//model.addAttribute("countPage", countPage);
			model.addAttribute("currentPage", currentPage);
			System.out.println(currentPage+" : currentPage");
			logger.debug("{} : CountryController.java CountryList model", model);
			logger.debug("{} : CountryController.java CountryList currentPage", currentPage);
			view = "country/countryList";
		}
		return view;	
	}
	//나라입력화면 불러오기
	@RequestMapping(value="/country/insertCountry",method = RequestMethod.GET)
	public String CountryInsert() {
		logger.debug("CountryController.java CountryInsert ");
		return "country/insertCountry";	
	}
	//나라추가
	@RequestMapping(value="/country/insertCountry",method = RequestMethod.POST)
	public String CountryInsert(Country country) {
		//System.out.println(country+" :CountryController.java CountryInsertAction country");		
		logger.debug("{} : CountryController.java CountryInsert country", country);
		countryService.insertCountry(country);		
		return "redirect:/country/countryList";		
	}
	//나라삭제
	@RequestMapping(value="/country/deleteCountry",method=RequestMethod.GET)
	public String CountryDelete(@RequestParam(value="countryId",required=true)int countryId){
		countryService.deleteCountry(countryId);
		logger.debug("{} : CountryController.java CountryDelete countryId", countryId);
		return "redirect:/country/countryList";		
	}
	//나라수정을위한 아이디 받기
	@RequestMapping(value="/country/updateCountry",method=RequestMethod.GET)
	public String CountryUpdate(Model model,@RequestParam(value="countryId",required=true)int countryId) {
		Country country = countryService.selectCountryName(countryId);
		model.addAttribute("country", country);	
		logger.debug("{} : country.getMemberId() CountryUpdate CountryController.java GET", country.getCountryId());
		logger.debug("{} : country.getCountryName() CountryUpdate CountryController.java GET", country.getCountryName());
		return "country/updateCountry";		
	}
	//나라수정
	@RequestMapping(value="/country/updateCountry",method = RequestMethod.POST)
	public String CountryUpdate(Country country) {
		logger.debug("{} : country.getMemberId() CountryUpdate CountryController.java POST", country.getCountryId());
		logger.debug("{} : country.getCountryName() CountryUpdate CountryController.java POST", country.getCountryName());
		countryService.updateCountry(country);
		return "redirect:/country/countryList";
	}
}
