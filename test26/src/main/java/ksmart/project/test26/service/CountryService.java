package ksmart.project.test26.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CountryService {
	@Autowired
	CountryDao countryDao;
	
	//나라 전체 조회
	public List<Country>selectCountryList(){		
		return countryDao.selectCountryList();		
	}
	//나라 입력 Action
	public void insertCountry(Country country) {
		countryDao.insertCountry(country);
	}
	//나라 수정 Form
	public Country selectCountryName(int countryId) {
		return countryDao.selectCountryName(countryId);
	}
	//나라 수정 Action
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
	//나라 삭제 Action
	public void deleteCountry(int countryId) {
		countryDao.deleteCountry(countryId);
	}

}
