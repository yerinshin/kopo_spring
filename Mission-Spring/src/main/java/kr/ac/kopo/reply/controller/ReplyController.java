package kr.ac.kopo.reply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

@RestController
public class ReplyController {
	
	@Autowired
	private ReplyService service;
	
	@PostMapping("/reply")
	public void write(ReplyVO reply) {
		
		System.out.println(reply);
		service.insertReply(reply);
		System.out.println("컨트롤러");
	}
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> selectAllByBoardNo(@PathVariable("boardNo") int boardNo) {
		System.out.println("컨트롤러");
		List<ReplyVO> replyList = service.selectAllByBoardNo(boardNo);
		return replyList;
	}
	
}
