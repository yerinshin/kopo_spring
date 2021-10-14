package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardService {
	List<BoardVO> selectAllBoard();
	BoardVO selectByNo(int no);
	void deleteBoard(int no);
}
