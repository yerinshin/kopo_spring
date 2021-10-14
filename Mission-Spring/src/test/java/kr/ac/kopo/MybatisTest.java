package kr.ac.kopo;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.vo.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring/spring-mvc.xml"})
public class MybatisTest {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private	SqlSessionFactory sqlFactory;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	@Test
	public void 로그인테스트() throws Exception {
		MemberVO member = new MemberVO();
		member.setId("yerin");
		member.setPassword("1234");
		
		MemberVO userVO = sessionTemplate.selectOne("member.MemberDAO.login", member);
		
		assertNotNull(userVO);
	}
	
	
	
	
	@Ignore	//이 단위 테스트 지금 실행하지 않겠다는 뜻
	@Test  //실행할 때 쓰는 annotation : 단위 test라서 main을 실행시키는거 아님. main 필요없음
	public void DataSource생성테스트() throws Exception {
		//System.out.println("dataSource : " + dataSource);
		assertNotNull(dataSource);    	//dataSource가 가지고 있는 값이 null이 아닌지만 확인
	}
	
	@Ignore
	@Test
	public void mybatis연동테스트() throws Exception {
//		assertNotNull(sqlFactory);
		assertNotNull(sessionTemplate);
	}
	
	@Ignore
	@Test
	public void 전체게시글조회Test() throws Exception {
		//assertNotNull(sqlSessionTemplate); 	
		
		List<BoardVO> list =sessionTemplate.selectList("board.BoardDAO.selectAll");
		 
		 for(BoardVO board: list) {
			 System.out.println(board);
		}
	}
	
	@Ignore
	@Test
	public void 상세게시글조회Test() throws Exception {
		BoardVO board = sessionTemplate.selectOne("board.BoardDAO.selectByNo", 21);
		System.out.println(board);
	}
	
	
	
}