package comprehensiveAssignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	public WebDriver driver;
	
	public WebDriver initChromDriver(String url) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //driver.manage().deleteAllCookies();
		return driver;
		
	}
	

}
