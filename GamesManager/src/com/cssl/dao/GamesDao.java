package com.cssl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cssl.entity.Games;



public class GamesDao {

	public BaseDao bd=new BaseDao();
	//查询所有游戏方法
	public List<Games> findAll(){
		List<Games> list=new ArrayList<Games>();
		String sql="select * from games";
		ResultSet rs=bd.query(sql);
		try {
			while(rs.next()) {
				String gameName=(String)rs.getString("gameName");
				String gameType=(String)rs.getString("gameType");
				String gameCompany=(String)rs.getString("gameCompany");
				int gameYear=rs.getInt("gameYear");
				Games g=new Games(gameName, gameType, gameCompany, gameYear);
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return list;
	}
	
	public Games findByName(String name) {
		Games g=null;
		String sql="select * from Games where gameName=?";
		ResultSet rs=bd.query(sql, name);
		try {
			if(rs!=null)
			while(rs.next()) {				
				String gameName=(String)rs.getString("gameName");
				String gameType=(String)rs.getString("gameType");
				String gameCompany=(String)rs.getString("gameCompany");
				int gameYear=rs.getInt("gameYear");
				g=new Games(gameName, gameType, gameCompany, gameYear);			
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			bd.closeAll();
		}
		return g;
	}
	
	/*
	 * 添加游戏信息
	 * 添加成功返回1 失败返回0
	 */
	public int add_games(Games game) {
		String sql="INSERT INTO games (gameName,gameType,gameCompany,gameYear) VALUES (?,?,?,?);";		
		return bd.update(sql, game.getGameName(),game.getGameType(),game.getGameCompany(),game.getGameYear());
	}
	
	
	/*
	 *按条件查询游戏
	 * 传入参数查询 为空则不添加
	 */
	public List<Games> findBy(List<String> nameParams,List<Object> valueParams){
		if(nameParams.size()==0&&valueParams.size()==0) {
			return findAll();
		}
		List<Games> list=new ArrayList<Games>();
		String sql="select * from games where ";
		for(int i=0;i<valueParams.size();i++) {
			if(nameParams.get(i).equals("gameName")) {
				sql+=""+nameParams.get(i)+" like '%"+valueParams.get(i)+"%' ";
			}else {
				sql+=nameParams.get(i)+"='"+valueParams.get(i)+"'";
			}
			if(i!=valueParams.size()-1) {
				sql+=" and ";
			}
		}
		System.out.println(sql);
		ResultSet rs=bd.query(sql);
		try {
			while(rs.next()) {
				
				String gameName= rs.getString("gameName");
				String gameType= rs.getString("gameType");
				String gameCompany= rs.getString("gameCompany");
				String gameYear= rs.getString("gameYear");
				Games g=new Games(gameName, gameType, gameCompany, Integer.parseInt(gameYear));
				list.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			bd.closeAll();
		}
		return list;
	}
}
