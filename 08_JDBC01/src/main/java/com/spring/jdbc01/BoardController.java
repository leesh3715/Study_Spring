package com.spring.jdbc01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.model.BoardDAO;
import com.spring.model.BoardDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/board_list.do")
	public String list(Model model) {
		List<BoardDTO> list = this.dao.getBoardList();
		model.addAttribute("List", list);
		return "board_list";
	}
	@RequestMapping("/board_write.do")
	public String writeForm(Model model) {
		return "board_writeForm";
	}

	@RequestMapping("/board_write_ok.do")
	public String writeOk(BoardDTO dto, Model model) {
		this.dao.insertBoard(dto);
		return "redirect:board_list.do"; //redirect를 사용하면 다시 돌아감	
	}
	@RequestMapping("/board_cont.do")
	public String cont(@RequestParam("no") int no, Model model) { // 스프링에서는 자동으로 형변환이 됨
		this.dao.readCount(no);
		BoardDTO dto = this.dao.boardCont(no);
		model.addAttribute("Cont", dto);
		return "board_cont";
	}
	@RequestMapping("/board_edit.do")
	public String modify(@RequestParam("no") int no, Model model) {
		BoardDTO dto = this.dao.boardCont(no);
		model.addAttribute("Modify", dto);
		return "board_editForm";
	}
	@RequestMapping("/board_edit_ok.do")
	public String modifyOk(BoardDTO dto, Model model, @RequestParam("dbpwd") String dbpwd, HttpServletResponse response) throws IOException {
		String returnS = null;
		// model 객체는 값을 저장하여 넘겨 줄때 사용하기 때문에 없어도 됨
		if(dbpwd.equals(dto.getBoard_pwd())){
			this.dao.updateBoard(dto);
			/*
			 * // 스크립트 알림을 위해서, 메서도 리턴이 void 일때 스크립트 태그를 통해서 리턴해준다.
			 * response.setContentType("text/html; charset=UTF-8"); PrintWriter out =
			 * response.getWriter(); out.println("<script>");
			 * out.println("alert('게시글 수정 성공')");
			 * out.println("location.href='board_cont.do?no="+dto.getBoard_no());
			 * out.println("</script>");
			 */
			returnS = "redirect:board_cont.do?no=" + dto.getBoard_no(); 
			return returnS;			
		} else {
			returnS = "redirect:board_list.do";
			return returnS;
		}
	}
	
	@RequestMapping("/board_delete.do")
	public String delete(@RequestParam("no") int no, Model model) {
		BoardDTO dto = this.dao.boardCont(no);
		model.addAttribute("Delete", dto);
		return "board_deleteForm";
	}
	
	@RequestMapping("/board_delete_ok.do")
	public String deleteForm(BoardDTO dto, Model model, @RequestParam("userpwd") String userpwd) {
		String returnS = null;
		if(userpwd.equals(dto.getBoard_pwd())) {
			this.dao.deleteBoard(userpwd, dto);
			returnS ="redirect:board_list.do"; 
			return returnS;
		} else { 
			returnS ="redirect:board_cont.do?no=" + dto.getBoard_no(); 
			return returnS;
		}
		
	}
}
