package ksmart.project.test26;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	// System.out.println 대체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		String s = "test";
		logger.debug("{}", s);
		/*
		 * 1. logger.debug(member)
		 * 2. dao(member)
		 * 3. mapper
		 * 4. null -> redirect /login
		 * 5. member -> session.setAttribute("loginMember", member)
		 * 6. redirect
		 * 
		 * login / logout
		 * 1명 : 회원가입...
		 * 나머지 : 1/n 인증단계를 적용해야 될 Controller
		 */
		return "home";
	}
}
