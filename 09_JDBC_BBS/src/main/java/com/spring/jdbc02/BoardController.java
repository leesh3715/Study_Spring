package com.spring.jdbc02;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String write() {
		return "board_writeForm";
	}
	
	@RequestMapping("/board_write_ok.do")
	public String write_ok(BoardDTO dto, Model model) {
		dao.insertBoard(dto);
		return "redirect:board_list.do";
	}
	
	@RequestMapping("/board_cont.do")
	public String cont(@RequestParam("no") int no, Model model) {
		dao.readCount(no);
		BoardDTO dto = dao.boardCont(no);
		model.addAttribute("Cont", dto);
		return "board_cont";
	}
	@RequestMapping("/board_edit.do")
	public String edit(@RequestParam("no") int no, Model model) {
		BoardDTO dto = dao.boardCont(no);
		model.addAttribute("Edit", dto);
		System.out.println(dto.getBoard_no());
		return "board_editForm";
	}
	@RequestMapping("/board_edit_ok.do")
	public String edit_ok(BoardDTO dto, Model model, @RequestParam("dbpwd") String dbpwd) {
		System.out.println(dto.getBoard_pwd());
		System.out.println(dbpwd);
		System.out.println(dto.getBoard_no());
		if (dto.getBoard_pwd().equals(dbpwd)) {
			dao.updateBoard(dto);
			return "redirect:board_cont.do?no=" + dto.getBoard_no();
		} else {
			return "redirect:board_list.do";
		}
	}
	@RequestMapping("/board_delete.do")
	public String delete(@RequestParam("no") int no, Model model) {
		BoardDTO dto = this.dao.boardCont(no);
		model.addAttribute("Delete", dto);
		return "board_deleteForm";
	}
	@RequestMapping("/board_delete_ok.do")
	public String delete_ok(BoardDTO dto, @RequestParam("dbpwd") String dbpwd) {
		if(dbpwd.equals(dto.getBoard_pwd())) {
			this.dao.deleteBoard(dto);
			return "redirect:board_list.do";
		} else {
			return "redirect:board_cont.do?no=" + dto.getBoard_no();
		}
	}
	@RequestMapping("/board_reply.do")
	public String reply(@RequestParam("no") int no, Model model) {
		BoardDTO dto =  dao.boardCont(no);
		model.addAttribute("Reply", dto);
		return "board_reply";
	}
	
	@RequestMapping("/board_reply_ok.do")
	public String reply_ok(BoardDTO dto, Model model) {
		dao.replyUpdate(dto.getBoard_no(), dto.getBoard_step());
		dao.replyBoard(dto);
		return "redirect:board_list.do";
	}
}
