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

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	//회사 조회(페이징)
	@RequestMapping(value="/Company/CompanyList",method=RequestMethod.GET)
	public String selectCompanyListAndCountByPage(Model model,@RequestParam(value="currentPage",required =false, defaultValue="1") int currentPage
													,@RequestParam(value ="pagePerRow",required =false, defaultValue="10") int pagePerRow
													,@RequestParam(value="word",required =false) String word) {
		logger.debug("{} : currentPage selectCompanyListAndCountByPage CompanyComtroller" , currentPage);
		logger.debug("{} : pagePerRow selectCompanyListAndCountByPage CompanyController" , pagePerRow);
		logger.debug("{} : word selectCompanyListAndCountByPage CompanyController" , word);
		Map<String,Object> map =companyService.selectCompanyListAndCountByPage(currentPage, pagePerRow, word);
		List<Company> list =(List<Company>)map.get("list");
		int countPage =(Integer) map.get("countPage");
		String word1 =(String) map.get("word");
		model.addAttribute("list",list);
		model.addAttribute("countPage", countPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("word", word1);
		return "company/companyList";
	}
	// 회사 전체 조회
	@RequestMapping(value="/Company/CompanyListAll", method = RequestMethod.GET)
	public String companyList(HttpSession httpSession, Model model) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			List<Company> list = companyService.selectCompanyList();
			model.addAttribute("list",list);
			view = "company/companyList";
		}
		return view;
	}
	
	// 회사 입력 Form
	@RequestMapping(value="/Company/insertCompany", method = RequestMethod.GET)
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
	@RequestMapping(value="/Company/insertCompany",method = RequestMethod.POST)
	public String addcompany(Company company) {
		logger.debug("{} : insertcompany CompanyController.java", company.getCompanyName());
		companyService.insertCompany(company);
		return "redirect:/company/companyList";
	}
	
	// 회사 수정 Form
	@RequestMapping(value="/Company/updateCompany",method = RequestMethod.GET)
	public String companyId(HttpSession httpSession, Model model, @RequestParam(value="companyId",required=true) int companyId) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/company/companyList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			logger.debug("{} : selectcompanyId CompanyController.java", companyId);
			Company company=companyService.selectCompanyId(companyId);
			model.addAttribute("company", company);
			view = "company/updateCompany";
		}
		logger.debug("{} : view companyId CompanyController.java", view);
		return view;
	}
	
	// 회사 수정 Action
	@RequestMapping(value="/Company/updateCompany",method = RequestMethod.POST)
	public String updateCompany(Company company) {
		logger.debug("{} : updateDompany CompanyController", company.getCompanyName());
		companyService.updateCompany(company);
		return "redirect:/company/companyList";
	}
	
	// 회사 삭제 Action
	@RequestMapping(value="/Company/deleteCompany",method = RequestMethod.GET)
	public String companydelete(HttpSession httpSession, Company company) {
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") != null) {
			logger.debug("Yes companydelete CompanyController.java");
			companyService.deleteCompany(company);
		} else {
			logger.debug("No companydelete CompanyController.java");
		}
		return "redirect:/company/companyList";
	}
}
