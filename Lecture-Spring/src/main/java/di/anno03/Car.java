package di.anno03;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Resource(name="hankookTire")			//@Resource 는 이름매칭 부터 : hankookTire주입
	@Qualifier("kumhoTire")   
//	@Resource								//넥센 @Component("tire") 이므로 이거먼저 매칭
//	@Qualifier("kumhoTire")					//그러므로 여기서 error
	private Tire tire;

	public Car() {	
		System.out.println("Car()...");
	}
	
//	@Resource(name="hankookTire")
	public void setTire(Tire tire) {
		this.tire = tire;
		System.out.println("setTire()...");
	}
	
	public void prnTireBrand() {
		System.out.println("장착된 타이어 : " + tire.getBrand());
	}
	
}
