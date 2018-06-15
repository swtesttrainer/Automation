package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LittleAdvanced 
{
	public WebDriver driver;
	
	public LittleAdvanced() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		driver.manage().window().maximize();
		
		//Reading values from properties file
		
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\src\\SeleniumBasics\\config.properties");
		prop.load(fin);
		String applicationURL = prop.getProperty("URL");
		driver.get(applicationURL);
		
		String browserName = prop.getProperty("Browser");
		
		String username = prop.getProperty("Username");
		
		//String password = prop.getProperty(key, defaultValue)
		
	}
	
	public void mouseMovements() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		//driver = new ChromeDriver(); // launch the chrome browser
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// MAXIMIZE
		driver.manage().window().maximize();
		
		//NAVIGATE
		driver.get("http://www.spicejet.com/");
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Travel Agent Login")).click();
		
	}
	
	public void screenshot() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		
		// MAXIMIZE
		driver.manage().window().maximize();
		
		//NAVIGATE
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		// SCREENSHOT
		
		File src =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("E:\\SeleniumScreenshot\\amazon.png"));
		
		
	}
	
	public void dragAndDrop() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		//driver = new ChromeDriver(); // launch the chrome browser
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// MAXIMIZE
		driver.manage().window().maximize();
		
		//NAVIGATE
		driver.get("http://jqueryui.com/droppable/");
		
		Thread.sleep(2000);
		
		//Frame
		driver.switchTo().frame(0);
		
		// ACTIONS class
		Actions action = new Actions(driver);
		
		action.clickAndHold(driver.findElement(By.id("draggable"))).
		moveToElement(driver.findElement(By.id("droppable"))).
		release().
		build().
		perform();
		
		
	}
	
	public void browserNavigations() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(3000);
		
		//1) Am going to navigate from flipkart to Amazon
		
		driver.navigate().to("https://www.amazon.in/");
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		
		
	}
	
	public void browserWindowHandling() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Good PopUp #1")).click();
		
		Thread.sleep(2000);
		
		Set<String> handles = driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		
		String parentWindowID = it.next();
		
	 	String childWindowID = it.next();
	 	
	 	//System.out.println(parentWindowID);
	 	
	 	//System.out.println(childWindowID);
	 	
		driver.switchTo().window(childWindowID);
		
		System.out.println(driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowID);
		
	}
	
	public void allOptions() throws InterruptedException
	{
		//System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		//driver = new ChromeDriver(); // launch the chrome browser
		
		//driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		Thread.sleep(2000);
		
		Select select = new Select(driver.findElement(By.id("userRegistrationForm:countries")));
		
		List<WebElement> cntry = select.getOptions();
		
		for(WebElement element : cntry)
		{
			System.out.println(element.getText());
		}
	}
	
	public static void main(String[] args) throws InterruptedException, IOException 
    {
		// TODO Auto-generated method stub
		LittleAdvanced obj = new LittleAdvanced();
		obj.allOptions();
	}

}
