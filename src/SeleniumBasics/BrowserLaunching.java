package SeleniumBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserLaunching 
{
	public static WebDriver driver;
	public String browserTitle;
	public String currURL;
	public String pageSource;
	public void launchChrome()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.0\\chromedriver.exe");
		driver = new ChromeDriver(); // launch the chrome browser
		// MAXIMIZE
		driver.manage().window().maximize();
		
		// Loading webpage
		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.id("lst-ib")).click();
		driver.findElement(By.id("lst-ib")).sendKeys("Microsoft");
		
		// TITLE
	/*	browserTitle = driver.getTitle();
		System.out.println("Browser title is "+browserTitle);
		
		// URL
		currURL = driver.getCurrentUrl();
		System.out.println("My current URL is "+currURL);
		
		try 
		{
			Thread.sleep(5000);//this line will help us to wait for 5 seconds
		}
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// driver.google("capgemini");
		
		
		//Page source
		//pageSource = driver.getPageSource();
		//System.out.println("Page source is :-"+pageSource);
		
		//Closing
		//driver.close(); // THis can be used if it is a single window
		
		//driver.quit(); //This can be used if you have multiple windows 
		
		//driver.manage().window().setPosition(new Point(0, -1000));
	}
	
	public void googleSearch(WebDriver driver)
	{
		driver.findElement(By.id("lst-ib")).click();
		driver.findElement(By.id("lst-ib")).sendKeys("Microsoft");
	}
	
	
	

	public void numOfLinks() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.google.co.in/");
        
        Thread.sleep(5000);
        
        List<WebElement> links =  driver.findElements(By.tagName("a"));
        
        System.out.println(links.size());
	}
	
	
	
	
	public void radioButton() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
        
        Thread.sleep(3000);
        
        driver.findElement(By.id("userRegistrationForm:gender:0")).click();
        
	}
	
	
	
	public void ddl() throws InterruptedException  
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
        
       // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        //Thread.sleep(20000); //waste of time
        
        //20 => Maximum time
        
        
        //driver.findElement(By.id("userRegistrationForm:countries"))
        
        Select ddl = new Select(driver.findElement(By.id("userRegistrationForm:securityQ")));
        
        //ddl.selectByIndex(1);
        
        ddl.selectByValue("1");
        
	}
	
	
	
	public void checkBox() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.freecrm.com/register/");
        
        Thread.sleep(3000);
        
        driver.findElement(By.name("agreeTerms")).click();
        
        
        WebElement abc = driver.findElement(By.name("agreeTerms"));
        
        System.out.println(abc.isSelected()); // => true
        
        if(abc.isSelected())
        {
        	System.out.println("Checkbox is Enabled");
        }
        else
        {
        	System.out.println("Checkbox is not Enabled");
        }
	
       // System.out.println(isChecked);
        
	}
	
	
	
	public void launchFirefox() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.facebook.com/");
        
        Thread.sleep(5000);
		
		/*driver.findElement(By.id("lst-ib")).click();
		driver.findElement(By.id("lst-ib")).sendKeys("Microsoft");
		
		driver.findElement(By.name("btnK")).click();*/
		
		//driver.findElement(By.className("LM6RPg")).click();
		//driver.findElement(By.className("LM6RPg")).sendKeys("Samsung S8");
        
        //driver.findElement(By.linkText("Sign up")).click();
        
       // driver.findElement(By.partialLinkText("Forgot")).click();
        
        //driver.findElement(By.xpath("//a[contains(text(),'Gmail')]")).click();
        
       /* driver.findElement(By.xpath("//input[@id='lst-ib']")).click();
        driver.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("IPL");
        
        driver.findElement(By.xpath("//input[@name='btnK']")).click();*/
        
        //driver.findElement(By.cssSelector("input[id='lst-ib']")).click();
        //driver.findElement(By.cssSelector("input[id='lst-ib']")).sendKeys("Sunrisers");        
       /* WebElement ele = driver.findElement(By.name("firstname"));
       ele.click();
       ele.sendKeys("Aravindh");
        
        //driver.findElement(By.id("u_0_n")).sendKeys("Badri");
        
        driver.findElement(By.id("u_0_p")).click();
        driver.findElement(By.id("u_0_p")).sendKeys("Rajagopal");
        
        driver.findElement(By.id("u_0_s")).click();
        driver.findElement(By.id("u_0_s")).sendKeys("Badri@gmail.com");
        
        driver.findElement(By.id("u_0_z")).click();
        driver.findElement(By.id("u_0_z")).sendKeys("Password123");*/
        
        
        
	}
	
	
	public void newFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://www.facebook.com/");
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("badri@gmail.com");
        
        WebElement pwd;
        WebDriverWait wait = new WebDriverWait(driver,30);
        pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        pwd.click();
        pwd.sendKeys("password123");
        
	}
	
	public void launchIE()
  	{
		System.setProperty("webdriver.ie.driver", "D:\\Selenium 3.0\\IEDriverServer_x64_3.6.0\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		
		
	}
	
	public void rediff()
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("http://www.rediff.com/");
        
        driver.findElement(By.linkText("Sign in")).click();
        
        driver.findElement(By.name("proceed")).click();
        
        Alert obj = driver.switchTo().alert();
        obj.accept();
	}
	
	
	public void thoughtWorks() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
        driver.get("https://html.com/input-type-file/");
        
        driver.findElement(By.name("fileupload")).sendKeys("C:\\Users\\Admin\\Desktop\\Badri_SDET_Lead.doc");
        
        Thread.sleep(2000);
        
        
        
        
	}
	
	public void freeCRM() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
        driver.get("https://www.freecrm.com/index.html");
        driver.manage().deleteAllCookies();
        
       Thread.sleep(5000);
        
      // driver.findElement(By.xpath("\\*[@placeholder='Username']")).click();
        //driver.findElement(By.xpath("\\*[@placeholder='Username']")).sendKeys("badri_20");
       driver.findElement(By.name("username")).sendKeys("badri_20");
     //   driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("welcome123");
        
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        
        Thread.sleep(2000);
        
        driver.switchTo().frame("mainpanel");
        
        driver.findElement(By.linkText("Contacts")).click();
        
        driver.switchTo().defaultContent();
        
        
	}
	
	
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		BrowserLaunching obj = new BrowserLaunching();
		//obj.launchChrome();
		//obj.googleSearch(driver);
		 obj.ddl();
		//obj.launchIE();
	}

}
