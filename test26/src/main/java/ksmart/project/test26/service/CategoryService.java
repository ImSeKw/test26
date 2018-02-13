package ksmart.project.test26.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryService {
	@Autowired
	CategoryDao categoryDao;
	private static final Logger logger = LoggerFactory.getLogger(CategoryService.class);
	
	public List<Category> selectCategoryList() {
		logger.debug("<selectCategoryList categoryDao");
		List<Category> list = categoryDao.selectCategoryList();
		List<Category> lowerList = new ArrayList();
		for(Category category : list) {
			logger.debug("{} : >categoryName selectCategoryList categoryDao", category.getCategoryName());
			logger.debug("{} : >categoryNo selectCategoryList categoryDao", category.getCategoryNo());
			Category lowerCategory = new Category();
			String categoryName = category.getCategoryName().toLowerCase();
			int categoryNo = category.getCategoryNo();
			lowerCategory.setCategoryName(categoryName);
			lowerCategory.setCategoryNo(categoryNo);
			lowerList.add(lowerCategory);
		}
		return lowerList;
	}
}
