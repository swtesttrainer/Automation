package SeleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Data 
{
	public static WebDriver driver;
	public static String data;
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.0\\geckodriver-v0.20.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
        driver.manage().window().maximize();
		driver.get("https://www.google.co.in/");
        
        File src = new File("E:\\SeleniumInput\\Search.xlsx");
        FileInputStream fin = new FileInputStream(src);
        
        XSSFWorkbook wb = new XSSFWorkbook(fin);
        XSSFSheet ws = wb.getSheetAt(0);
        
        int rowcount = ws.getLastRowNum();
        
        for(int rownum=0;rownum<=rowcount;rownum++)
        {
        	data = ws.getRow(rownum).getCell(0).getStringCellValue();
        	driver.findElement(By.name("q")).click();
        	driver.findElement(By.name("q")).sendKeys(data);
        	driver.findElement(By.name("btnK")).click();
        	Thread.sleep(3000);
        	driver.get("https://www.google.co.in/");
        }
        
        
        
        
	}

}
