package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	private final String NAMESPACE ="ksmart.project.test26.service.CompanyMapper.";
	
	// 회사 전체 조회
	public List<Company>selectCompanyList(){
		return sqlsessiontemplate.selectList(NAMESPACE + "selectCompanyList");
	}
	
	// 회사 추사 Action
	public int insertCompany(Company company) {
		return sqlsessiontemplate.insert(NAMESPACE + "insertCompany",company);
	}
	
	// 회사 수정  Form
	public Company selectCompanyId(int companyId) {
		return sqlsessiontemplate.selectOne(NAMESPACE + "selectCompanyId",  companyId);
	}
	
	// 회사 수정 Form
	public int updateCompany(Company company) {
		return sqlsessiontemplate.update(NAMESPACE + "updateCompany",company);
	}
	
	// 회사 삭제 Action
	public int deleteCompany(Company company) {
		return sqlsessiontemplate.delete(NAMESPACE + "deleteCompany", company);
	}
}
