package cn.springdemo;

public class HelloSpring {

	//定义变量who 它的值通过sprig框架进行注入
	private String who;

	public void print() {
		System.out.println("hello,"+this.getWho()+"!");
	}
	
	public String getWho() {
		return who;
	}

	public void setWho(String who) {
		this.who = who;
	}
	
}
