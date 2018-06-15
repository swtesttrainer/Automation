package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ParametrizationExcel
{
	public WebDriver driver;
	public String input;
	public ExtentReports report;
	public ExtentTest logger;
	
	public ParametrizationExcel() throws IOException, InterruptedException
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
	
	public void googleSearch() throws IOException, InterruptedException
	{
		File src = new File("D:\\SeleniumInput\\GoogleSearchInputs.xlsx");
		FileInputStream fin = new FileInputStream(src);
		
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet ws = wb.getSheetAt(0);
		
		
		for(int rownum=0;rownum<ws.getLastRowNum();rownum++)
		{
			input = ws.getRow(rownum).getCell(0).getStringCellValue();
			driver.findElement(By.name("q")).sendKeys(input);
			driver.findElement(By.name("btnK")).click();
			Thread.sleep(2000);
			driver.get(fetchProperty("URL"));
			
			logger.log(LogStatus.PASS, "Details Entered");
			report.flush();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		ParametrizationExcel obj = new ParametrizationExcel();
	    obj.googleSearch();
		
	}

}
