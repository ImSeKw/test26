package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {
	@Autowired
	CompanyDao companyDao;
	
	// 회사 전체 조회
	public List<Company>selectCompanyList(){
		return companyDao.selectCompanyList();
	}
	
	// 회사 추가 Action
	public int insertCompany(Company company) {
		return companyDao.insertCompany(company);
	}
	
	// 회사 수정  Form
	public Company selectCompanyId(int companyId) {
		return companyDao.selectCompanyId(companyId);
	}
	
	// 회사 수정 Form
	public int updateCompany(Company company) {
		return companyDao.updateCompany(company);
	}
	
	// 회사 삭제 Action
	public int deleteCompany(Company company) {
		return companyDao.deleteCompany(company);
	}
}
