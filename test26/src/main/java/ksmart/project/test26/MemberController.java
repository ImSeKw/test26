package ksmart.project.test26;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ksmart.project.test26.service.Member;
import ksmart.project.test26.service.MemberDao;

@Controller
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	// 로그인 Form
	@RequestMapping(value="/member/loginMember", method = RequestMethod.GET)
	public String loginMember() {
		return "member/loginMember";
	}
	
	// 로그인 Action
	@RequestMapping(value="/member/loginMember", method = RequestMethod.POST)
	public String loginMember(HttpSession httpSession, Member member) {
		logger.debug("{} : member.getMemberId() selectMember MemberController.java POST", member.getMemberId());
		logger.debug("{} : member.getMemberPw() selectMember MemberController.java POST", member.getMemberPw());
		Member reMember = memberDao.loginMember(member);
		String view = null;
		// 아이디, 비밀번호 일치 여부에 따라 페이지 변경
		if(reMember == null) {
			logger.debug("{} : null selectMember MemberController.java", reMember);
			view = "redirect:/member/loginMember";
		} else if(reMember.getMemberId().equals(member.getMemberId())) {
			if(reMember.getMemberPw().equals(member.getMemberPw())) {
				logger.debug("{} : pw selectMember MemberController.java", reMember);
				httpSession.setAttribute("loginMember", reMember);
				view = "redirect:/";
			} else {
				logger.debug("{} : id selectMember MemberController.java", reMember);
				view = "redirect:/member/loginMember";
			}
		}
		return view;
	}
	
	// 로그아웃
	@RequestMapping(value="/member/logoutMember", method = RequestMethod.GET)
	public String logoutMember(HttpSession httpSession) {
		httpSession.invalidate();
		return "redirect:/";
	}
	
	// 회원 가입 Form
	@RequestMapping(value="/member/insertMember", method = RequestMethod.GET)
	public String insertMember() {
		return "member/insertMember";
	}
	
	// 회원 가입 Action
	@RequestMapping(value="/member/insertMember", method = RequestMethod.POST)
	public String insertMember(Member member) {
		memberDao.insertMember(member);
		return "redirect:/member/loginMember";
	}
	
	// 회원 수정 Form
	@RequestMapping(value="/member/selectMemberInfo", method = RequestMethod.GET)
	public String selectMemberInfo(HttpSession httpSession, Model model) {
		Member member = (Member)httpSession.getAttribute("loginMember");
		Member reMember = memberDao.selectMemberInfo(member.getMemberNo());
		model.addAttribute("member", reMember);
		return "member/selectMemberInfo";
	}
	
	// 회원 수정 Action
	@RequestMapping(value="/member/updateMember", method = RequestMethod.POST)
	public String updateMember(HttpSession httpSession, Member member) {
		memberDao.updateMember(member);
		httpSession.setAttribute("loginMember", member);
		return "redirect:/";
	}
	
	// 회원 삭제
	@RequestMapping(value="/member/deleteMember", method = RequestMethod.GET)
	public String deleteMember(HttpSession httpSession, Member member) {
		int result = memberDao.deleteMember(member);
		logger.debug("{} : result deleteMember MemberController.java", result);
		httpSession.invalidate();
		return "redirect:/";
	}
}
