package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Company;
import ksmart.project.test26.service.CompanyDao;

@Controller
public class CompanyController {
	@Autowired
	private CompanyDao companyDao;
	

	//ȸ�� ����Ʈ 
	@RequestMapping(value="/company/companyList", method = RequestMethod.GET)
	public String companyList(Model model) {
		List<Company> list =companyDao.selectCompanyList();
		model.addAttribute("list",list);
		return "company/companyList";
	}
	//ȸ���߰�ȭ�� �ҷ�����
	@RequestMapping(value="/company/companyadd", method = RequestMethod.GET)
	public String companyadd() {
		return "company/companyInsert";
	}
	//ȸ���߰�
	@RequestMapping(value="/company/companyadd",method = RequestMethod.POST)
	public String companyadd(Company company) {
		System.out.println("companyadd post");
		companyDao.insertCompany(company);
		return "redirect:/company/companyList";//�ѹ�Ŀ���� ��������ؼ� �����̷�Ʈ�� �޴´�
		
	}
	

	}
