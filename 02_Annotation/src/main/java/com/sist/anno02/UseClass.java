package com.sist.anno02;

import org.springframework.beans.factory.annotation.Autowired;

/*
 * @Autowired 애노테이션
 * - 생성자, 필드(프로퍼티), 설정 메서드, 일반 메서드에 지정 가능
 * @Autowired 애노테이션은 타입을 이용해서 자동적으로 프로퍼티에 값을 설정하기 때문에 
 * 해당 타입에 빈 객체가 존재하지 않거나 또는 빈 객체가 두 개 이상 존재할 경우 예외가 발생
 	@Autowired(required=false)로 지정 하면 해당 타입의 빈 객체가 존재하지 않더라도 스프링은 예외를 발생하지 않음, 기본값은 @Autowired(required=true) 
 * */


public class UseClass {
	
	@Autowired
	private ImplClass impl;

	
	public ImplClass getImpl() {
		return impl;
	}

	// ImplClass 타입을 찾아서 DI
//	public void setImpl(ImplClass impl) {
//		this.impl = impl;
//	}
	
	public void implCall() {
		System.out.println("UseClass 실행");
		this.impl.print();
	}
	
	
}
