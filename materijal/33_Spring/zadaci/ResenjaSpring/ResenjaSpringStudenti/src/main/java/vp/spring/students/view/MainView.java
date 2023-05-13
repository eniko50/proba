package vp.spring.students.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import vp.spring.students.util.Helper;

@Component
public class MainView {
	@Autowired
	StudentView studentView;
	
	@Autowired
	CourseView courseView;
	
	@Autowired
	ExamView examView;
	
	public void start() {
		int option = 0;

		do {
			// unos opcije
			displayMenu();
			System.out.println("\nPlease choose the option: ");	
			option = Integer.parseInt(Helper.input());

			switch (option) {
			case 1:
				studentView.start();
				break;
			case 2: 
				courseView.start();
				break;
			case 3:
				examView.start();
				break;
			}
		} while (option != 4);
	}
	
	private void displayMenu() {
		System.out.println("1. Students");
		System.out.println("2. Courses");
		System.out.println("3. Exams");
		System.out.println("4. Exit");
	}
	
	
	
}
