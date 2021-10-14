package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.mlec.form.MemberVO;

/*
  		@ResponseBody	: 자바가 만든 객체 값을 클라이언트가 인식할 수 있는 json으로 바꾸는 것
  		@RequestBody 	: json형태로 날라오는 data를 java객체로 변환 (파라미터에 붙음)
*/

@Controller
@RequestMapping("/ajax")
public class ResBodyController {

	@RequestMapping("/resBody.do")
	@ResponseBody						//forward 시키지 말고 (return의 문자열) 바로 응답
	public String resStringBody() {
		
		return "OK, 성공";				//한글처리 위한 message Converter 처리 -> spring-mvc.xml에서
	}
	
	@RequestMapping("/resBody.json")	//web.xml 에 .json 추가 
	@ResponseBody
	public Map<String, String> resJsonBody() {
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result;
	}
	
	@RequestMapping("/resVOBody.json")	
	@ResponseBody
	public MemberVO resJsonVOBody() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/resStringListBody.json")	
	@ResponseBody
	public List<String> resJsonStringListBody() {
		
		List<String> list = new ArrayList<String>();
		for(int i = 1; i <=4; i ++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	
	@RequestMapping("/resVOListBody.json")	
	@ResponseBody
	public List<MemberVO> resVOListBody() {
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		for(int i = 0; i < 4; i ++) {
			MemberVO vo = new MemberVO();
			vo.setId("hong");
			vo.setName("홍길동");
			vo.setPassword("1234");
			list.add(vo);
		}
		return list;	//자바스크립트 객체의 형태로 변환
	}
}
