package di.java;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car2 {
	
//	@Autowired(required = false) //자동주입 할 객체 없으면 null 로 반환
	@Autowired		//자동주입 할 객체 없으면 error
	@Qualifier("kumhoTire")
	private Tire tire;

	public Car2() {	
		System.out.println("Car()...");
	}

	/*
	@Autowired
	//생성자는 파라미터가 여러개이기 때문에 해다 파라미터 앞에 @Qualifier 붙임
	public Car(@Qualifier("kumhoTire")Tire tire) {		
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}
	*/		
	
//	@Autowired
//	@Qualifier("kumhoTire")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()...");
	}
	
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
