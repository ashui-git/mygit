package com.cssl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/*
 * 基层工具
 */
public class BaseDao {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet res;
	
	/*
	 * 通过连接池获取连接
	 */
	public Boolean getCon() {
		try {
			Context text= new InitialContext();
			DataSource ds=(DataSource) text.lookup("java:comp/env/jdbc/games");
			con=ds.getConnection();
			return true;
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * 通用的查询方法
	 */
	public ResultSet query(String sql,Object...params) {
		if(getCon()) {
			try {
				pre=con.prepareStatement(sql);
				if(params.length>0&&params!=null) {
					for(int i=0;i<params.length;i++) {
						pre.setObject(i+1, params[i]);
					}
				}
				res=pre.executeQuery();
				return res;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
		
	}

	/*
	 * 通用增删改方法
	 */
	public int update(String sql,Object...params) {
		int conse;
		if(getCon()) {
			try {
				pre=con.prepareStatement(sql);
				for(int i=0;i<params.length;i++) {
					pre.setObject(i+1, params[i]);
				}
				conse=pre.executeUpdate();
				return conse;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				closeAll();
			}
		}
		return 0;
	}

	/*
	 * 关闭所有资源方法
	 */
	public void closeAll() {
		try {
			if (res != null) {
				res.close();
				res=null;
			} 
			if(pre!=null) {
				pre.close();
				pre=null;
			}
			if(con!=null) {
				con.close();
				con=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
