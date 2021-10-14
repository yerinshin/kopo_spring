package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {
	
	/**
	 *  전체게시글 조회
	 * @return DB에서 조회된 BoardVO List
	 */
	List<BoardVO> searchAll();
	
	/**
	 *  게시글 상세 조회
	 * @return DB에서 no로 조회한 하나의 BoardVO
	 */
	BoardVO searchDetail(int no);
	
	void deleteBoard(int no);
}