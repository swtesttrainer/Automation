package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.*;

import com.sun.jna.platform.FileUtils;

public class SeleniumTopics 
{
	public WebDriver driver;
	
	public void explicitWAIT()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        WebElement searchTextBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        
        searchTextBox.click();
        
        searchTextBox.sendKeys("Samsung S8 Mobile");
	}
	
	
	public void handlingPopUps() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        
        driver.findElement(By.name("proceed")).click();
        
        Thread.sleep(5000);
        
        Alert alert = driver.switchTo().alert();
        
        alert.accept();
        
	}
	
	public void practise() throws InterruptedException 
	{
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		// MAXIMIZE
		driver.manage().window().maximize();
		
		//driver.navigate().to("https://www.amazon.in/");
       // driver.get("https://www.amazon.in/");
		driver.get("http://www.spicejet.com/");
        
       Actions action = new Actions(driver);
       Thread.sleep(2000);
       action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
       Thread.sleep(3000);
       driver.findElement(By.linkText("Travel Agent Login")).click();
       //action.moveToElement(driver.findElement(By.id("nav-link-wishlist"))).build().perform();
       
       //action.moveToElement(driver.findElement(By.linkText("Travel Agent Login"))).click().build().perform();
       //Thread.sleep(3000);
       //driver.findElement(By.linkText("Create a Wish List")).click(); 
        
        
	}
	
	
	public void fileUpload()
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		//driver = new ChromeDriver(); // launch the chrome browser
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// MAXIMIZE
		driver.manage().window().maximize();
		
		//NAVIGATION
		driver.get("https://html.com/input-type-file/");
		
		driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\Admin\\Desktop\\28-05-2018.txt");
		
	}
	
	public void OR() throws IOException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\src\\OR.properties");
		
		prop.load(fin);
		
		String url = prop.getProperty("URL");
		System.out.println(url);
		
		driver.get(url);
		
	}
	
	public void popupTest() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Thread.sleep(3000);
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWndID = it.next();
		
		String childWndID = it.next();
		
		System.out.println("Parent Window ID :- "+parentWndID);
		
		System.out.println("Parent Window ID :- "+childWndID);
	
		driver.switchTo().window(childWndID);
		
		System.out.println(driver.getTitle());
	}
	
	
	public void freeCRM() throws InterruptedException, IOException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		//driver = new ChromeDriver(); // launch the chrome browser
		

		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.freecrm.com/index.html");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		org.apache.commons.io.FileUtils.copyFile(src, new File("d:\\June\\freeCRM.png"));
		
		
		
	    /*Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("badri_20");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("welcome123");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(20000);
		
		driver.switchTo().frame("mainpanel");
		
		driver.findElement(By.linkText("Contacts")).click();*/
		
		
	}
	
	public void practisse() throws InterruptedException
	{
		/*System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		driver.manage().window().maximize();*/
		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("http://jqueryui.com/droppable/");
		
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Actions action = new Actions(driver);
		
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		action.clickAndHold(drag).moveToElement(drop).release().build().perform();
	}
	
	public static void main(String[] args) throws InterruptedException, IOException 
	{
		// TODO Auto-generated method stub
		SeleniumTopics obj = new SeleniumTopics();
		obj.OR();
	}

}
