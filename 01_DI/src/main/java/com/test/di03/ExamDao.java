package com.test.di03;

public class ExamDao {
	private String msg;
	private String msg2;
	
	public ExamDao() {
		this.msg = "BYE";
	} // 기본 생성자
	
	public ExamDao(String msg, String msg2) { // 인자 생성자
		this.msg = msg;
		this.msg2 = msg2;
	}
	
	public void output() {
		System.out.println("메세지 ==> " + msg + msg2);
	}
	
}
