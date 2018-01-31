package ksmart.project.test26;

import ksmart.project.test26.service.Country;
import ksmart.project.test26.service.CountryDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CountryController {
	@Autowired
	private CountryDao CountryDao;
	
	@RequestMapping(value="/country/countryList")		
	public String CountryList(Model model) {
		
		//System.out.println("01-01 CountryController.java CountryList 메서드 호출");	
		
		List<Country> list = CountryDao.selectCountryList(); 		
		model.addAttribute("list", list);
		
		return "countryList";		
	}
}
