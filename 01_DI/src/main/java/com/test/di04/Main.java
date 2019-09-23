package com.test.di04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:person.xml");
		 PersonInfo info = ctx.getBean("personInfo", PersonInfo.class);
		 info.getPersonInfo();
		 
		 
		 ctx.close();

	}

}
