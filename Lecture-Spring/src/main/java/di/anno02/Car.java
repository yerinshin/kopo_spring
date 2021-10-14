package di.anno02;

import javax.annotation.Resource;

public class Car {
	
	@Resource
	private Tire tire;

	public Car() {	
		System.out.println("Car()...");
	}
	//@Resource는 생성자에는 못붙임
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}		
	
//	@Resource
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()...");
	}
	
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
