package com.cssl.service.impl;

import java.util.List;

//import com.cssl.dao.BaseDao;
import com.cssl.dao.GamesDao;
import com.cssl.entity.Games;
import com.cssl.service.GamesServer;

public class GamesServerImpl implements GamesServer {

	private GamesDao gd=new GamesDao();
	
	//查询所有游戏信息方法
	@Override
	public List<Games> queryAll() {
		return gd.findAll();
	}

	
	//通过游戏名字查询游戏是否存在
	@Override
	public boolean queryByName(String name) {
		if(gd.findByName(name)==null) {
			return true;
		}		
		return false;
	}

	
	//增加游戏信息
	@Override
	public boolean addGame(Games game) {
		int c=gd.add_games(game);
		if(c==1) {
			//添加成功
			return true;
		}else if(c==0) {
			//添加失败
			return false;
		}
		return false;
	}


	//条件查询
	@Override
	public List<Games> findBy(List<String> nameParams,List<Object> valueParams) {
		return gd.findBy(nameParams, valueParams);
	}
	


	


}
