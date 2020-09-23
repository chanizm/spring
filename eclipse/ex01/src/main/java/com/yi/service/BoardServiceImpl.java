package com.yi.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {

		log.info("register......" + board);

		mapper.insert(board);
	}

	@Override
	public BoardVO get(String message_id) {

		log.info("get......" + message_id);

		return mapper.read(message_id);

	}

	@Override
	public boolean modify(BoardVO board) {

		log.info("modify......" + board);

		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(int message_id) {

		log.info("remove...." + message_id);

		return mapper.delete(message_id) == 1;
	}

	// @Override
	// public List<BoardVO> getList() {
	//
	// log.info("getList..........");
	//
	// return mapper.getList();
	// }

	@Override
	public List<BoardVO> getList(Criteria cri) {

		log.info("get List with criteria: " + cri);

		//return mapper.getList(cri);
		List<BoardVO> boardList = Collections.emptyList();

		int boardTotalCount = mapper.getTotalCount(cri);

		if (boardTotalCount > 0) {
			boardList = mapper.getListWithPaging(cri);
		}

		return boardList;
	}
	

	@Override
	public int getTotal(Criteria cri) {

		log.info("get total count");
		return mapper.getTotalCount(cri);

		 }
	@Override
	 public List<BoardVO> getList() {
	 return mapper.getList();
	}
	
	
	
	
}