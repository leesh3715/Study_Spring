package com.spring.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private JdbcTemplate template;
	String sql = null;
	
	@Override
	public List<BoardDTO> getBoardList() { // 전체 게시판을 조회하는 메서드
		List<BoardDTO> list = null;
		sql = "select * from jsp_bbs order by board_no desc";
		
		return list // list에 dto 객체가 순차적으로 들어감
				= template.query(sql, new RowMapper<BoardDTO>() {	// query 메서드는 반환 타입이 List타입
			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException { // mapRow(): 행번호를 체크하여 rs 객체에  넘겨줌
				// DTO 클래스 객체 생성
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				return dto;
			}
		});
	}

	@Override
	public void insertBoard(final BoardDTO dto) {
		sql = "insert into jsp_bbs values(bbs_seq.nextval,?,?,?,?,default,sysdate,bbs_seq.currval,0,0)";
		template.update(sql,new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getBoard_writer());
				ps.setString(2, dto.getBoard_title());
				ps.setString(3, dto.getBoard_cont());
				ps.setString(4, dto.getBoard_pwd());
			}
		});
		
	}

	@Override
	public BoardDTO boardCont(int no) { // 상세 내역 조회
		sql = "select * from jsp_bbs where board_no = ?";
		return template.queryForObject(sql, new RowMapper<BoardDTO>() {
			@Override
			public BoardDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardDTO dto = new BoardDTO();
				dto.setBoard_no(rs.getInt("board_no"));
				dto.setBoard_writer(rs.getString("board_writer"));
				dto.setBoard_title(rs.getString("board_title"));
				dto.setBoard_cont(rs.getString("board_cont"));
				dto.setBoard_pwd(rs.getString("board_pwd"));
				dto.setBoard_hit(rs.getInt("board_hit"));
				dto.setBoard_date(rs.getString("board_date"));
				dto.setBoard_group(rs.getInt("board_group"));
				dto.setBoard_step(rs.getInt("board_step"));
				dto.setBoard_indent(rs.getInt("board_indent"));
				return dto;
			}
		}, no);
	}

	@Override
	public void readCount(int no) {
		/*
		 * sql = "update board set board_hit = board_hit + 1 where board_no = ?";
		 * template.update(sql, new PreparedStatementSetter() {
		 * 
		 * @Override public void setValues(PreparedStatement ps) throws SQLException {
		 * ps.setInt(1, no); } });
		 */
	}

	@Override
	public void updateBoard(final BoardDTO dto) {
		sql = "update jsp_bbs set board_writer = ?, board_title = ?, board_cont = ? where board_no = ?";
		template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, dto.getBoard_writer());
				ps.setString(2, dto.getBoard_title());
				ps.setString(3, dto.getBoard_cont());
				ps.setInt(4, dto.getBoard_no());
			}
		});
		
	}

	@Override
	public void deleteBoard(String userpwd, BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyUpdate(int no, int board_step) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void replyBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	

}
