package com.test.di06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Dao_Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:dao.xml");
		ServiceImpl service = (ServiceImpl)ctx.getBean("service");
		//ServiceImple service = ctx.getBean("service",ServiceImpl.class);
		
		service.biz();
		ctx.close();
	}

}
