package kr.co.mlec.method;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/method/method.do")	//클래스에도 붙을 수 있음 : 중복코드 줄이기 가능
@Controller
public class MethodController {
	@RequestMapping(method=RequestMethod.GET)
	public String callGet() {
		return "method/methodForm";    //return type: ModelAndView, String(forward 시키려는 주소), (void) 세가지
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String callPost() {
		return "method/methodProcess";
	}
}
