package com.yi.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yi.domain.BoardVO;
import com.yi.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTest {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	//@Test
	public void testGetList() {
		mapper.getList().forEach(board -> log.info(board));
	}
	//@Test
	public void testInsert() {
		BoardVO board = new BoardVO();
		
		board.setGuest_name("새로작성");
		board.setPassword("새로작성");
		board.setMessage("새로작성");
		
		mapper.insert(board);
	}
	//@Test
	public void testRead() {
		BoardVO board =mapper.read("김유신");
		log.info(board);
		
		
	}
	
	//@Test
	public void testDelete() {
		log.info("지워졌네요"+mapper.delete(1));
	}

	@Test
	public void testUpdate() {
		BoardVO board =new BoardVO();
		board.setMessage_id(2);
		board.setGuest_name("김");
		board.setPassword("123");
		board.setMessage("수정");
		int count =mapper.update(board);
		log.info("수정끝 " + count);
		
		
	}
}
