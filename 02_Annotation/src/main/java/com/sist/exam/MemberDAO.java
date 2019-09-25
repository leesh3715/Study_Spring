package com.sist.exam;

import org.springframework.stereotype.Repository;


@Repository
public class MemberDAO {

	// static으로 선언된 instance 변수에 객체를 생성하여 초기화
	private static MemberDAO instance = new MemberDAO();
	
	// instance를 리턴 해주는 메서드
	public static MemberDAO getInstance() { // 싱글톤 방식
		
		return instance;
	}
	// 생성자의 접근지정자 private, 따라서 외부에서 객체 생성이 불가능하게 만들어줌
	private MemberDAO() {	}
	
	public void result(MemberDTO dto) {
		if(dto.getId().equals("hong") && dto.getPwd().equals("1234")) {
			System.out.println("로그인 성공");
		} else {
			System.out.println("로그인 실패");
		}
	}
	
	
	
}
