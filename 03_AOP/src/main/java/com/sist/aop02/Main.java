package com.sist.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop01.xml");
		
		  Person boy = ctx.getBean("boy",Person.class);
		  Person girl = ctx.getBean("girl",Person.class);
		  
		  boy.doSomething();
		  System.out.println("===================");
		  girl.doSomething();
		 
		ctx.close();
	}

}
