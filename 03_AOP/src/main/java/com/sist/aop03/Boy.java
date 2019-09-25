package com.sist.aop03;
/*
 * 남자 - 청소년
 * - 문을 열고 집에 들어갑니다. -- 공통 관심 사항(before)
 * - 컴퓨터로 게임을 합니다. -- 핵심 관심 사항
 * - 잠을 잡니다. -- 공통 관심 사항(after-returning)
 * - 문을 열고 집을 나옵니다. -- 공통 관심 사항(after)
 * - 화재 발생: 119에 신고 합니다. -- 공통 관심 사항(after-throwing)
 */

public class Boy implements Person {

	@Override
	public void doSomething() {
		System.out.println("컴퓨터로 게임을 합니다.");
	}
}
