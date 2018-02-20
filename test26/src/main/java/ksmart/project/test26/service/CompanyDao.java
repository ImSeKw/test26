package ksmart.project.test26.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	private static final Logger logger = LoggerFactory.getLogger(CompanyDao.class);
	
	//회사파일 추가 Action
		public void insertComapnyFile(CompanyFile companyFile) {
			logger.debug("{} : CompanyFile insertCompanyFile CompanyDao", companyFile);
			sqlsessiontemplate.insert(NAMESPACE+"insertComapnyFile", companyFile);
		}
		
	
	// 경로설정 중복처리
	private final String NAMESPACE ="ksmart.project.test26.mapper.CompanyMapper.";
	
	//전체회사 수(페이징)
	public int selectCompanyCountByPage(Map map) {
		logger.debug("selectCompanyCountByPage CompanyDao.java");
		logger.debug("{} : word selectCompanyListByPage ComapanyDao", map.get("word"));
		return sqlsessiontemplate.selectOne(NAMESPACE + "selectCompanyCountByPage", map);
		
	}
	
	//회사조회처리(페이징처리)&조회
	public List<Company> selectCompanyListByPage(Map map){
		logger.debug("{} : <startPage selectCompanyListByPage ComapanyDao", map.get("startPage"));
		logger.debug("{} : <rowPerPage selectCompanyListByPage ComapanyDao", map.get("rowPerPage"));
		logger.debug("{} : word selectCompanyListByPage ComapanyDao", map.get("word"));
		return sqlsessiontemplate.selectList(NAMESPACE + "selectCompanyListByPage", map);
	}
	
	// 회사 전체 조회
	public List<Company>selectCompanyList(){
		return sqlsessiontemplate.selectList(NAMESPACE + "selectCompanyList");
	}
	
	// 회사 추가 Action
		@Insert("INSERT INTO company (company_name) VALUES (#{companyName})")
		@Options(useGeneratedKeys=true,keyProperty="companyId")
		public int insertCompany(Company company) {
			logger.debug("{} :insertCompany CompanyDao.java", company);
			sqlsessiontemplate.insert(NAMESPACE + "insertCompany",company);
			int companyId = company.getCompanyId();
			return  companyId;
		}
	
	// 회사 수정  Form
	public Company selectCompanyId(int companyId) {
		logger.debug("{} :selectCompany CompanyDao.java", companyId);
		return sqlsessiontemplate.selectOne(NAMESPACE + "selectCompanyId",  companyId);
	}
	
	// 회사 수정 Action
	public int updateCompany(Company company) {
		logger.debug("{} :updateCompany CompanyDao.java", company.getCompanyName());
		return sqlsessiontemplate.update(NAMESPACE + "updateCompany",company);
	}
	
	// 회사 삭제 Action
	public int deleteCompany(Company company) {
		logger.debug("{} :updateCompany CompanyDao.java", company.getCompanyId());
		return sqlsessiontemplate.delete(NAMESPACE + "deleteCompany", company);
	}
}
