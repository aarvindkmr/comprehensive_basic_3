package Comprehensive.Assignment;
import org.testng.annotations.Test;
import comprehensiveAssignment.DriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class AutomationAnywhereTest {
  public DriverFactory factory = new DriverFactory();
  public WebDriver driver;
  
  @BeforeTest
  public void setUp() throws InterruptedException {
	 driver=factory.initChromDriver("https://www.automationanywhere.com/");
	 Thread.sleep(1000);
	 driver.findElement(By.id("onetrust-accept-btn-handler")).click();
  }
  @Test
  public void testProcessDiscoveryNavigation() throws InterruptedException {
      WebElement productsMenu = driver.findElement(By.xpath("//a[@href='/products']"));
    //a[(@text(),'Process Discovery')]
      //WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[contains(@text(),'Process Discovery')]"));

      // Do Mouse over on Products
      Actions action =new Actions(driver);
      
      action.moveToElement(productsMenu).build().perform();
      Thread.sleep(3000);
      WebElement processDiscoveryLink = driver.findElement(By.xpath("//a[@href='/products/process-discovery']"));
      processDiscoveryLink.click();
      
       
    
     
   
      // Click on Process Discovery

      // Verify that it's navigating to the correct URL
      String actualUrl = driver.getCurrentUrl();
      String expectedUrl = "https://www.automationanywhere.com/products/process-discovery";
      Assert.assertEquals(actualUrl, expectedUrl);
  }
  @AfterTest
  public void tearDown() {
      driver.quit();
  }

}
