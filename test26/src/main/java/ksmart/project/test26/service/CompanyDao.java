package ksmart.project.test26.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CompanyDao {
	@Autowired
	private SqlSessionTemplate sqlsessiontemplate;
	private String ms ="ksmart.project.test26.service.CompanyMapper.";//�ݺ��Ǵ� String�� ms������ ó��
	//ȸ��list���޴� Dao 
	public List<Company>selectCompanyList(){
		return sqlsessiontemplate.selectList(ms+"selectCompanyList");
	}
	//ȸ���߰� Dao
	public int insertCompany(Company company) {
		return sqlsessiontemplate.insert(ms+"insertCompany",company);
	}
	//ȸ����������� ���̵� �������� DAo
	public Company selectCompanyId(int companyId) {
		return sqlsessiontemplate.selectOne(ms+"selectCompanyId",  companyId);
	}
	//ȸ�����
	public int updateCompany(Company company) {
		return sqlsessiontemplate.update(ms+"updateCompany",company);
		
	}
	//ȸ�����
	public int deleteCompany(Company company) {
		return sqlsessiontemplate.delete(ms+"deleteCompany", company);
		
	}

}
