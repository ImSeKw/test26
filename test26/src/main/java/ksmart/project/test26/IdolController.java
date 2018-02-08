package ksmart.project.test26;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolService;

@Controller
public class IdolController {
	@Autowired
	private IdolService idolService;
	private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
	
	// 전체목록조회
	@RequestMapping(value="/idol/idolList", method = RequestMethod.GET)
	public String idolList(HttpSession httpSession, Model model) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			List<Idol> list = idolService.selectIdolList();
			model.addAttribute("list", list);
			view = "idol/idolList";
		}
		return view; 
	}
	
	// 수정 Action
	@RequestMapping(value = "/idol/updateIdol", method = RequestMethod.POST)
	public String updateIdol(Idol idol) {
		idolService.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	// 수정 Form
	@RequestMapping(value = "/idol/updateIdol", method = RequestMethod.GET)
	public String updateIdol(HttpSession httpSession, Model model, @RequestParam(value = "idolID") int idolID) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/idol/idolList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Idol idol = idolService.selectAndupdateIdol(idolID);
			model.addAttribute("idol", idol);
			view = "idol/updateIdol";
		}
		logger.debug("{} : view updateIdol IdolController.java", view);
		return view;
	}
	
	// 삭제 Action
	@RequestMapping(value = "/idol/deleteIdol", method = RequestMethod.GET)
	public String deleteIdol(HttpSession httpSession, Idol idol) {
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") != null) {
			logger.debug("Yes deleteIdol IdolController.java");
			idolService.deleteIdol(idol);
		} else {
			logger.debug("No deleteIdol IdolController.java");
		}
		return "redirect:/idol/idolList";
	}
	
	// 입력 Action
	@RequestMapping(value = "/idol/insertIdol", method = RequestMethod.POST)
	public String insertIdol(Idol idol) {
		idolService.insertIdol(idol);
		return "redirect:/idol/idolList";
	}

	// 입력 Form
	@RequestMapping(value = "/idol/insertIdol", method = RequestMethod.GET)
	public String insertIdol(HttpSession httpSession) {
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/idol/idolList";
		} else if(httpSession.getAttribute("loginMember") != null) {
			view = "idol/insertIdol";
		}
		logger.debug("{} : view insertIdol IdolController.java", view);
		return view;
	}
}
