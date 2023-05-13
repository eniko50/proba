package vp.spring.country;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vp.spring.country.config.AppConfig;
import vp.spring.country.view.CountryView;

public class App {
    public static void main( String[] args ) {
    	ApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        // CountryView je Bean, pa instancu uzimamo iz konteksta
    	CountryView view = context.getBean(CountryView.class);
    	
    	// Spring je kreirao CountryView instancu i u nju injektovao 
    	// CountryService pri pozivu konstruktora klase CountryView
        // koristimo tu instancu i pozivamo njenu metodu start
    	view.start();
    }
}
