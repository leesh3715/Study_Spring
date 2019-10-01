package com.spring.model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<BoardDTO> getList() {
		return this.sqlSession.selectList("list"); // 전체 내용을 dto 타입으로 다 가져오는 메서드 
	}

	@Override
	public void insertBoard(BoardDTO dto) {
		this.sqlSession.insert("add", dto);
	}

	@Override
	public void readCount(int no) {
		this.sqlSession.update("count",no);

	}

	@Override
	public BoardDTO content(int no) {		
		return this.sqlSession.selectOne("cont", no);
	}

	@Override
	public void updateBoard(BoardDTO dto) {
		this.sqlSession.update("update", dto);

	}

	@Override
	public void deleteBoard(int no) {
		this.sqlSession.delete("delete", no);

	}

	@Override
	public List<BoardDTO> search(String field, String name) {
		
		return this.sqlSession.selectList("field", name);
		
		/*
		 * if(field.equals("title")) { return this.sqlSession.selectList("title", name);
		 * } else if(field.equals("cont")){ return this.sqlSession.selectList("content",
		 * name); } else if(field.equals("title_cont")) { return
		 * this.sqlSession.selectList("title_cont", name); } else
		 * if(field.equals("writer")) { return this.sqlSession.selectList("writer",
		 * name); } return null;
		 */
	}

}
