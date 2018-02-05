package ksmart.project.test26;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

import java.util.List;

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
	
	@RequestMapping(value="/country/countryList")		
	public String CountryList(Model model) {		
		System.out.println("01-01 CountryController.java CountryList 메서드 호출");			
		List<Country> list = countryDao.selectCountryList(); 		
		model.addAttribute("list", list);		
		return "country/countryList";		
	}
	@RequestMapping(value="/country/countryInsertForm")
	public String CountryInsert() {
		//System.out.println("01_01 CountryController.java CountryInsert메서드 실행 입력 폼");
		return "country/countryInsertForm";	
	}	
	@RequestMapping(value="/country/countryInsertAction",method = RequestMethod.POST)
	public String CountryInsertAction(Country country) {
		//System.out.println(country+" :CountryController.java CountryInsertAction의 country값");		
		countryDao.insertCountry(country);		
		return "redirect:/country/countryList";		
	}
	@RequestMapping(value="/country/countryDelete",method=RequestMethod.GET)
	public String CountryDeleteAction(@RequestParam(value="countryId",required=true)int countryId){
		countryDao.deleteCountry(countryId);
		return "redirect:/country/countryList";		
	}
	//수정 폼
	@RequestMapping(value="/country/countryUpdateForm",method=RequestMethod.GET)
	public String CountryUpdateForm(Model model,@RequestParam(value="countryId",required=true)int countryId) {
		Country country = countryDao.selectCountryName(countryId);
		model.addAttribute("country", country);	
		return "country/countryUpdateForm";		
	}
}
