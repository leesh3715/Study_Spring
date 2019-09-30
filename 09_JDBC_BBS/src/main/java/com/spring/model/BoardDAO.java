package com.spring.model;

import java.util.List;

/*
 * BoardDAO 인터페이스 특징
 * 1. 호출하는 클래스와 실제 DB에 접근하는 구현 클래스와의 직접적인 의존 관계를 느슨하게 하기 위해서 인터페이스 사용.
 * 2. DB 검색 목록을 호출하는 메서드는 List(BoardDTO) 타입으로 리턴
 * 3. DB 접근을 위해서 관련 예외를 던진다. 
 */

public interface BoardDAO {
	
	List<BoardDTO> getBoardList();
	void insertBoard(BoardDTO dto);
	BoardDTO boardCont(int no);
	
	void readCount(int no); // 조회수 증가
	void updateBoard(BoardDTO dto);
	void deleteBoard(String userpwd, BoardDTO dto);
	void replyUpdate(int no, int board_step); // 게시판의 글의 step을 증가시키는 메서드
	void replyBoard(BoardDTO dto); // 게시판의 답변글을 추가하는 메서드
}
