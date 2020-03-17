package com.cssl.entity;

public class Games {

	private String gameName;
	private String gameType;
	private String gameCompany;
	private int gameYear;
	
	
	public Games() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Games(String gameName, String gameType, String gameCompany, int gameYear) {
		super();
		this.gameName = gameName;
		this.gameType = gameType;
		this.gameCompany = gameCompany;
		this.gameYear = gameYear;
	}

	public String getGameName() {
		return gameName;
	}
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	public String getGameType() {
		return gameType;
	}
	public void setGameType(String gameType) {
		this.gameType = gameType;
	}
	public String getGameCompany() {
		return gameCompany;
	}
	public void setGameCompany(String gameCompany) {
		this.gameCompany = gameCompany;
	}
	public int getGameYear() {
		return gameYear;
	}
	public void setGameYear(int gameYear) {
		this.gameYear = gameYear;
	}
	
}
