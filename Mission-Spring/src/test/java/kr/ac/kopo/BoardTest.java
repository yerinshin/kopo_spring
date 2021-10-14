package kr.ac.kopo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.dao.BoardDAO;
import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:config/spring/spring-mvc.xml"})
public class BoardTest {

	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private BoardService boardService;

	@Test
	public void 전체게시글조회Test() throws Exception {

		 
//		List<BoardVO> list = boardDAO.searchAll();
		List<BoardVO> list = boardService.selectAllBoard();
		
		 for(BoardVO board: list) {
			 System.out.println(board);
		}
		 
	}
}
