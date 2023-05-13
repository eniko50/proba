package vp.spring.autocountry.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Before("execution(* vp.spring.autocountry.service.CountryService.*(..))")
	public void logEvent() {
		System.out.println("CountryService method called.");
	}
	
	@Around("execution(* vp.spring.autocountry.service.CountryService.*(..))")
	public Object logEvent(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("Before method " + jp.getSignature());
		
		Object result = jp.proceed();
		
		System.out.println("After method: " + jp.getSignature());
		
		return result;
	}
	
	@Before("@annotation(vp.spring.autocountry.aspect.LogEvent)")
	public void logAnnotatedMethod() {
		System.out.println("LogEvent: before method");
	}
}
