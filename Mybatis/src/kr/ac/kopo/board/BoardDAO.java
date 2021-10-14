package kr.ac.kopo.board;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.MyConfig;

public class BoardDAO {
	private SqlSession session;
		
	public BoardDAO() {
		session = new MyConfig().getInstance();
		System.out.println(session);
	}
	
	public void work() {
		update();
//		selectWhere();
//		selectNos();
//		selectOne();
//		selectOne2();
//		selectAll();
//		insert();
	}
	
	private void update() {
		
		BoardVO vo = new BoardVO();
		
	/*
		vo.setNo(21);
		vo.setContent("java mybatis로 수정");
		vo.setWriter("홍길동");
//		session.update("board.BoardDAO.update", vo);
	*/
	
	/*
		vo.setNos(new int[] {20,21});
		vo.setContent("java mybatis로 수정22");
		session.update("board.BoardDAO.update2", vo);
	*/
		
		/* --실패!
		Map<Integer,String> map = new HashMap<>();
		String content = "java mybatis로 수정33";
		
		map.put(20, content);
		map.put(21, content);
		session.update("board.BoardDAO.update3", vo);
		*/
		session.commit();
		System.out.println("수정완료");
	}
	
	private void selectWhere() {
		
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere", "파일");
	
		BoardVO vo = new BoardVO();
		vo.setTitle("파일");
		vo.setWriter("hong");
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectWhere2", vo);
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
		
	}
	
	private void selectNos() {
		/*
		BoardVO board = new BoardVO();
		board.setNos(new int[] {4,5,6,7,8,19,20,21});
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos", board);
		*/
		
		/*
		List<Integer> nos = new ArrayList<>();
		nos.add(4);
		nos.add(5);
		nos.add(6);
		nos.add(7);
		nos.add(8);
		
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos2", nos);
		*/
		
		
		int[] nos = new int[] {4,5,6,7,8};
		List<BoardVO> list = session.selectList("board.BoardDAO.selectNos3", nos);
		
		for(BoardVO b : list) {
			System.out.println(b);
		}
		
		
	}
	
	private void selectOne2() {
		BoardVO board = new BoardVO();
		board.setNo(21);
		Map<String, Object> map = session.selectOne("board.BoardDAO.selectOne4", board);
		
		Set<String> keys = map.keySet();
		for(String key : keys ) {
			System.out.println(key + " : " + map.get(key));
		}
	}	
		
	
	private void selectOne() {
		BoardVO board = new BoardVO();
		board.setNo(21);
		BoardVO result = session.selectOne("board.BoardDAO.selectOne", board);
//		BoardVO result = session.selectOne("board.BoardDAO.selectOne2", board);
//		BoardVO result = session.selectOne("board.BoardDAO.selectOne3", 1);
//		BoardVO result = session.selectOne("board.BoardDAO.aaa", 1);
		System.out.println(result);
	}
	
	private void selectAll() {
		List<BoardVO> list = session.selectList("board.BoardDAO.selectAll");	//selectList : 알아서 boardVO의 list형태로 return
//		List<BoardVO> list = session.selectList("board.BoardDAO.selectAllMap");
		
		for(BoardVO board : list) {
			System.out.println(board);
		}
	}
	
	private void insert(){
		
		BoardVO board = new BoardVO();
		board.setTitle("객체로 삽입");
		board.setWriter("홍길동");
		board.setContent("삽입되었나???222");
		
		session.insert("board.BoardDAO.newBoard", board); 
		session.commit();
		 
		System.out.println("삽입완료...");
	}
		
 }
