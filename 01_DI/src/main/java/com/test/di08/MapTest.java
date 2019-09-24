package com.test.di08;

import java.util.Map;
import java.util.Set;

public class MapTest {

	private Map<Integer, String> map;

	
	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}
	
	public void print() {
		Set<Integer> set =  map.keySet(); // map에 저장된 key 값을 반환하는 메서드
		for(Integer k : set) {
			System.out.println(map.get(k));
		}
	}
}
