package com.test.di02;

public class MyGetSum {
	private int a;
	private int b;
	GetSum getsum;
	
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public GetSum getGetsum() {
		return getsum;
	}
	public void setGetsum(GetSum getsum) {
		this.getsum = getsum;
	}
	
	// 핵심
	public void sum() {
		getsum.sum(a, b);
	}
}
