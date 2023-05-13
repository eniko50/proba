package vp.spring.students;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vp.spring.students.config.AppConfig;
import vp.spring.students.view.MainView;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		MainView mainView = context.getBean(MainView.class);

		mainView.start();
	}
}
