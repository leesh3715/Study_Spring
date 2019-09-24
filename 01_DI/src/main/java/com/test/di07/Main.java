package com.test.di07;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 스프링은 객체를 생성하고 각 객체를 연결해주는 조립기 역할을 한다. 여기에 있는 GenericXmlApplicationContext 가
		 * 조립기 기능을 구현한 클래스 조립기에서 생성할 객체가 무엇이고, 각 객체를 어떻게 연결하는지에 대한 정보는 XML 파일에 설정이 되어 있음.
		 * GenericXmlApplicationContext 클래스는 이 XML 파일에 정의된 설정 정보를 읽어 와서 객체를 생성하고, 각각의 객체를 연결한 뒤에 내부적으로 보관을 함.
		 * XML 을 이용한 스프링 설정을 하다 보면 컨테이너가 생성할 객체를 지정하기 위해 <bean> 태그를 사용하는 것을 볼 수 있다.
		 * 스프링 컨테이너가 생성해서 보관하는 객체를 스프링 빈(Spring Bean) 객체라고 부르며, 일반적으로 자바 객체와 동일하다.
		 * 스프링 컨테이너는 생성한 빈 객체를 <이름, 빈 객체> 이렇게 쌍으로 보관을 한다.
		 * 스프링 컨테이너가 보관하고 있는 객체를 사용하고 있는 싶은 경우 빈 객체와 연결되어 있는 이름을 이용해서 객체를 참조하게 된다.
		 */
		
		/* 스프링 컨테이너의 종류
		 * BeanFactory : 단순히 스프링 컨테이너에서 객체를 생성하고 DI만 처리해 주는 기능만을 제공하는 객체.
		 * 하지만 스프링을 사용하는 이유는 단순히 DI만 사용하기 위함이 아니다.
		 * 스프링이 사용하는 다양한 부가 기능(트랜잭션 처리, 자바코드 기반 스프링 설정, 에노테이션을 이용한 빈 설정, 스프링을 이용한 웹 개발 등등) 때문인데,
		 * 이러한 부가 기능을 사용하려면 ApplicationContext 객체를 주로 사용하게 된다.
		 * - AbstractApplicationContext : 컨테이너 종료(close)와 같은 기능을 제공해 주는 객체
		 * - GenericXmlApplicationContext: AbstractApplicationContext 를 상속 받아서 만들어진 클래스로서 XML 파일에서 스프링 빈 설정 정보를 읽어오는 역할을 함
		 *  GenericXmlApplicationContext 객체를 생성할 때 파라미터 값으로 "classpath:baseball.xml" 을 전달 했는데 이는 클래스 패스에 위치한 XML 파일을 설정 파일로 사용한다는 의미 이다.
		 *  GenericXmlApplicationContext 객체는 전달 받은 XML 파일 에서 설정 정보를 읽어 와서 스프링 빈 객체를 생성하고 프로퍼티 값을 설정해 준다.
		 *  이렇게 생성된 스프링 빈 객체는 getBean() 이라는 메서드를 사용해서 구할 수 있다.
		 *  getBean() 메서드에서 첫번째 파라미터는 구하고자 하는 스프링 빈 객체의 고유한 id 이름이며, 두 번째 파라미터는 그 객체의 타입이다.
		 */
	
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:baseball.xml","classpath:baseball2.xml");
		Player player = (Player) ctx.getBean("player1");
		System.out.println("선수 이름: " + player.getName());
		System.out.println("선수 나이: " + player.getAge());
		System.out.println("선수 포지션: " + player.getPosition());
		System.out.println("선수 키: " + player.getHeight());
		System.out.println("선수 몸무게: " + player.getWeight());
		System.out.println(":::::::::::::::::::::::::::::::::");

		PlayerInfo player2 = ctx.getBean("playerinfo", PlayerInfo.class);
		Player player1 = player2.getPlayer();
		System.out.println("선수 이름: " + player1.getName());
		System.out.println("선수 나이: " + player1.getAge());
		System.out.println("선수 포지션: " + player1.getPosition());
		System.out.println("선수 키: " + player1.getHeight());
		System.out.println("선수 몸무게: " + player1.getWeight());
		System.out.println(":::::::::::::::::::::::::::::::::");
		
		Player player3 = ctx.getBean("player3", Player.class);
		System.out.println("선수 이름: " + player3.getName());
		System.out.println("선수 나이: " + player3.getAge());
		System.out.println("선수 포지션: " + player3.getPosition());
		System.out.println("선수 키: " + player3.getHeight());
		System.out.println("선수 몸무게: " + player3.getWeight());
		System.out.println(":::::::::::::::::::::::::::::::::");
		
		
		BaseBallTeam team = ctx.getBean("team", BaseBallTeam.class);
		System.out.println(":::국가대표 야구팀 명단:::");
		System.out.println("야구팀 감독: " + team.getManager());
		System.out.println("야구팀 타격코치: " + team.getBattingCoach());
		System.out.println("야구팀 투수코치: " + team.getPitcherCoach());
		System.out.println("야구팀 타자: " + team.getHitter());
		System.out.println("야구팀 투수: " + team.getPitcher());
		
		ctx.close();
	}
}
