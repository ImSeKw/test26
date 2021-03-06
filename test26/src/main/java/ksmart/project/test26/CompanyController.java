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
import ksmart.project.test26.service.CompanyAndCompanyFile;
import ksmart.project.test26.service.CompanyCommand;
import ksmart.project.test26.service.CompanyService;

@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);
	
	//회사 및 파일 수정 Form
	@RequestMapping(value ="/company/updateCompany",method=RequestMethod.GET)
	public String selectCompanyJoinFile(HttpSession httpSession,Model model, @RequestParam(value="companyId") int companyId) {
		logger.debug("{} : httpSession selectCompanyJoinFile CompanyController",httpSession);
		logger.debug("{} : model selectCompanyJoinFile CompanyController",model);
		logger.debug("{} : companyId selectCompanyJoinFile CompanyController",companyId);
		String view =null;
		if(httpSession.getAttribute("loginMember") ==null) {
			view ="redirect:/";
		}else {
			//아이디,이름 ,리스트 받기
			CompanyAndCompanyFile companyAndCompanyFile=companyService.selectCompanyJoinFile(companyId);
			logger.debug("{} : companyAndCompanyFile selectCompanyJoinFile CompanyController",companyAndCompanyFile);
			logger.debug("{} : getCompanyName() companyAndCompanyFile selectCompanyJoinFile CompanyController",companyAndCompanyFile.getCompanyName());
			model.addAttribute("companyAndCompanyFile", companyAndCompanyFile);
			//경로 셋팅
			String rootPath = httpSession.getServletContext().getRealPath("/");
			String attachPath = "resources/upload/company";
			String path = rootPath + attachPath;
			logger.debug("{} : ^path selectCompanyJoinFile CompanyController", path);
			view="company/updateCompany";
		}
		return view;
	}
	//회사 조회(페이징)
	@RequestMapping(value="/company/companyList",method=RequestMethod.GET)
	public String selectCompanyListAndCountByPage(Model model,@RequestParam(value="currentPage",required =false, defaultValue="1") int currentPage
													,@RequestParam(value ="pagePerRow",required =false, defaultValue="5") int pagePerRow
													,@RequestParam(value="word",required =false) String word) {
		logger.debug("{} : currentPage selectCompanyListAndCountByPage CompanyComtroller" , currentPage);
		logger.debug("{} : pagePerRow selectCompanyListAndCountByPage CompanyController" , pagePerRow);
		logger.debug("{} : word selectCompanyListAndCountByPage CompanyController" , word);
		Map<String,Object> map =companyService.selectCompanyListAndCountByPage(currentPage, pagePerRow, word);
		List<Company> list =(List<Company>)map.get("list");
		int countPage =(Integer) map.get("countPage");
		String word1 =(String) map.get("word");
		String category = (String)map.get("category");
		model.addAttribute("list",list);
		model.addAttribute("countPage", countPage);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("word", word1);
		model.addAttribute("category", category);
		return "company/companyList";
	}
	// 회사 전체 조회
	@RequestMapping(value="/company/companyListAll", method = RequestMethod.GET)
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
	@RequestMapping(value="/company/insertCompany", method = RequestMethod.GET)
	public String addcompany(HttpSession httpSession) {
		String rootPath = httpSession.getServletContext().getRealPath("/");
		String attachPath = "resources/upload/company";
		String path = rootPath + attachPath;
		logger.debug("{} : 1insertcompany CompanyController.java",  path);
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
	
	// 회사 추가 및 회사파일 추가  Action
	@RequestMapping(value="/company/insertCompany", method = RequestMethod.POST)
	public String addcompany(CompanyCommand companyCommand,HttpSession httpSession) {
		logger.debug("insertCompany Action CompanyController.java");
		String rootPath = httpSession.getServletContext().getRealPath("/");
		String attachPath = "resources/upload/company";
		String path = rootPath + attachPath;
		logger.debug("{} : insertcompany CompanyController.java", companyCommand);
		logger.debug("{} : 2insertcompany CompanyController.java",  path);
		companyService.insertCompany(companyCommand,path);
		return "redirect:/company/companyList";
	}
	
	// 회사 수정 Form
	@RequestMapping(value="/company/updateCompanyDiscard",method = RequestMethod.GET)
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
	@RequestMapping(value="/company/updateCompany",method = RequestMethod.POST)
	public String updateCompany(Company company) {
		logger.debug("{} : updateDompany CompanyController", company.getCompanyName());
		companyService.updateCompany(company);
		return "redirect:/company/companyList";
	}
	
	// 회사 삭제 Action
	@RequestMapping(value="/company/deleteCompany",method = RequestMethod.GET)
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
