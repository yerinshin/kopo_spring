package aop.pojo;

public class Manager implements Employee {
	
	public void work() {
		Action.gotoOffice();
		System.out.println("팀원들과 회의를 합니다");
		Action.getoffOffice();
	
	}
}
