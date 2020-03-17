package com.cssl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cssl.entity.Games;
import com.cssl.service.GamesServer;
import com.cssl.service.impl.GamesServerImpl;

/**
 * Servlet implementation class GamesServlet
 */
@WebServlet("/GamesServlet")
public class GamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	private GamesServer gs=new GamesServerImpl();

	/**
	 * @see  get
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
	}

	/**
	 * @see  post
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
   		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		String opr=request.getParameter("opr");
		System.out.println("opr:"+opr);
		if("add".equals(opr)) {
			//添加请求
			//1获取游戏名字 调用业务层方法查询是否存在该游戏
			String name=request.getParameter("name");
			String type=request.getParameter("gtype");
			String com=request.getParameter("gcom");
			String year=request.getParameter("gyear");
			Games g=new Games(name, type, com, Integer.parseInt(year));
			boolean isadd=gs.addGame(g);
			if(isadd) {
				//添加成功 提示添加成功 返回添加界面
				out.print("<script>");
				out.print("alert('添加成功！');");
				out.print("location.href='GamesServlet?opr=list';");
				out.print("</script>");
			}else {
				//添加失败 提示添加失败 返回添加界面
				out.print("<script>");
				out.print("alert('添加失败！');");
				out.print("location.href='add_games.jsp';");
				out.print("</script>");
			}
			
		}else if("select".equals(opr)) {
			//查询请求！			
			String name=request.getParameter("name");
			String type=request.getParameter("type");
			String com=request.getParameter("com");
			String year=request.getParameter("year");
			List<String> nameParams=new ArrayList<String>();
			List<Object> valueParams=new ArrayList<Object>();
			if(name!=null&&name!="") {
				nameParams.add("gameName");
				valueParams.add(name);
			}
			if(type!=null&&type!="") {
				nameParams.add("gameType");
				valueParams.add(type);
			}
			if(com!=null&&com!="") {
				nameParams.add("gameCompany");
				valueParams.add(com);
			}
			if(year!=null&&year!="") {
				nameParams.add("gameYear");
				valueParams.add(year);
			}			
			List<Games> list=gs.findBy(nameParams, valueParams);
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);						
		}else if("list".equals(opr)){
			List<Games> list=gs.queryAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		}else {
			//查询游戏名字是否存在
			String name=request.getParameter("name");
			boolean isfind=gs.queryByName(name);
			out.print(isfind);
			out.flush();
			out.close();
		}
		
	}

}
