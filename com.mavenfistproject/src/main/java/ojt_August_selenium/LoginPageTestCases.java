package ojt_August_selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class LoginPageTestCases {

	WebDriver driver=null;
	Properties prop=null;
	FileInputStream fis;
	//static String filepath ="C:\\Users\\ABC\\eclipse-workspace\\myEclipseWorkspace\\com.mavenfistproject\\config.properties";
	@BeforeClass
	public void setup() 
	{
		try {
			prop=new Properties();
			fis = new FileInputStream("config.properties");	
			prop.load(fis);
		}catch(FileNotFoundException  ff) {
			ff.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));	
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}
	@Test
	public void logotest01()
	{
		Boolean flag=driver.findElement(By.xpath("//img")).isDisplayed();
		Assert.assertTrue(true, "JBK logo is displayed!!");
	}
	@Test
	public void loginJBKtest02()
	{
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | User");
	}
	@Test
	public void openSelenium_pdf_test03()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/selenium-testing-syllabus-jbk.pdf']")).click();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}
	@Test
	public void openPHP_pdf_test04()
	{
		driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div[4]/div/a")).click();
	}
	@Test
	public void openPython_pdf_test05()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/python-syllabus.pdf']")).click();
	}
	@Test
	public void openJ2EE_pdf_test06()
	{
		driver.findElement(By.xpath("//a[@href='../pdf/java-j2ee-syllabus-jbk.pdf']")).click();
	}
	@Test
	public void getHeaderTitle_test07()
	{
		String header=driver.findElement(By.xpath("//span[@class='logo-lg']")).getText();
		Assert.assertEquals(header, "Java By Kiran");
	}
	@SuppressWarnings("unchecked")
	@Test
	public void getUserTabledata_test08()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		List<WebElement> userlist =  (List<WebElement>) driver.findElement(By.xpath("//table[@class='table table-hover']"));
		for(WebElement e:userlist)
		{
			ArrayList<String>list=new ArrayList<String>();
			list.add(e.getText());
		}
	}

	@Test
	public void verifyText_test10()
	{
		String copyright =	driver.findElement(By.xpath("//strong[1]")).getText();
		Assert.assertEquals(copyright, "Copyright © 2005-2019 JavaByKiran.");
	}

	@Test
	public void gettableData_test11()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		String tabledata=driver.findElement(By.xpath("//table[@class='table table-hover']")).getText();
		System.out.println(tabledata);
	}
	@Test
	public void getdata_test12()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();

		for(int i=1;i<=5;i++)
		{
			WebElement xpath=driver.findElement(By.xpath("//table[1]/tbody/tr["+i+"]"));
			System.out.println(xpath.getText());
		}
	}

	@Test
	public void addusertest_test13()
	{
		driver.findElement(By.xpath("//a[@href='users.html']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-block btn-primary btn-sm pull-right']")).click();
		driver.findElement(By.id("username")).sendKeys("asdfgcf");
		driver.findElement(By.id("mobile")).sendKeys("123456");
		driver.findElement(By.id("email")).sendKeys("abcd@gmail.com");
		driver.findElement(By.id("course")).sendKeys("selenium");
		driver.findElement(By.id("Female")).click();
		//driver.findElement(By.id("")).sendKeys("");
		Select oselect =new Select(driver.findElement(By.xpath("/html/body/div/div[1]/section[2]/div/div/div/form/div[1]/div[6]/div/select")));
		oselect.selectByIndex(1);
		driver.findElement(By.id("password")).sendKeys("1234");
		driver.findElement(By.id("submit")).click();
		Alert alert=driver.switchTo().alert();
		String text=alert.getText();
		alert.accept();
		Assert.assertEquals(text, "User Added Successfully. You can not see added user.");
			
	}
	@Test
	public void courseName_test14()
	{
		ArrayList<String> actlist=new ArrayList<String>();
		ArrayList<String> explist=new ArrayList<String>();
		explist.add("Selenium");
		explist.add("Java / J2EE");
		explist.add("Php");
		explist.add("Python");
		List<WebElement>courselist=driver.findElements(By.xpath("//h3"));
		for(WebElement list:courselist)
		{
			String courses=list.getText();
			actlist.add(courses);
		}                                       //	lst.stream().map(WebElement::getText).forEach(lst1::add);
		System.out.println(actlist);
		Assert.assertEquals(actlist, explist);

	}
	@AfterTest
	public void teardowntest()
	{
		driver.close();
		System.out.println(" Test Run ...");
	}



}

/*List<WebElement> lst=d.findElements(By.tagName("a"));
List<String> strings = new ArrayList<String>();
for(WebElement e : lst){
    strings.add(e.getText());
 */


















