package FrameworkPractice;

import org.openqa.selenium.WebDriver;

public class CalendarSelectFutureMonthDates {
	static WebDriver driver;

	public static void main(String[] args) {
		
		
		
		

	}
	
	public static void selectDateFromCalendar(String day, String month, String year) {
		
		if(month.equals("February") && Integer.parseInt(day) > 29) {
			return;
		}
		else {
			
			//while()
		}
	}

}
