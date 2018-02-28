package ksmart.project.test26.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class CountryService {
	@Autowired
	CountryDao countryDao;
	private static final Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	// 도시 조회(페이징)
	public Map<String, Object> selectCountryListAndCountByPage(int currentPage, int pagePerRow, String word) {
		logger.debug("{} : CountryService selectCountryListAndCountByPage currentPage", currentPage); 
		logger.debug("{} : CountryService selectCountryListAndCountByPage pagePerRow", pagePerRow);
		logger.debug("{} : CountryService selectCountryListAndCountByPage word", word);
		// 쿼리문의 시작 페이지
		int startPage = 0;
		if(currentPage > 1) {
			startPage = (currentPage-1)*pagePerRow;
		}
		// DAO에 시작 페이지와 행의 수 보내기
		Map<String, Object> map = new HashMap();
		map.put("startPage", startPage);
		map.put("pagePerRow", pagePerRow);
		map.put("word", word);
		List<Country> list = countryDao.selectCountryListByPage(map);
		logger.debug("{} : CountryService selectCountryListAndCountByPage list", list);
		// 총 행의 수를 보여줄 행의 수로 나눈 뒤 나머지가 0일 경우는 넘어가고 아닐 경우 +1 한다.
		int count = countryDao.selectCountryCountByPage(map);
		logger.debug("{} : CountryService selectCountryCountByPage count", count);
		int countPage = count/pagePerRow;
		if(count%pagePerRow != 0) {
			countPage++;
		}
		logger.debug("{} : CountryService selectCountryCountByPage countPage", countPage);
		// 자신의 카테고리 셋팅
		String category = "country";			
		// list와 페이지 수를 리턴하기
		Map<String, Object> returnMap = new HashMap();
		returnMap.put("list", list);
		returnMap.put("countPage", countPage);
		returnMap.put("word", word);
		returnMap.put("category", category);
		return returnMap;
	}
	
	// 도시 삭제 Action
	public void deleteCountry(int countryId) {
		logger.debug("{} : CountryService deleteCountry countryId", countryId);
		countryDao.deleteCountry(countryId);
	}
	
	// 도시 수정 Action
	public void updateCountry(Country country) {
		logger.debug("{} : CountryService updateCountry country", country);
		countryDao.updateCountry(country);
	}
	
	// 도시 수정 Form
	public Country updateCountry(int countryId) {
		logger.debug("{} : CountryService updateCountry countryId", countryId);
		return countryDao.updateCountry(countryId);
	}
	
	// 도시 추가 Action
	public void insertCountry(CountryCommand countryCommand) {
		logger.debug("{} : CountryService insertCountry countryCommand.getCountryName()", countryCommand.getCountryName());

		logger.debug("{} : CountryService insertCountry countryCommand.getFile().size()", countryCommand.getFile().size());
		//도시명 셋팅 후 Id값 받기
		Country country = new Country();
		country.setCountryName(countryCommand.getCountryName());		
		int countryId = countryDao.insertCountry(country);
		logger.debug("{} : CountryService insertCountry country", country);
		// 여러개의 파일 insert
		for(MultipartFile file : countryCommand.getFile()) {
			// 파일 하나당 한번의 DTO
			CountryFile countryFile = new CountryFile();
			//16진수 랜덤 숫자 이용
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString();		
			logger.debug("{} : CountryService insertCountry fileName", fileName);
			
			//오리지날이름에서 마지막
			String originalName = file.getOriginalFilename();
			int fileExtNumber = originalName.indexOf(".");
			String fileExt = originalName.substring(fileExtNumber + 1);
			logger.debug("{} : CountryService insertCountry fileExt", fileExt);
			logger.debug("{} : CountryService insertCountry file.getSize()", file.getSize());
			countryFile.setCountryId(countryId);
			countryFile.setFileName(fileName);
			countryFile.setFileExt(fileExt);
			countryFile.setFileSize(file.getSize());			
			//2. 파일을 저장
			countryDao.insertCountryFile(countryFile);
			File temp = new File("c\\upload\\"+fileName);
			try {
				file.transferTo(temp);
			} catch(IllegalStateException e){
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	// 도시 전체 조회
	public List<Country> selectCountryList() {
		logger.debug("CountryService selectCountryList ");
		return countryDao.selectCountryList();
	}
}
