package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ParametrizationDatabase
{
	public WebDriver driver;
	public String input;
	public ExtentReports report;
	public ExtentTest logger;
	
	public ParametrizationDatabase() throws IOException, InterruptedException
	{
		  System.setProperty("webdriver.gecko.driver",fetchProperty("path"));
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(fetchProperty("URL"));
		  Thread.sleep(4000);
		  
		  report = new ExtentReports("D:\\Maven\\myreport.html");
		  logger = report.startTest("NewTest");
	}
	
	public String fetchProperty(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\src\\SeleniumBasics\\config.properties");
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}
	
	public void googleSearchExample(String data) throws IOException
	{
		driver.findElement(By.name("q")).sendKeys(data);
		driver.findElement(By.name("btnK")).click();
		driver.get(fetchProperty("URL"));
		
	}
	
	public void googleSearch() throws IOException, InterruptedException, ClassNotFoundException, SQLException
	{
		 // Connecting to Database
		
		Class.forName("com.mysql.jdbc.Driver"); //MYSQL
		//Class.forName("oracle.jdbc.driver.oracleDriver") // ORACLE 
		
		Connection con = DriverManager.getConnection("jdbc:mysql://mdatabase.ceiskq0mnetb.ap-south-1.rds.amazonaws.com:3306/mdatabase", "musername", "mpassword");
		
		Statement smt = con.createStatement();
		
		ResultSet rs = smt.executeQuery("select * from search");
		
		while(rs.next())
		{
			String val = rs.getString("searchValue");
			driver.findElement(By.name("q")).sendKeys(val);
			driver.findElement(By.name("btnK")).click();
			Thread.sleep(2000);
			driver.get(fetchProperty("URL"));
		}
		
		
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		ParametrizationDatabase obj = new ParametrizationDatabase();
	    obj.googleSearch();
		
	}

}
