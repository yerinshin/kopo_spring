package aop.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 spring aop특징
 1. Runtime 기반
 2. Proxy 기반
 3. 인터페이스 기반 : Employee 형으로 받아야한다. (designer, programmer xx!!)
 
 */
public class EmpMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Employee e = context.getBean("programmer", Employee.class);
//		Employee e = context.getBean("designer", Employee.class);
		e.work();

	}

}
