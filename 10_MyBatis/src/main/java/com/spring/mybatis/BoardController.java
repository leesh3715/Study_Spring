package com.spring.mybatis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import com.spring.model.BoardDAO;
import com.spring.model.BoardDTO;

@Controller
public class BoardController {

	@Autowired
	private BoardDAO dao;

	@RequestMapping("/board_list.do")
	public String list(Model model) {
		List<BoardDTO> list = this.dao.getList();
		model.addAttribute("List", list);
		return "board_list";
	}

	@RequestMapping("/board_write.do")
	public String insert() {
		return "board_write";
	}

	@RequestMapping(value = "/board_write_ok.do", method = RequestMethod.POST)
	public String insertOk(BoardDTO dto, Model model) {
		this.dao.insertBoard(dto);
		return "redirect:board_list.do";
	}

	@RequestMapping(value = "/board_cont.do", method = RequestMethod.GET)
	public String cont(@RequestParam("no") int no, Model model) {
		this.dao.readCount(no); // 조회수 증가 메서드
		BoardDTO dto = this.dao.content(no); // 상세 내역 조회 메서드
		model.addAttribute("cont", dto);
		return "board_cont";
	}
	@RequestMapping(value = "/board_edit.do", method = RequestMethod.GET)
	public String edit(@RequestParam("no")int no, Model model) {
		BoardDTO dto = this.dao.content(no); // 상세 내역 조회 메서드
		model.addAttribute("modify", dto);
		return "board_edit";
	}
	@RequestMapping("/board_edit_ok.do")
	public void editOk(BoardDTO dto, @RequestParam("db_pwd") String db_pwd, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(db_pwd.equals(dto.getBoard_pwd())) {
			dao.updateBoard(dto);
			out.println("<script>");
			out.println("alert('수정 성공')");
			out.println("location.href='board_cont.do?no="+dto.getBoard_no()+"'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('수정 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	@RequestMapping("/board_delete.do")
	public String delete(@RequestParam("no") int no, Model model) {
		BoardDTO dto = this.dao.content(no);
		model.addAttribute("delete", dto);
		return "board_delete";
	}
	@RequestMapping("/board_delete_ok.do")
	public void deleteOk(BoardDTO dto, @RequestParam("db_pwd") String db_pwd, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(db_pwd.equals(dto.getBoard_pwd())) {
			dao.deleteBoard(dto.getBoard_no());
			out.println("<script>");
			out.println("alert('삭제 성공')");
			out.println("location.href='board_list.do'");
			out.println("</script>");
		} else {
			out.println("<script>");
			out.println("alert('삭제 실패')");
			out.println("history.back()");
			out.println("</script>");
		}
	}
	
	@RequestMapping(value="/board_search.do")
	public String search(HttpServletRequest request, Model model) {
		String find_field = request.getParameter("find_field").trim();
		String find_name = request.getParameter("find_name").trim();
		List<BoardDTO> list =  dao.search(find_field, find_name);
		model.addAttribute("search", list);
		
		return "board_search";
	}
	
}