package com.sist.mvc01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.javafx.collections.SetAdapterChange;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/memberInput") // member.jsp 와 연결하기 위해 매핑
	public String input() {
		
		return "member"; // WEB-INF/views/member.jsp 로 이동함, servlet-context.xml 참조할 것
	}
	/*
	 * 스프링 MVC에서 Model(모델) 이란 컨트롤러에 의해서 비지니스 로직이 수행이 되고 나면 대체로 사용자에게 반환되어 브라우저에 표시될 정보가 만들어진다.
	 * 이러한 정보를 Model(모델)이라고 한다, 이 정보를 통해서 보통 JSP에 해당하는 View로 보내진다
	 * Model에는 View로 보내질 정보가 저장 된다.
	 */
	
	@RequestMapping("/memberInfo")
	public String member(Model model) {
		
		model.addAttribute("name","홍길동");
		
		return "member/memberInfo"; 	
	}
	
	@RequestMapping("/address")
	public String info(Model model) {
		
		model.addAttribute("addr","서울시 마포구 월드컵북로");
		
		return "member/meminfo"; 	
	}
}
