package com.sist.anno01;

public class Required {
	private int number;

	public int getNumber() {
		return number;
	}
	
	@org.springframework.beans.factory.annotation.Required
	// 설정 파일에서 number에 값을 설정하지 않을 경우 예외 발생
	// 필수적으로 입력을 받아야 하는 상황이면 사용
	// 메서드에서만 표시가 가능(프로퍼티에 표시 불가능)
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void print() {
		System.out.println("Required.number = " + number);
	}
}
