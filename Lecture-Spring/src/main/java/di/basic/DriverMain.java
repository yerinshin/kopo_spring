package di.basic;

public class DriverMain {

	public static void main(String[] args) {
		
		//Tire tire = new HankookTire();
		
		HankookTire han = new HankookTire();
		KumhoTire kum = new KumhoTire();
		
		//2.setter 주입방식
		Car car = new Car();
		car.setTire(han);
		car.prnTireBrand();
		
		
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
