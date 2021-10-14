package kr.ac.kopo.reply.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public void insertReply(ReplyVO reply) {
		System.out.println("dao");
		sqlSessionTemplate.insert("reply.ReplyDAO.insert" , reply);
	}

	public List<ReplyVO> selectAllByBoardNo(int boardNo) {
		List<ReplyVO> replyList = sqlSessionTemplate.selectList("reply.ReplyDAO.selectByBoardNo", boardNo);
		return replyList;
	}

}
