package com.test.di09;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		Player player1 = ctx.getBean("player1", Player.class); // 메서드 이름이 아이디가 됨
		/*
		 * System.out.println("선수 이름  : " + player1.getName());
		 * System.out.println("선수 나이  : " + player1.getAge());
		 * System.out.println("선수 포지션  : " + player1.getPosition());
		 * System.out.println("선수 키 : " + player1.getHeight());
		 * System.out.println("선수 몸무게  : " + player1.getWeight());
		 * System.out.println("::::::::::::::::::::::");
		 */
		player1.print();
		
		Player player2 = ctx.getBean("player2", Player.class);
		/*
		 * System.out.println("선수 이름  : " + player2.getName());
		 * System.out.println("선수 나이  : " + player2.getAge());
		 * System.out.println("선수 포지션  : " + player2.getPosition());
		 * System.out.println("선수 키 : " + player2.getHeight());
		 * System.out.println("선수 몸무게  : " + player2.getWeight());
		 * System.out.println("::::::::::::::::::::::");
		 */
		player2.print();

		ctx.close();
	}
}