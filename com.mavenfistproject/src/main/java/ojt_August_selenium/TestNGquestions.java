package ojt_August_selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNGquestions {
	WebDriver driver;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("file:///C:/SELENIUM/Offline%20Website/Offline%20Website/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@Test(alwaysRun = false)
	public void logocheck()
	{
		boolean flag=driver.findElement(By.xpath("//img")).isDisplayed();
		Assert.assertTrue(flag, " Image is cleared");
	}
	
	@Test(enabled = false)
	public void jbkTitle()
	{
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");//fail
	}

	@Test(dependsOnMethods = "jbkTitle" )
	public void logintest()
	{
		driver.findElement(By.id("email")).sendKeys("kiran@gmail.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button")).click();
	}

	@Test(dependsOnMethods = "logintest")
	public void dashTitle()
	{
		String dash= driver.getTitle();
		Assert.assertEquals(dash, "JavaByKiran | Dashboard");
	}
	
	@Test(dependsOnMethods = "dashTitle",alwaysRun = true)
	public void usertest()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}




