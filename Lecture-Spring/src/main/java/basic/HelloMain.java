package basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
	
		ApplicationContext context 
									= new GenericXmlApplicationContext("beanContainer.xml");						//경로 두개 다 사용 가능!
//									= new FileSystemXmlApplicationContext("src/main/resources/beanContainer.xml"); 	//프로젝트경로부터
//									= new ClassPathXmlApplicationContext("beanContainer.xml");						//내파일 경로부터 ..?
		
		//container 이용해서 객체 가져오는 메소드 : getBean("아이디")
		Hello obj = (Hello)context.getBean("hello");	//getBean() return형  : Object -> 명시적 형변환 필요
	//	System.out.println(obj);
		obj.prnMsg();
		
		Hello obj2 = context.getBean("hello2", Hello.class);			// hello2아이디는 Hello클래스야 :return 형이 Hello로 바뀜
		obj2.prnMsg();
		
		Hello obj3 = context.getBean("hello2", Hello.class);			// 객체 생성하지 않음 
		obj3.prnMsg();
		
		/*
		Hello obj = new Hello();
		obj.prnMsg();
		*/
	}
}
