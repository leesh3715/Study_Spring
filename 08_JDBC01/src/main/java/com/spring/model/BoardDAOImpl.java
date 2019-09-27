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
		sql = "select * from board order by board_no desc";
		
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
				dto.setBoard_date(rs.getString("board_regdate"));				
				return dto;
			}
		});
	}

	@Override
	public void insertBoard(final BoardDTO dto) { // 이너클래스이기 때문에 outer 클래스의 변수를 사용할 수 있는데, 값이 안으로 들어오면서 변경 될수 있기 때문에 final 선언 
		sql = "insert into board values(board_seq.nextval,?,?,?,?,default,sysdate)";
		template.update(sql, new PreparedStatementSetter() {
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
	public BoardDTO boardCont(int no) {
		sql = "select * from board where board_no = ?";
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
				dto.setBoard_date(rs.getString("board_regdate"));
				return dto;
			}
		},no);
		
	}

	@Override
	public void updateBoard(final BoardDTO dto, String dbpwd) {
		sql="update board set board_title = ?, board_cont = ? where board_no = ?";
		if(dto.getBoard_pwd().equals(dbpwd)) {
			template.update(sql, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, dto.getBoard_title());
					ps.setString(2, dto.getBoard_cont());
					ps.setInt(3, dto.getBoard_no());
				}
			});
			
			
		} else {
			System.out.println("패스워드가 다릅니다.");
		}
		
			
	}
	@Override
	public void deleteBoard(String userpwd, final BoardDTO dto) {
		if(userpwd.equals(dto.getBoard_pwd())) {
			sql = "delete from board where board_no = ?";
			
			template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
			ps.setInt(1, dto.getBoard_no());
			}
		});
		} else {
			System.out.println("삭제 실패");
		}
	}

	@Override
	public void readCount(final int no) {
		sql = "update board set board_hit = board_hit + 1 where board_no = ?";
		template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, no);
			}
		});
	}
	

}
