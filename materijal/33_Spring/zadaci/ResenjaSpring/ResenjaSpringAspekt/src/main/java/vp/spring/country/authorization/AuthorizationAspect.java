package vp.spring.country.authorization;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AuthorizationAspect {
	
	@Autowired
	AuthorizationManager authManager;
	
	// Aspekt se primenjuje nad metodama cije ime pocinje na "remove" u
	// klasama cije ime zavrsava na Service iz paketa service.
	// Dozvoljava poziv metode samo ako ulogovani korisnik ima ulogu "admin"
	@Around("execution(* vp.spring.country.service.*Service.remove*(..))")
	public Object checkUserRole(ProceedingJoinPoint jp) throws Throwable {
		// preuzmemo ulogu trenutno ulogovanog korisnika
		String role = authManager.getLoggedUser().getRole();
		
		// samo ako je admin, moze da izvrsi metodu
		if (role.equals("admin")) {
			Object result = jp.proceed();
			return result;
		} else {
			System.out.println("You are not authorized to execute this action.");
			return null;
		}
	}
}
