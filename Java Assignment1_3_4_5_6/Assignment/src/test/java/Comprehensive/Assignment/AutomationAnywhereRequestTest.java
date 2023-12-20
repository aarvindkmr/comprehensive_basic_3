package Comprehensive.Assignment;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import comprehensiveAssignment.DriverFactory;

	public class AutomationAnywhereRequestTest {

	    public DriverFactory factory = new DriverFactory();
	    public WebDriver driver;
	    
	    @BeforeTest
	    public void setUp() throws InterruptedException {
	  	 driver=factory.initChromDriver("https://www.automationanywhere.com/");
	  	 Thread.sleep(1000);
	  	 driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	    }
	    @Test
	    public void testRequestDemoNavigation() throws InterruptedException {
	        WebElement requestDemoButton = driver.findElement(By.xpath("//a[@href='/request-live-demo' and @title='Request demo']"));
	        requestDemoButton.click();

	        // Verify that the page is navigated to the correct URL
	        String actualUrl = driver.getCurrentUrl();
	        String expectedUrl = "https://www.automationanywhere.com/request-live-demo";
	        Assert.assertEquals(actualUrl, expectedUrl);
	        Thread.sleep(1000);									
	        // Verify the Label Names for First Name and Last Name
	        WebElement firstNameLabel = driver.findElement(By.xpath("//label[contains(text(),'First Name')]"));
	        WebElement lastNameLabel = driver.findElement(By.xpath("//label[contains(text(),'Last Name')]"));

	        Assert.assertEquals(firstNameLabel.getText(), "*First Name");
	        Assert.assertEquals(lastNameLabel.getText(), "*Last Name");
	    }

	    @AfterTest
	    public void tearDown() {
	        driver.quit();
	    }
	}



