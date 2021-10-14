package kr.co.mlec.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping("/hello/hello.do")
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView("hello/hello");		//"WEB-INF/jsp/(spring-mvc.xml에서 설정)  hello/hello(컨트롤러설정)
		return mav;
	}
}
