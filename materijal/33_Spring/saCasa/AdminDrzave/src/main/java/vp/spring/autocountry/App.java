package vp.spring.autocountry;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vp.spring.autocountry.config.AppConfig;
import vp.spring.autocountry.data.RepositoryHelper;
import vp.spring.autocountry.view.CountryView;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CountryView view = context.getBean(CountryView.class);
		view.start();
		
		// SpEL example
		RepositoryHelper helper = context.getBean(RepositoryHelper.class);
		int number = helper.getNumberOfCountries();
		System.out.println("Initial number of countries: " + number);
		
		String name = helper.getFirstCountryName();
		System.out.println("First country was: " + name);
	}
}
