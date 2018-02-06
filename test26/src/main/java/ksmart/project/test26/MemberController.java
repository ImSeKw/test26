package ksmart.project.test26;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		logger.debug("{} : reMember selectMember MemberController.java", reMember);
		if(reMember == null) {
			return "redirect:/member/loginMember";
		} else if(reMember.getMemberId().equals(member.getMemberId())) {
			if(reMember.getMemberPw().equals(member.getMemberPw())) {
				httpSession.setAttribute("loginMember", reMember);
				return "redirect:/";
			} else {
				return "redirect:/member/loginMember";
			}
		} else {
			return "redirect:/member/loginMember";
		}
	}
	
	// 로그인 화면
	@RequestMapping(value="/member/loginMember", method=RequestMethod.GET)
	public String loginMember() {
		return "member/loginMember";
	}
}
