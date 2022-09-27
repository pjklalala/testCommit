package kr.co.gsp.boardcontroller;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.gsp.boarddao.BoardDao;
import kr.co.gsp.boarddto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	public SqlSession sqlSession;
	
	@RequestMapping("/board/write")
	public String write() {
		
		return "/board/write";
	}
	
	@RequestMapping("/board/write_ok")
	public String write_ok(BoardDto bdto) {
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		bdao.write_ok(bdto);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/list")
	public String list(Model model) {
		BoardDao bdao=sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> list=bdao.list();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	

}
