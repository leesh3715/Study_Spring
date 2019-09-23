package com.test.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Exam_Main {

	public static void main(String[] args) {
		 
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:examdao.xml");
		ExamDao dao = ctx.getBean("exam", ExamDao.class);
		
		dao.output();
		ctx.close();

	}

}

