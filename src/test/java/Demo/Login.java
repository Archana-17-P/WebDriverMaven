package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public static WebDriver driver;
	
	@BeforeSuite
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
		driver.get("https://www.gmail.com");
	
	}
	
	@Test
	public void enterTest() throws InterruptedException{
		System.out.println("Hello");
		driver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("apurva@gmail.com");
		
		driver.findElement(By.xpath("//*[@id='identifierNext']/div/button/span")).click();		
		
		Thread.sleep(3000);
	}
	
	@AfterTest()
	public void tearDown(){
		driver.close();
	}
}
