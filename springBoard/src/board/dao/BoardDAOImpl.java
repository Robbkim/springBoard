package board.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import board.dto.BoardDTO;

public class BoardDAOImpl implements BoardDAO {
	private JdbcTemplate jdbcTemplate;
		
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	class MyRowMapper implements RowMapper<BoardDTO>{

		@Override
		public BoardDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			BoardDTO dto = new BoardDTO();
			dto.setNum(rs.getInt("num"));
			dto.setWriter(rs.getString("writer"));
			dto.setEmail(rs.getString("email"));
			dto.setSubject(rs.getString("subject"));
			dto.setPasswd(rs.getString("passwd"));
			dto.setReg_date(rs.getString("reg_date"));
			dto.setReadcount(rs.getInt("readcount"));
			dto.setContent(rs.getString("content"));
			dto.setIp(rs.getString("ip"));
			return dto;
		}
		
	}
	@Override
	public List<BoardDTO> listBoard() {
		String sql = "select * from board order by num desc";
		MyRowMapper mapper =new MyRowMapper();
		List<BoardDTO> list = jdbcTemplate.query(sql, mapper);
		return list;
	}

	@Override
	public BoardDTO getBoard(int num, String mode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBoard(BoardDTO dto) {
		String sql = "insert into board values(board_seq.nextval, ?,?,?,?,sysdate,0,?,?)";
		Object[] values = new Object[] {dto.getWriter(), dto.getEmail(), dto.getSubject(), dto.getPasswd(), dto.getContent(),
																dto.getIp()};
		int res = jdbcTemplate.update(sql, values);
		return res;
	}

	@Override
	public int deleteBoard(int num, String passwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}