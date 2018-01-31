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
	
	@RequestMapping(value = "/city/cityList", method = RequestMethod.GET)
	public String cityList(Model model) {
		List<City> list = cityDao.selectCityList();
		model.addAttribute("list", list);
		return "city/cityList";
	}
}
