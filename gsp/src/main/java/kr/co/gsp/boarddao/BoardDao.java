package kr.co.gsp.boarddao;

import java.util.ArrayList;

import kr.co.gsp.boarddto.BoardDto;

public interface BoardDao {
	public void write_ok(BoardDto bdto);
	public ArrayList<BoardDto> list();
}
