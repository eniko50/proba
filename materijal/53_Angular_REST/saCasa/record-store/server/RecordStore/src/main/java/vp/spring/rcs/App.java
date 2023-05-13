package vp.spring.rcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App 
{
    
	@Autowired
	TestData testData;
	
	public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
