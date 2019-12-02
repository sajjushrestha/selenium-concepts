package sikuli;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Playlist {


	
	WebDriver driver;
	
@BeforeMethod
public void open() throws Exception
{
	
	Runtime.getRuntime().exec("taskkill /f /im chromeriver.exe");
	
	WebDriverManager.chromedriver().version("2.35").setup();
	ChromeOptions opt=new ChromeOptions();
		/*
		 * List<String> list=new ArrayList<String>(); list.add("disable-infobars");
		 * list.add("disable-notifications"); list.add("start-maximized");
		 * opt.addArguments("start-maximized"); opt.addArguments("disable-infobars");
		 */
	
	
	  driver = new ChromeDriver(opt);
	  
	  driver.manage().window().maximize();
	// driver.manage().window().setSize(new Dimension(800,480));
	 
	 driver.navigate().to("https://keepvid.pro/youtube-playlist-downloader");
		/*
		 * String parent=driver.getWindowHandle();
		 * 
		 * driver.switchTo().window(parent);
		 */
	 
	
}


@Test(enabled=false)
public void download() throws Exception
{
	Screen s=new Screen();
	Pattern fileInputTxtBox=new Pattern(".//images//inputbox.png");
	Pattern open=new Pattern(".//images//open.png");
	
	String filename = fileInputTxtBox.getFilename();
	System.out.println(filename);
		
		  driver.findElement(By.xpath(".//*[@id='photoimg']")).click();
		  s.wait(fileInputTxtBox, 10); 
		  s.type(fileInputTxtBox,filename);
		  s.click(open);
		 
}

@Test
public void downloadPLaylist() throws Exception
{
  WebDriverWait wait=new WebDriverWait(driver,300);
  
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("videourl"))).sendKeys("https://www.youtube.com/watch?v=29O3CCYOzic&list=PLVHgQku8Z937wHNqd2z_8_ze_HBVhfBRt");
	String parent=driver.getWindowHandle();
	
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("downloadbtn"))).click();
	driver.switchTo().window(parent);
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-outline-primary'][text()='Download'])[1]")));
	
	List<WebElement> l=driver.findElements(By.xpath("(//button[@class='btn btn-outline-primary'][text()='Download'])"));
	
	int n=l.size();
	
	for(int i=1;i<=n;i++)
	{
		Thread.sleep(2000);	
		
		WebElement dload=driver.findElement(By.xpath("(//button[@class='btn btn-outline-primary'][text()='Download'])["+i+"]"));
		
		js.executeScript("arguments[0].scrollIntoView(true)", dload);
		
		Thread.sleep(2000);
		dload.click();
		
		Thread.sleep(3000);
		
		String child=driver.getWindowHandle();
		
		driver.switchTo().window(child);
		
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		
		driver.close();
		
		driver.switchTo().window(parent);
		
	}
	
}

}
