package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sst;
	
	public List<Company>selectCompanyList(){
		return sst.selectList("ksmart.project.test26.service.CompanyMapper.selectCompanyList");
	}

}
