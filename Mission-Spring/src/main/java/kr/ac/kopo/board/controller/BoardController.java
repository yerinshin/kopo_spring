package kr.ac.kopo.board.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {	
	
	@Autowired
	private BoardService service;
	
	@RequestMapping("/board")
	public ModelAndView selectAll() {
		List<BoardVO> boardList = service.selectAllBoard();
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", boardList); 
		
		return mav;
	}
	
	
	
/*
	//http://localhost:9998/Mission-Spring/board/detail?no=21
	//게시글 번호 알아와야함 -> request 객체 필요
 	@RequestMapping("/board/detail")
	public void selectByNo(HttpServletRequest request) {
 		int no = Integer.parseInt(request.getParameter("no"));
		System.out.println("no : " + no);
	}
*/
 	
	//http://localhost:9998/Mission-Spring/board/detail?no=21
	@RequestMapping("/board/detail")
	public void selectByNo(@RequestParam("no") int no ) {
		System.out.println("no : " + no);
	}
	
 	
 	//http://localhost:9998/Mission-Spring/board/21
 	@RequestMapping("/board/{no}")  				//바뀌는 변수(값)이 들어올때는 {}로 표현
 	public ModelAndView selectByNo2(@PathVariable("no") int no) {		//path(url)에서 뽑아내고 싶을 때 : @PathVariable
 		BoardVO board = service.selectByNo(no);
 		ModelAndView mav = new ModelAndView("board/detail");
 		mav.addObject("board", board);
 		return mav;
 	}
 	
 	//http://localhost:9998/Mission-Spring/board/delete/21
 	@RequestMapping("/board/delete/{no}") 
 	public String delete(@PathVariable("no") int no) {
 		service.deleteBoard(no);
 	
 		return "redirect:/board";
 	}
 	
 //	@RequestMapping(value="/board/write", method=RequestMethod.GET)	
 	@GetMapping("/board/write")					//스프링4.3버전이후 
 	public String writeForm(Model model) {
 
 		model.addAttribute("boardVO", new BoardVO());	//공유영역에 객체 등록(request영역)
 		
 		return "board/write";
 	}
 	
// 	@RequestMapping(value="/board/write", method=RequestMethod.POST) 	
 	@PostMapping("/board/write")				//스프링4.3버전이후
 // 1. @Valid : 필수항목 null인지 아닌지 check!  2. check한 결과 Errors에 들어감  3.BoardVO로 객체 받아오면 boardVO라는 이름으로 board객체 자동 등록됨
 	public String write(@Valid BoardVO board, Errors error) {			
 		System.out.println("post /board/write");
 		System.out.println(board);
 		
 		if(error.hasErrors()) {
 			System.out.println("오류발생 !!! ");
 			return "board/write";
 		}
 		
 		return "redirect:/board";
 	}

 	
 /* 	
 //	@RequestMapping(value="/board/write", method=RequestMethod.GET)	
 	@GetMapping("/board/write")					//스프링4.3버전이후 
 	public String writeForm() {
 		
 		return "board/write";
 	}
 	
// 	@RequestMapping(value="/board/write", method=RequestMethod.POST) 	
 	@PostMapping("/board/write")				//스프링4.3버전이후 
 	//1.날라오는 파라미터(title, writer, content)를 알아서 BoardVO에 넣어서 가져옴 2.return형이 void 일 경우, uri와 똑같은 곳으로 forward시킴
 	public String write(BoardVO board) {		
 		System.out.println("post /board/write");
 		System.out.println(board);
 		
 		return "redirect:/board";
 	 }
 	
*/ 	
 	
}

















