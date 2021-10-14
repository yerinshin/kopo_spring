package di.basic;

public class Car {
	
	//의존관계 발생
	private Tire tire;
	
	//1. DI(의존주입) : 생성자 주입 -> 의존성 객체를 생성자를 통해 받아옴
	public Car(Tire tire) {
		this.tire = tire;
	}
	
	
	public Car() {	//타이어 장착 안된 자동차 하나 만들기
		
	}
		
	/*
	public Car() {
		//의존관계 설정
		tire = new KumhoTire();
//		tire = new HankookTire();
		
	}
	*/

	// 2. DI(의존주입) : setter 주입
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()...");
	}
	
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
