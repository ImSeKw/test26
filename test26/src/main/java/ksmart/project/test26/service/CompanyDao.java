package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	private String ms ="ksmart.project.test26.service.CompanyMapper.";//반복되는 String을 ms변수로 처리
	//회사list를받는 Dao 
	public List<Company>selectCompanyList(){
		return sqlsessiontemplate.selectList(ms+"selectCompanyList");
	}
	//회사추가 Dao
	public int insertCompany(Company company) {
		return sqlsessiontemplate.insert(ms+"insertCompany",company);
	}

}
