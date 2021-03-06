package ksmart.project.test26;

import java.util.List;
import java.util.Map;

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
import ksmart.project.test26.service.IdolCommand;
import ksmart.project.test26.service.IdolService;

@Controller
public class IdolController {
	@Autowired
	private IdolService idolService;
	private static final Logger logger = LoggerFactory.getLogger(IdolController.class);
	
	// 아이돌page 조회
	@RequestMapping(value = "/idol/idolList", method = RequestMethod.GET)
	public String selectIdolListAndCountByPage(Model model, HttpSession httpSession
										, @RequestParam(value = "currentPage", required = false, defaultValue = "1") int currentPage
										, @RequestParam(value = "pagePerRow", required = false, defaultValue = "10") int pagePerRow 
										, @RequestParam(value = "word", required = false) String word) {
		logger.debug("{} : <currentPage selectIdolListAndCountByPage IdolController", currentPage);
		logger.debug("{} : <pagePerRow selectIdolListAndCountByPage IdolController", pagePerRow);
		logger.debug("{} : <word selectIdolListAndCountByPage IdolController", word);
		String view = null;
		// 로그인 접근 처리
		if(httpSession.getAttribute("loginMember") == null) {
			view = "redirect:/";
		} else if(httpSession.getAttribute("loginMember") != null) {
			Map<String, Object> map = idolService.selectIdolListAndCountByPage(currentPage, pagePerRow, word);
			List<Idol> list = (List<Idol>)map.get("list");
			int countPage = (Integer)map.get("countPage");
			word = (String)map.get("word");
			// 페이징카테고리 설정
			String category = (String)map.get("category");
			logger.debug("{} : >list selectIdolListAndCountByPage IdolController", list);
			logger.debug("{} : >countPage selectIdolListAndCountByPage IdolController", countPage);
			logger.debug("{} : >word selectIdolListAndCountByPage IdolController", word);
			model.addAttribute("list", list);
			model.addAttribute("countPage", countPage);
			model.addAttribute("currentPage", currentPage);
			model.addAttribute("word", word);
			model.addAttribute("category", category);
			view = "idol/idolList";
		}
		logger.debug("{} : >view idolList IdolController", view);
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
	
	// 아이돌 추가 및 File 추가 Action
	@RequestMapping(value = "/idol/insertIdol", method = RequestMethod.POST)
	public String insertIdol(IdolCommand idolCommand) {
		idolService.insertIdol(idolCommand);
		return "redirect:/idol/idolList";
	}

	// 추가 Form
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
