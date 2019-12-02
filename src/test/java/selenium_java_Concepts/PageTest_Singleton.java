package selenium_java_Concepts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PageTest_Singleton {

	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		
		DriverInit instanceDriver=DriverInit.getInstance();
		driver=instanceDriver.openBrowser();
	}
	
	@Test
	public void method1()
	{
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
	}
	
	
	  @Test public void method2() 
	  { 
		  driver.get("https://fb.com");
	  System.out.println(driver.getTitle()); 
	  }
	 
	
	
}
