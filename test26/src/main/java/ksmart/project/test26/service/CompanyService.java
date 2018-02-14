package ksmart.project.test26.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CompanyService {
	@Autowired
	CompanyDao companyDao;
	private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);
	//회사 페이징
	public Map<String, Object> selectCompanyListAndCountByPage(int currentPage, int pagePerRow, String word){
		logger.debug("{} : currentPage selectCompanyListAndCountByPage CompanySevice", currentPage);
		logger.debug("{} : pagePerRow selectCompanyListAndCountByPage CompanySevice", pagePerRow);
		logger.debug("{} : word selectCompanyListAndCountByPage CompanySevice", word);
		// 쿼리문에 들어갈 시작 숫자
		int startRow=0;
		if(currentPage >1) {
			startRow=(currentPage-1)*pagePerRow;
		}
		// 맵에 시작 숫자, 보여줄 숫자, 검색어 셋팅 및 매개변수로 호출
		Map<String, Object> map = new HashMap();
		map.put("word", word);
		map.put("startRow", startRow);
		map.put("rowPerPage", pagePerRow);
		List<Company> list = companyDao.selectCompanyListByPage(map);
		//전체 목록갯수 Dao 가져오기
		int count = companyDao.selectCompanyCountByPage(map);
		//전체 목록 갯수를 한페이지에 보여줄 목록의 갯수로 나눈다
		int countPage =count/pagePerRow;
		//나머지가 0일 경우는 넘어가고 아닐경우는 +1을 한다
		if(count%pagePerRow !=0) {
			countPage++;
		}
		logger.debug("{} : countPage selectCompanyListAndCountByPage CompanySevice", countPage);
		//자신의 카테고리 셋팅
		String category = "company";
		//리스트와 페이지 수를 리턴
		Map<String,Object> returnMap=new HashMap();
		returnMap.put("word",word);
		returnMap.put("list",list);
		returnMap.put("countPage",countPage);
		returnMap.put("category", category);
		return returnMap;
		
	}
	
	// 회사 전체 조회
	public List<Company>selectCompanyList(){
		return companyDao.selectCompanyList();
	}
	
	// 회사 추가 Action
	public int insertCompany(Company company) {
		logger.debug("{} :insertCompany CompanyService.java", company.getCompanyName());
		return companyDao.insertCompany(company);
	}
	
	// 회사 수정  Form
	public Company selectCompanyId(int companyId) {
		logger.debug("{} :selectCompany CompanyService.java", companyId);
		return companyDao.selectCompanyId(companyId);
	}
	
	// 회사 수정 Action
	public int updateCompany(Company company) {
		logger.debug("{} :updateCompany CompanyService.java", company.getCompanyName());
		return companyDao.updateCompany(company);
	}
	
	// 회사 삭제 Action
	public int deleteCompany(Company company) {
		logger.debug("{} :updateCompany CompanyService.java", company.getCompanyId());
		return companyDao.deleteCompany(company);
	}
}
