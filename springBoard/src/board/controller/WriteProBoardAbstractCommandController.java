package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class WriteProBoardAbstractCommandController extends AbstractCommandController {
	private BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	protected ModelAndView handle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, BindException arg3)
														throws Exception {
		BoardDTO dto = (BoardDTO)arg2;
		dto.setIp(arg0.getRemoteAddr());
		int res = boardDAO.insertBoard(dto);
		String msg = null, url = null;
		if(res>0) {
			msg = "게시글 등록 성공!! 게시글 목록페이지로 이동합니다.";
			url = "list_board.do";
		}else {
			msg = "게시글 등록 실패 다시 입력해 주세요...";
			url = "writeForm_board.do";
		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/message");
		mav.addObject("msg", msg);
		mav.addObject("url", url);
		return mav;
	}

}
