package vp.spring.autocountry.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.autocountry.service.SecurityService;

@Component
@Aspect
public class LogAspect {

	@Autowired
	SecurityService securityService;
		
	@Before("@annotation(vp.spring.autocountry.aspect.LogEvent)")
	public void logAnnotatedMethod() {
		System.out.println("LogEvent: before method");
	}
	
	@Before("@annotation(vp.spring.autocountry.aspect.IsAuthenticated)")
	public void checkAuthentication() {
		if (!securityService.isLoggedIn()) {
			throw new RuntimeException("Korisnik nije ulogovan!!!");
		}
	}
	
	@Before("@annotation(vp.spring.autocountry.aspect.IsAdmin)")
	public void checkAdministrator() {
		if (!securityService.isAdmin()) {
			throw new RuntimeException("Nisi admin!");
		}
	}
	
	// TODO: Comment
//	@Around("@annotation(vp.spring.autocountry.aspect.IsAdmin)")
//	public Object checkAdmin(ProceedingJoinPoint jp) throws Throwable {
//		if (securityService.isAdmin()) {
//			return jp.proceed();
//		}
//		
//		return null;
//	}
}
