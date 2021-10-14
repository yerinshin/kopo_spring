package kr.ac.kopo.board.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.board.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List<BoardVO> searchAll() {

		List<BoardVO> list =sqlSessionTemplate.selectList("board.BoardDAO.selectAll");
		return list;
	}

	public BoardVO searchDetail(int no) {
		
		BoardVO board = sqlSessionTemplate.selectOne("board.BoardDAO.selectByNo", no);
		return board;
	}

	public void deleteBoard(int no) {
		sqlSessionTemplate.delete("board.BoardDAO.delete", no);
	}
	
}
