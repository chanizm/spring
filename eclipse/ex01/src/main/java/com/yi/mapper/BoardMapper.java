package com.yi.mapper;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;

public interface BoardMapper {
	//@Select("select*from guestbook_message")
	public List<BoardVO> getList();

	public void insert(BoardVO board);

	public BoardVO read(String message_id);

		
	public int delete(int message_id);
	
	public int update(BoardVO board);
	//public void insertSelectKey(BoardVO board);
	

	// public List<BoardVO> getList();

	public List<BoardVO> getList(Criteria cri);
	public List<BoardVO> getListWithPaging(Criteria cri);
		//추가
	public int getTotalCount(Criteria cri);
	

}
