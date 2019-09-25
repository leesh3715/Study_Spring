package com.sist.aop02;

public class MyAspect {
	private double time;

	public void before() {
		time = System.currentTimeMillis();
		System.out.println("문을 열고 집에 들어갑니다.");
	}

	// 공통 실행 기능 메서드들 중에 이 사이에 doSomething 메서드가 실행 됨
	
	public void after_returning() {
		System.out.println("잠을 잡니다.");
	}
	public void af() {
		time = System.currentTimeMillis() - time;
		System.out.println("문을 열고 집을 나옵니다.");
		System.out.println("걸린 시간 -> " + time + "ms");
	}


	public void after_throwing() {
		System.out.println("화재 발생: 119에 신고합니다.");
	}
}
