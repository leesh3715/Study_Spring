package com.test.di04;

public class PersonInfo {

	private Person person;
	
	public PersonInfo() { } // 기본 생성자
	public PersonInfo(Person person) {
		this.person = person;
 	} // 인자 생성자
	
	public void getPersonInfo() {
		if(person != null) {
			System.out.println("이름: "+ person.getName());
			System.out.println("성별: "+ person.getGender());
			System.out.println("나이: "+ person.getAge());
			System.out.println("주민번호: "+ person.getJuminNo());
		}
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	/*
	 * public Person getPerson() { return person; }
	 */
	
	
}
