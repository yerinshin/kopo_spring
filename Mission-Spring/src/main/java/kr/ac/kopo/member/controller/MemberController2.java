package kr.ac.kopo.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

//@Controller
public class MemberController2 {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/login")
	public String loginForm() {
		
		return "login/login";
	}
	
	@PostMapping("/login")
	public String login(MemberVO member, Model model, HttpSession session) {
		
		MemberVO userVO = service.login(member);
	
		if(userVO == null) {
		// 로그인 실패
			String msg = "아이디 또는 패스워드가 잘못되었습니다";
			model.addAttribute("msg", msg);
			
			return "login/login";
		}
		
		//로그인 성공
		session.setAttribute("userVO", userVO);
		
		
		
		String dest = (String)session.getAttribute("dest");
		if(dest != null ) {
			session.removeAttribute("dest");
			return "redirect:/"+ dest;
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}

}



