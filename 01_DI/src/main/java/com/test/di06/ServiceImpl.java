package com.test.di06;

public class ServiceImpl {

	private Dao dao;
	
	public ServiceImpl() { }
	
	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}
	
	public Dao getDao() {
		return dao;
	}
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	// 비지니스 로직
	public void biz() {
		dao.add();
	}
}
