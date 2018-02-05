package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sst;
	private String ms ="ksmart.project.test26.service.CompanyMapper.";//�ݺ��Ǵ� String�� ms������ ó��
	
	public List<Company>selectCompanyList(){
		return sst.selectList(ms+"selectCompanyList");
	}

}
