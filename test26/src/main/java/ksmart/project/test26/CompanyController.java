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

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyDao;

@Controller
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	// 회사전체조회
	@RequestMapping(value="/company/companyList", method = RequestMethod.GET)
	public String companyList(Model model) {
		List<Company> list =companyDao.selectCompanyList();
		model.addAttribute("list",list);
		return "company/companyList";
	}
	
	// 회사 입력 Form
	@RequestMapping(value="/company/insertcompany", method = RequestMethod.GET)
	public String addcompany(HttpSession httpSession) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/company/companyList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "company/insertCompany";
		}
		logger.debug("{} : view addcompany CompanyController.java", view);
		return view;
	}
	// 회사 입력 Action
	@RequestMapping(value="/company/insertcompany",method = RequestMethod.POST)
	public String addcompany(Company company) {
		System.out.println("companyadd post");
		companyDao.insertCompany(company);
		return "redirect:/company/companyList";
		
	}
	// 회사 수정 Form
	@RequestMapping(value="/company/updateCompany",method = RequestMethod.GET)
	public String companyId(HttpSession httpSession, Model model, @RequestParam(value="companyId",required=true) int companyId) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/company/companyList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Company company=companyDao.selectCompanyId(companyId);
			model.addAttribute("company", company);
			view = "company/updateCompany";
		}
		logger.debug("{} : view companyId CompanyController.java", view);
		return view;
	}
	// 회사 수정 Action
	@RequestMapping(value="/company/updateCompany",method = RequestMethod.POST)
	public String updateCompany(Company company) {
		companyDao.updateCompany(company);
		return "redirect:/company/companyList";
	}
	// 회사 삭제
	@RequestMapping(value="/company/deleteCompany",method = RequestMethod.GET)
	public String companydelete(HttpSession httpSession, Company company) {
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") != null) {
			logger.debug("Yes companydelete CompanyController.java");
			companyDao.deleteCompany(company);
		} else {
			logger.debug("No companydelete CompanyController.java");
		}
		return "redirect:/company/companyList";
	}
}
