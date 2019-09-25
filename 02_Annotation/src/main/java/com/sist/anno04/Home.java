package com.sist.anno04;

import javax.annotation.Resource;

public class Home {

	@Resource(name="num1")
	// 설정 파일에서 (xml)에서 동일한 id로 자동 매핑 진행
	// 멤버와 메서드 둘다 적용 가능함
	private Number num1;
	@Resource(name="num2")
	private Number num2;
	// 세터메서드에 적용했음
	private Number num3;
	
	public Number getNum1() {
		return num1;
	}

	/*
	 * public void setNum1(Number num1) { this.num1 = num1; }
	 */
	public Number getNum2() {
		return num2;
	}

	/*
	 * public void setNum2(Number num2) { this.num2 = num2; }
	 */
	public Number getNum3() {
		return num3;
	}
	
	@Resource(name="num3")
	// 멤버와 설정 메서드에도 동일하게 적용이 가능함
	public void setNum3(Number num3) {
		this.num3 = num3;
	}

	public void print(){
		System.out.println("num1 => " + num1);
		System.out.println("num2 => " + num2);
		System.out.println("num3 => " + num3);
	}
	
}
