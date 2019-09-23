package com.test.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:getsum.xml");
		// setter() 메서드를 이용한 주입
		MyGetSum getsum = ctx.getBean("mysum", MyGetSum.class);
		getsum.sum();
	}
}
