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
		BoardDTO dto = dao.boardCont(no);
		model.addAttribute("Cont", dto);
		return "board_cont";
	}
	@RequestMapping("/board_edit.do")
	public String edit(@RequestParam("no") int no, Model model) {
		System.out.println("test");
		BoardDTO dto = dao.boardCont(no);
		model.addAttribute("Edit", dto);
		return "board_editForm";
	}
	@RequestMapping("/board_edit_ok.do")
	public String edit_ok(BoardDTO dto, Model model, @RequestParam("dbpwd") String dbpwd) {
		System.out.println(dto.getBoard_pwd());
		System.out.println(dbpwd);
		if (dto.getBoard_pwd().equals(dbpwd)) {
			dao.updateBoard(dto);
			return "redirect:board_cont.do?no=" + dto.getBoard_no();
		} else {
			return "";
		}

	}
}
