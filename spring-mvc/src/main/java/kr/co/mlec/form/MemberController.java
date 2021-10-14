package kr.co.mlec.form;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/form")
public class MemberController {
	@RequestMapping("/joinForm.do")
	public String joinForm() {
		return "form/joinForm";
	}

	
//	< request 영역에 등록하는 방법 >
//	1. HttpServletRequest request받아와서 직접 setAttribte
//	2. 모델앤뷰객체에 addObject로 등록
//	3. 모델앤뷰의 model 객체 받아와서 모델에 등록
	
	@RequestMapping("/join.do")
	public String join(MemberVO member, Model model) {	//ModelAndView의 모델객체 받아옴
		model.addAttribute("member", member);
		
		return "form/memberInfo";
	}
/*
	@RequestMapping("/join.do")
	public ModelAndView join(MemberVO member) {
		
		ModelAndView mav = new ModelAndView();	
		mav.setViewName("form/memberInfo");  	// forward하려는 주소값
		mav.addObject("member", member);  		// member 객체 등록
		
		return mav;
	}
*/
/*
	@RequestMapping("/join.do")
	public String join(@ModelAttribute("member") MemberVO member) {	//"member" 이름으로 request영역에 등록됨

		return "form/memberInfo";
	}
*/
/*	
	@RequestMapping("/join.do")
	public String join(@ModelAttribute MemberVO member) {	//@ModelAttribte 안써도 됨
		
		System.out.println(member);
		
		//request.setAttribute("memberVO", member); 가 자동으로 등록되어있음 --> 이러려면 input의 name과 vo의 setter변수명이 같아야함
		
		return "form/memberInfo";
	}
*/
	
/*
	@RequestMapping("/join.do")
	public String join(@RequestParam("id") String id, 
						@RequestParam("password") String password,
						@RequestParam("name") String name,
						HttpServletRequest request) {	
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);

		request.setAttribute("member", member);
		
		System.out.println(member);
		
		return "form/memberInfo";
	}
*/	
	
/*
	@RequestMapping("/join.do")
	public String join(HttpServletRequest request) {	//스프링이 알아서 파라미터 가져옴
		
		
		//post는 utf-8 인코딩 해야하지만 web.xml에 필터 설정해서 안해도됨
		String id = request.getParameter("id");
		String password= request.getParameter("password");
		String name = request.getParameter("name");
		
		MemberVO member = new MemberVO();
		member.setId(id);
		member.setPassword(password);
		member.setName(name);
		
		//System.out.println(member);
		request.setAttribute("member", member);
		
		return "form/memberInfo";
	}
*/
}
