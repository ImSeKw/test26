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
	
	// 로그인 처리
	@RequestMapping(value="/member/loginMember", method=RequestMethod.POST)
	public String loginMember(HttpSession httpSession, Member member) {
		logger.debug("{} : member.getMemberId() selectMember MemberController.java POST", member.getMemberId());
		logger.debug("{} : member.getMemberPw() selectMember MemberController.java POST", member.getMemberPw());
		Member reMember = memberDao.loginMember(member);
		String view = null;
		if(reMember == null) {
			logger.debug("{} : null selectMember MemberController.java", reMember);
			return "redirect:/member/loginMember";
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
	
	// 로그인 화면
	@RequestMapping(value="/member/loginMember", method=RequestMethod.GET)
	public String loginMember() {
		return "member/loginMember";
	}
	
	//로그아웃
	@RequestMapping(value="/member/logoutMember",method=RequestMethod.GET)
	public String logoutMember(HttpSession httpSession) {
		httpSession.invalidate();
		return null;
	}
	
	//회원가입화면
	@RequestMapping(value="/member/insertMember",method=RequestMethod.GET)
	public String insertMember() {
		return "member/insertMember";
	}
	
	//회원가입처리
	@RequestMapping(value="/member/insertMember",method=RequestMethod.POST)
	public String insertMember(Member member) {
		memberDao.insertMember(member);
		return "redirect:/member/loginMember";
	}
	
	//개인회원정보검색처리
	@RequestMapping(value="/member/selectMemberInfo",method=RequestMethod.GET)
	public String selectMemberInfo(HttpSession httpSession, Model model) {
		Member member = (Member)httpSession.getAttribute("loginMember");
		Member reMember = memberDao.selectMemberInfo(member.getMemberNo());
		model.addAttribute("member", reMember);
		return "member/selectMemberInfo";
	}
	
	//개인회원정보수정처리
	@RequestMapping(value="/member/updateMember",method=RequestMethod.POST)
	public String updateMember(HttpSession httpSession,Member member) {
		memberDao.updateMember(member);
		httpSession.setAttribute("loginMember", member);
		return "redirect:/";
	}	
	
	//개인회원 삭제
	@RequestMapping(value="/member/deleteMember",method=RequestMethod.GET)
	public String deleteMember(HttpSession httpSession,Member member) {
		memberDao.deleteMember(member);
		httpSession.invalidate();
		return "redirect:/";
	}
}
