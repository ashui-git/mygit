package cn.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import cn.springdemo.HelloSpring;

public class SpringTest {

	@SuppressWarnings("resource")
	@Test
	public void test() {
		//获取spring配置文件 借助applicationcontext 接口
		
		ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		HelloSpring helloSpring=(HelloSpring)context.getBean("helloSpring");
		helloSpring.print();
	}

}
