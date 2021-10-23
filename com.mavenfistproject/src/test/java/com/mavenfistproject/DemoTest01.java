package com.mavenfistproject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.listeners.ListenersEx;


@Listeners(ListenersEx.class)
public class DemoTest01 {

	WebDriver driver;
private Logger log=Logger.getLogger(DemoTest01.class);
	
	@Test
	public void demoTest01()
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	log.info("opening a chrome browser");
	driver=new ChromeDriver();
	driver.get("http:/google.com");
	System.out.println(driver.getTitle());
	driver.close();
	
	}
	
	@Test
	public void demoTest02()
	{
		log.info("In Test 02");
		Assert.assertTrue(false);
	}
	
	@Test
	public void demoTest03()
	{
		log.info("In Test 03");
		throw new SkipException(" Skipping a Test !!");
	}
}




















