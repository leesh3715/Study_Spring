package com.test.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test_Main {

	public static void main(String[] args) {
		
		
		//TestDAOImpl dao = new TestDAOImpl();
		//dao.printMsg();
		// 원래는 이렇게 객체를 생성 했음, 의존도가 높기 때문에 의존하는 객체의 기능이 바뀌게 되면 다 수정해야함(비효율적)
		
		// DI 주입을 어떻게 할 것인지 xml 문서에 기입이 되어 있음
		// 스프링 컨테이너가  ctx가 "classpath:test.xml"을 보고 DI를 수행
		// text.xml 파일은 resources 폴더에 있어야 함
		
		// DI 작업을 해 주는 스프링 객체
		// xml 파일을 이용해서 스프링 컨테이너를 생성한다.
		// xml에 설정되어 있는 그대로 bean이라고 불리는 객체를 생성한다(메모리로 로딩)
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:test.xml");
		// 주입 과정이 진행
		// new 키워드를 사용하지 않고, 직접 스프링 컨테이너에서 꺼내서 사용한다.
		// TestDAO dao = new TestDAOImpl();
		TestDAO dao =  ctx.getBean("daoImpl", TestDAOImpl.class);
		dao.printMsg();
		ctx.close();
	}

}
