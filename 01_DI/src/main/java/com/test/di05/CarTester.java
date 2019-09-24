package com.test.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTester {

	public static void main(String[] args) {
		
		// car.xml 파일을 읽어 들여서 스프링 컨테이너를 생성.
		// bean이 만들어진다. == 객체로 생성이 된다. == 메모리로 로딩이 된다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:car.xml");
		// 스프링 컨테이너에서 빈(객체)을 가져온다. ==> 주입(DI)

		//Car car = ctx.getBean("hyun", Hyundai.class);
		Car car = (Car)ctx.getBean("kia");
		
		car.drive();
		
		// 해당 어플리케이션을 종료 시 스프링 컨테이너에 존재하는 모든 빈(객체)을 종료.
		ctx.close();
	}

}

