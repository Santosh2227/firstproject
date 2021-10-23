package com.mavenfistproject;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTest02 {

	public static void main(String[] args) {


	}
	WebDriver driver;
	private Logger log=Logger.getLogger(DemoTest01.class);

	@BeforeClass
	public void setupUrl()
	{
		log.info("Browser Started!!");
		System.setProperty("webdriver.chrome.driver","chromedriver.exe"); 
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("http://javabykiran.com/playground/");

	}

	@Test
	public void demo_test01() {

		log.info("IN test01 -> playground");
		driver.findElement(By.xpath("//*[@id=\"homeSubmenu\"]/li[6]/a")).click();
		WebElement date=driver.findElement(By.xpath("//input[@type='datetime-local']"));
		date.click();
		String datevalue =" 22/06/91";

		selectDateByJS(driver, date, datevalue);
		driver.findElement(By.name("submit")).click();
	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element, String datevalue)
	{
		JavascriptExecutor js=( (JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+datevalue+"');", element);
	}

	@Test
	public void demo_test02()
	{
		driver.findElement(By.xpath("//*[@id=\"homeSubmenu\"]/li[5]/a")).click();
		WebElement user01	=driver.findElement(By.name("username"));
		user01.sendKeys("nbawane51@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@type='submit']")).click();


	}
	@Test
	public void demo_test03()
	{
		driver.findElement(By.xpath("//*[@id=\"homeSubmenu\"]/li[9]/a")).click();
		driver.findElement(By.id("addInputName")).clear();
		driver.findElement(By.id("addInputName")).sendKeys("JavaByKiran | playground");
		driver.findElement(By.id("addInputSlug")).clear();
		driver.findElement(By.id("addInputSlug")).sendKeys("Playing on Ground");
		driver.findElement(By.id("addButton")).click();
	}

	@Test
	public void demo_test04() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"homeSubmenu\"]/li[9]/a")).click();

		//WebElement on which drag and drop operation needs to be performed
		WebElement source = driver.findElement(By.xpath("//*[@id=\"nestable\"]/ol/li[1]"));

		//WebElement to which the above object is dropped
		WebElement destiny = driver.findElement(By.xpath("//*[@id=\"nestable\"]/ol/li[3]/div"));

		//Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);

		//Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(source)
				.moveToElement(destiny)
				.release(destiny)
				.build();
		Thread.sleep(5000);
		//Performing the drag and drop action
		dragAndDrop.perform();
	}
	@AfterTest
	public void teardown()
	{
		driver.quit();

		System.out.println("Test Executed successfully..");
	}

}











