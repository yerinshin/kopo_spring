package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;

	public void insertReply(ReplyVO reply) {
		System.out.println("서비스");
		replyDAO.insertReply(reply);
	}

	public List<ReplyVO> selectAllByBoardNo(int boardNo) {
		List<ReplyVO> replyList = replyDAO.selectAllByBoardNo(boardNo);
		return replyList;
	}

}
