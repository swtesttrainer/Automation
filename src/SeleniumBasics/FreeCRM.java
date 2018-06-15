package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.WebConsole.Logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class FreeCRM 
{
	public WebDriver driver;
	public Properties prop;
	public int responseCode;
	public ExtentReports report;
	public ExtentTest logger;
	
	public String fetchProperty(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\src\\SeleniumBasics\\config.properties");
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}
	
	public FreeCRM() throws IOException, InterruptedException
	{
		report = new ExtentReports("D:\\Inputs\\MyNewExtentReport12.html");
		logger = report.startTest("CRM Testing");
		
	  System.setProperty("webdriver.gecko.driver",fetchProperty("path"));
	  driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get(fetchProperty("URL"));
	  Thread.sleep(4000);
	  //report.flush();
	  logger.log(LogStatus.PASS,"Site Loaded");
	  report.flush();
	}
	
	public void brokenLinks() throws MalformedURLException, IOException
	{
		System.out.println(driver.getTitle());
		
		//Extracting all links in the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total Number of Links :- "+links.size());
		
		//Creating ArrayList object
		ArrayList<WebElement> activeLinks = new ArrayList<>();
		
		//Extracting all activeLinks and storing in ArrayList
		for(int index=0;index<links.size();index++)
		{
			if(links.get(index).getAttribute("href")!=null)
			{
				activeLinks.add(links.get(index));
			}
		}
		
		for(int index=0;index<activeLinks.size();index++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(index).getAttribute("href")).openConnection();
			connection.connect();
			responseCode = connection.getResponseCode();
			connection.disconnect();
			System.out.println(activeLinks.get(index).getAttribute("href")+" ----> "+responseCode);
		}
		
		
	}
	
	public void report(LogStatus status,String desc)
	{
		
		logger.log(status, desc);
	}
	
	public void login() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath(fetchProperty("usernameTxtBox"))).sendKeys(fetchProperty("Username"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(fetchProperty("passwordTxtBox"))).sendKeys(fetchProperty("Password"));
		Thread.sleep(2000);
		driver.findElement(By.xpath(fetchProperty("loginBTN"))).click();
		Thread.sleep(10000);
		
		logger.log(LogStatus.PASS, "Logged In Successfully");
	}
	
	public void inbuiltFunctionsExample() throws IOException, InterruptedException
	{
		WebElement chkBox = driver.findElement(By.xpath(fetchProperty("checkboxProp")));
		/*if(chkBox.isDisplayed())
		{
			chkBox.click();
		}
		else
		{
			System.out.println("Checkbox is not displayed / Not present in the webpage");
		}*/
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.xpath(fetchProperty("submitBTN")));
		if(submit.isEnabled())
		{
			System.out.println("It is enabled");
		}
		else
		{
			System.out.println("It is disabled");
		}
		Thread.sleep(2000);
		chkBox.click();
		Thread.sleep(2000);
		if(submit.isEnabled())
		{
			System.out.println("It is enabled");
		}
		else
		{
			System.out.println("It is disabled");
		}
		
		
	}
	
	

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		FreeCRM obj = new FreeCRM();
		//obj.inbuiltFunctionsExample();
		//obj.login();
		//obj.brokenLinks();
	}

}
