package homework.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PersonMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("homework-aop.xml");
		
		
		  Person person = context.getBean("man", Person.class); 
		 
		  try {
			  person.setAge(25);
			  person.setAge(-15);
		  } catch(Exception e ) {
		
		  }
		 
	}

}
