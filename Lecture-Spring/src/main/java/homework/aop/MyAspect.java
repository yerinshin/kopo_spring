package homework.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class MyAspect {
	
//	@AfterReturning("execution( * homework.aop.*.setAge(..))")	//try에 실행 (예외발생하면 실행 x)
	@After("execution( * homework.aop.*.setAge(..))")			//finally (예외 발생 상관없이 실행 )
	public void checkAdult(JoinPoint joinPoint){
	//	System.out.println("checkAdult...");
	//	System.out.println(Arrays.toString(joinPoint.getArgs()));
		
		Object[] args = joinPoint.getArgs();
		if((Integer)args[0] < 20) {
			System.out.println("미성년입니다");
		} else {
			System.out.println("성년입니다");
		}
		
	}
	
//	@Around("execution( * homework.aop.*.setAge(..))")
	public void checkAdult2(ProceedingJoinPoint joinPoint) throws Throwable {
		
		//after
		/*
		joinPoint.proceed();
		System.out.println("checkAdult2...");
		*/
		
		joinPoint.proceed();
		
		Object[] args = joinPoint.getArgs();
		if((Integer)args[0] < 20) {
			System.out.println("미성년입니다");
		} else {
			System.out.println("성년입니다");
		}
	}
	
	@AfterThrowing(pointcut="execution( * homework.aop.*.setAge(..))", throwing="ex")	//catch 일때 실행
	public void error(JoinPoint joinPoint, Throwable ex) {
		System.out.println("예외처리 : " + ex.toString());	
	}
}
