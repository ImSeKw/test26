package ksmart.project.test26;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ksmart.project.test26.service.Idol;
import ksmart.project.test26.service.IdolDao;

@Controller
public class IdolController {
	@Autowired
	private IdolDao idolDao;
	
	// 전체목록조회
	@RequestMapping(value="/idol/idolList", method = RequestMethod.GET)
	public String idolList(Model model) {
		List<Idol> list = idolDao.selectIdolList();
		model.addAttribute("list", list);
		return "idol/idolList"; 
	}
	
	// 수정 Action
	@RequestMapping(value = "/idol/updateIdol", method = RequestMethod.POST)
	public String updateIdol(Idol idol) {
		idolDao.updateIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	// 수정 Form
	@RequestMapping(value = "/idol/updateIdol", method = RequestMethod.GET)
	public String updateIdol(Model model, @RequestParam(value = "idolID") int idolID) {
		Idol idol = idolDao.selectAndupdateIdol(idolID);
		model.addAttribute("idol", idol);
		return "idol/updateIdol";
	}
	
	// 삭제 Action
	@RequestMapping(value = "/idol/deleteIdol", method = RequestMethod.GET)
	public String deleteIdol(Idol idol) {
		idolDao.deleteIdol(idol);
		return "redirect:/idol/idolList";
	}
	
	// 입력 Action
	@RequestMapping(value = "/idol/insertIdol", method = RequestMethod.POST)
	public String insertIdol(Idol idol) {
		idolDao.insertIdol(idol);
		return "redirect:/idol/idolList";
	}
		
	// 입력 Form
	@RequestMapping(value = "/idol/insertIdol", method = RequestMethod.GET)
	public String insertIdol() {
		return "idol/insertIdol";
	}
}
