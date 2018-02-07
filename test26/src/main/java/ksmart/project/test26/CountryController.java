package ksmart.project.test26;


import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

import java.util.List;

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
	private CountryDao countryDao;
	private static final Logger logger = LoggerFactory.getLogger(CountryController.class);

	//나라리스트
	@RequestMapping(value="/country/countryList")		
	public String CountryList(Model model) {		
		System.out.println("01-01 CountryController.java CountryList 硫붿꽌�뱶 �샇異�");			
		List<Country> list = countryDao.selectCountryList(); 		
		model.addAttribute("list", list);		
		return "country/countryList";		
	}
	//나라추가화면 불러오기
	@RequestMapping(value="/country/insertCountry",method = RequestMethod.GET)
	public String CountryInsert() {
		//System.out.println("01_01 CountryController.java CountryInsert硫붿꽌�뱶 �떎�뻾 �엯�젰 �뤌");
		return "country/insertCountry";	
	}
	//나라추가
	@RequestMapping(value="/country/insertCountry",method = RequestMethod.POST)
	public String CountryInsert(Country country) {
		//System.out.println(country+" :CountryController.java CountryInsertAction�쓽 country媛�");		
		countryDao.insertCountry(country);		
		return "redirect:/country/countryList";		
	}
	//나라삭제
	@RequestMapping(value="/country/deleteCountry",method=RequestMethod.GET)
	public String CountryDelete(@RequestParam(value="countryId",required=true)int countryId){
		countryDao.deleteCountry(countryId);
		return "redirect:/country/countryList";		
	}
	//나라수정을위한 아이디 받기
	@RequestMapping(value="/country/updateCountry",method=RequestMethod.GET)
	public String CountryUpdate(Model model,@RequestParam(value="countryId",required=true)int countryId) {
		Country country = countryDao.selectCountryName(countryId);
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
		countryDao.updateCountry(country);

		return "redirect:/country/countryList";
	}
}
