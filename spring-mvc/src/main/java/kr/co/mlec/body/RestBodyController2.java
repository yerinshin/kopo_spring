package kr.co.mlec.body;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.mlec.form.MemberVO;

@RestController			//RestController : 클래스에 붙음, 메소드가 메세지 기반
@RequestMapping("/ajax")
public class RestBodyController2 {

	@RequestMapping("/restBody.do")
	public String resStringBody() {
		
		return "OK, 성공";				//한글처리 위한 message Converter 처리 -> spring-mvc.xml에서
	}
	
	@RequestMapping("/restBody.json")	//web.xml 에 .json 추가 
	public Map<String, String> resJsonBody() {
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("id", "hong");
		result.put("name", "홍길동");
		result.put("addr", "서울");
		
		return result;
	}
	
	@RequestMapping("/restVOBody.json")	
	public MemberVO resJsonVOBody() {
		
		MemberVO vo = new MemberVO();
		vo.setId("hong");
		vo.setName("홍길동");
		vo.setPassword("1234");
		
		return vo;
	}
	
	@RequestMapping("/restStringListBody.json")	
	public List<String> resJsonStringListBody() {
		
		List<String> list = new ArrayList<String>();
		for(int i = 1; i <=4; i ++) {
			list.add(String.valueOf(i));
		}
		return list;
	}
	
	@RequestMapping("/restVOListBody.json")	
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
