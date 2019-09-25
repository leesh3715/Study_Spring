package com.sist.anno03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Student {
	
	@Autowired
	@Qualifier(value="Tony")
	private Boy boy;

	public Boy getBoy() {
		return boy;
	}

	public void setBoy(Boy boy) {
		this.boy = boy;
	}
	
	public void print() {
		System.out.println("학생 이름: " + boy.getName());
		System.out.println("학생 이름: " + boy.getAge());
	}
	
}
