package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyDao;

@Controller
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;
	
	@RequestMapping(value="/company/companyList")
	public String companyList(Model model) {
		List<Company> list =companyDao.selectCompanyList();
		model.addAttribute("list",list);
		return "companyList";
	}
}
