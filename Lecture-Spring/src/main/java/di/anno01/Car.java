package di.anno01;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {
	@Autowired				//가장 많이씀 : 생성자, setter 실행하지 않고도 tire 자동주입함
	private Tire tire;

	public Car() {	
		System.out.println("Car()...");
	}
	
//	@Autowired
	public Car(Tire tire) {
		this.tire = tire;
		System.out.println("Car(Tire)...");
	}		
	
//	@Autowired
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()...");
	}
	
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
