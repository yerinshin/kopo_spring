package di.anno01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DriverMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("di-anno01.xml");
		
		Car car = context.getBean("car", Car.class);
		car.prnTireBrand();
		
		/*
		//2.setter 주입방식
		Car car = new Car();
		car.setTire(han);
		car.prnTireBrand();
		*/
		
		/*
		//1.생성자 주입방식
		Car car = new Car(han);
		car.prnTireBrand();
		*/
		
		
		
		/*		
		Car car = new Car();
		car.prnTireBrand();
		 */	
		
	}

}
