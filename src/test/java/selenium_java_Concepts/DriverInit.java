package selenium_java_Concepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInit {

	private static DriverInit driverSingleton=null;
	
    private WebDriver driver;
    
    private DriverInit()
    {
    	
    }
	
    
    public WebDriver openBrowser()
    {
    	WebDriverManager.chromedriver().version("2.35").setup();
    	driver=new ChromeDriver();
    	
    	return driver;
    }
    
    
    public static DriverInit getInstance()
    {
    	if(driverSingleton==null)
    		driverSingleton=new DriverInit();
    	return driverSingleton;
    	
    }
}
