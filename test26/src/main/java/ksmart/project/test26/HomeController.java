package ksmart.project.test26;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ksmart.project.test26.service.Category;
import ksmart.project.test26.service.CategoryService;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	// System.out.println 대체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<Category> list = categoryService.selectCategoryList();
		for(Category c : list) {
			logger.debug("{} : CategoryName indexCall IndexController.java", c.getCategoryName());
		}
		model.addAttribute("list", list);
		return "home";
	}
}
