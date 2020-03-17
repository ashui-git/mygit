package com.cssl.service;

import java.util.List;

import com.cssl.entity.Games;

public interface GamesServer {

	//查询所有游戏信息方法
	public List<Games> queryAll();
	
	
	//通过游戏名字查询游戏信息方法
	public boolean queryByName(String name);
	
	
	//增加游戏信息
	public boolean addGame(Games game);
	
	//条件查询
	public List<Games> findBy(List<String> nameParams,List<Object> valueParams);

}
