package ksmart.project.test26.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public List<Category> selectCategoryList() {
		logger.debug("<selectCategoryList categoryDao");
		List<Category> list = categoryDao.selectCategoryList();
		
		return 
	}
}
