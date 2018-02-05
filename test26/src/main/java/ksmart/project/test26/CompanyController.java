package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyDao;

@Controller
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;
	

	//회사 리스트 
	@RequestMapping(value="/company/companyList", method = RequestMethod.GET)
	public String companyList(Model model) {
		List<Company> list =companyDao.selectCompanyList();
		model.addAttribute("list",list);
		return "company/companyList";
	}
	
	//회사추가화면 불러오기
	@RequestMapping(value="/company/insertcompany", method = RequestMethod.GET)
	public String addcompany() {
		return "company/insertCompany";
	}
	//회사추가
	@RequestMapping(value="/company/insertcompany",method = RequestMethod.POST)
	public String addcompany(Company company) {
		System.out.println("companyadd post");
		companyDao.insertCompany(company);
		return "redirect:/company/companyList";//한번커밋을 끊어줘야해서 리다이렉트로 받는다
		
	}
	//회사수정을위한 아이디받기
	@RequestMapping(value="/company/updateCompany",method = RequestMethod.GET)
	public String companyId(Model model,@RequestParam(value="companyId",required=true)int companyId) {
		Company company=companyDao.selectCompanyId(companyId);
		model.addAttribute("company", company);
		return "company/updateCompany";
	}
	//회사수정
	@RequestMapping(value="/company/updateCompany",method = RequestMethod.POST)
	public String updateCompany(Company company) {
		companyDao.updateCompany(company);
		return "redirect:/company/companyList";
	}
	//회사삭제
	@RequestMapping(value="/company/deleteCompany",method = RequestMethod.GET)
	public String companydelete(Company company) {
		companyDao.deleteCompany(company);
		return "redirect:/company/companyList";
	}
	

	}
