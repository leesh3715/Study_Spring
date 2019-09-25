package com.sist.exam;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("beans_exam.xml");
		MemberDTO dto = ctx.getBean(MemberDTO.class);
		
		// id 와 pwd 출력
		System.out.println(dto.toString()); // toString 호출

		MemberService memberService = ctx.getBean(MemberService.class);
		memberService.login(dto);
		
		ctx.close();
	}

}
