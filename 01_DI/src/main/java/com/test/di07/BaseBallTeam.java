package com.test.di07;

public class BaseBallTeam {

	private String manager;
	private String battingCoach;
	private String pitcherCoach;
	private String hitter;
	private String pitcher;
	
	public BaseBallTeam() {	} // 기본 생성자
	public BaseBallTeam(String manager, String battingCoach, String pitcherCoach) {
		this.manager = manager;
		this.battingCoach = battingCoach;
		this.pitcherCoach = pitcherCoach;
		
	} // 인자 생성자
	
	
	
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getBattingCoach() {
		return battingCoach;
	}
	public void setBattingCoach(String battingCoach) {
		this.battingCoach = battingCoach;
	}
	public String getPitcherCoach() {
		return pitcherCoach;
	}
	public void setPitcherCoach(String pitcherCoach) {
		this.pitcherCoach = pitcherCoach;
	}
	public String getHitter() {
		return hitter;
	}
	public void setHitter(String hitter) {
		this.hitter = hitter;
	}
	public String getPitcher() {
		return pitcher;
	}
	public void setPitcher(String pitcher) {
		this.pitcher = pitcher;
	}
	
	
}
