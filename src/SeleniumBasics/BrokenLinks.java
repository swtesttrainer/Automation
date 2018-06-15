package SeleniumBasics;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.protocol.Resultset;

public class BrokenLinks 
{
	public WebDriver driver;
	public Properties prop;
	public int responseCode;
	
	public BrokenLinks() throws IOException, InterruptedException
	{
		  System.setProperty("webdriver.gecko.driver",fetchProperty("path"));
		  driver = new FirefoxDriver();
		  driver.manage().window().maximize();
		  driver.get(fetchProperty("URL"));
		  Thread.sleep(4000);
	}
	
	public String fetchProperty(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fin = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AutomationTesting\\src\\SeleniumBasics\\config.properties");
		prop.load(fin);
		String value = prop.getProperty(key);
		return value;
	}
	
	public void findBrokenLinks() throws MalformedURLException, IOException
	{
		// Fetching all the links from the given webpage
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		// Creation of ArrayList
		ArrayList<WebElement> activeLinks = new ArrayList();
		
		// Identifying href which are not null
		for(int i=0;i<links.size();i++)
		{
			if(links.get(i).getAttribute("href")!=null && (!links.get(i).getAttribute("href").contains("javascript"))) // where != stands for not equals
			{
				activeLinks.add(links.get(i)); // here we are storing all the links which are having proper href (href which are not null)
			}
		}
		
		// Capturing of response code using HTTPUrlConnection Class
		for(int i=0;i<activeLinks.size();i++)
		{
			HttpURLConnection connection = (HttpURLConnection)new URL(activeLinks.get(i).getAttribute("href")).openConnection(); // we are establishing a connection with the URL
			connection.connect();
			responseCode = connection.getResponseCode();
			System.out.println(activeLinks.get(i).getAttribute("href")+ " --> "+responseCode);
			connection.disconnect();
		}
		
	}
	
	public void dbConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://mdatabase.ceiskq0mnetb.ap-south-1.rds.amazonaws.com:3306/mdatabase", "musername", "mpassword");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from exportData");
		while(rs.next())
		{
			int empid = rs.getInt("empid");
			String firstName = rs.getString("firstName");
			System.out.println(empid);
			System.out.println(firstName);
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub
		BrokenLinks obj = new BrokenLinks();
		obj.dbConnection();
	}

}
